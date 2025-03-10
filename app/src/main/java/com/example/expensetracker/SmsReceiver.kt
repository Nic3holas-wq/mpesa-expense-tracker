package com.example.expensetracker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import com.example.expensetracker.model.Transaction
import com.example.expensetracker.model.TransactionDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION == intent.action) {
            // Start Foreground Service to keep SMS processing active
            val serviceIntent = Intent(context, ForegroundSmsService::class.java)
            context.startService(serviceIntent)

            for (smsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                val messageBody = smsMessage.messageBody
                Log.d("SmsReceiver", "Received SMS: $messageBody")

                if (messageBody.contains("M-PESA", ignoreCase = true)) {
                    val extractedData = extractMpesaDetails(messageBody)
                    extractedData?.let { saveTransaction(context, it) }
                }
            }
        }
    }

    private fun extractMpesaDetails(message: String): Transaction? {
        val type = if (Regex("sent|paid", RegexOption.IGNORE_CASE).containsMatchIn(message)) "S" else "R"
        val amountRegex = Regex("Ksh\\s?(\\d+,?\\d*\\.?\\d*)\\s(sent|from|paid)")
        val balanceRegex = Regex("balance is Ksh(\\d+,?\\d+.\\d+)")
        val dateTimeRegex = Regex("(\\d{1,2}/\\d{1,2}/\\d{2,4}) at (\\d{1,2}:\\d{2} [APM]{2})")

        val amount = amountRegex.find(message)?.groupValues?.get(1)?.replace(",", "")?.toDoubleOrNull() ?: 0.0
        val balance = balanceRegex.find(message)?.groupValues?.get(1)?.replace(",", "")?.toDoubleOrNull() ?: 0.0
        val dateTimeMatch = dateTimeRegex.find(message)
        val date = dateTimeMatch?.groupValues?.get(1) ?: ""
        val time = dateTimeMatch?.groupValues?.get(2) ?: ""

        if (amount == 0.0 || date.isEmpty() || time.isEmpty()) return null

        return Transaction(
            type = type,
            amount = amount,
            balance = balance,
            date = date,
            time = time,
            message = message
        )
    }

    private fun saveTransaction(context: Context, transaction: Transaction) {
        val database = TransactionDatabase.getDatabase(context)
        CoroutineScope(Dispatchers.IO).launch {
            database.transactionDao().insertTransaction(transaction)
            Log.d("SmsReceiver", "Transaction saved: $transaction")
        }
    }
}

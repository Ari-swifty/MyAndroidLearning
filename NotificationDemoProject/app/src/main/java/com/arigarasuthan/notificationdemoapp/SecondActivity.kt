package com.arigarasuthan.notificationdemoapp

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.databinding.DataBindingUtil
import com.arigarasuthan.notificationdemoapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
   private lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_second)
        receiveInput()
    }

    private fun receiveInput() {
         val KEY_REPLY = "key_reply"
        val getintent = intent
        val remoteInput = RemoteInput.getResultsFromIntent(getintent)
        if(remoteInput!=null)
        {
            val inputString = remoteInput.getCharSequence(KEY_REPLY).toString()
            binding.secondText.text = inputString

            val channelId = "com.arigarasuthan.notificationdemoapp"
            val notificationId = 45

            val repliedNotification = NotificationCompat.Builder(this,channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("Your reply received")
                .build()
            val noticationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            noticationManager.notify(notificationId,repliedNotification)


        }
    }
}
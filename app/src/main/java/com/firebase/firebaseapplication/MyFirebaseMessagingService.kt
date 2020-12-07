package com.firebase.firebaseapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    lateinit var title:String
    lateinit var message:String
    val CHANNLE_ID= "CHANNEL"
   lateinit var manager: NotificationManager
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        title= remoteMessage.data.get("title")!!
        message= remoteMessage.data.get("message")!!
        manager= this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        sendNotification()

    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

    }
    private fun sendNotification(){
        val intent= Intent(applicationContext,MainActivity::class.java)
        intent.flags= Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel= NotificationChannel(CHANNLE_ID,"PushNotification",NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }
        val builder= NotificationCompat.Builder(this,CHANNLE_ID)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true)
                .setContentText(message)

        val pendingIntent= PendingIntent.getActivity(applicationContext,0,intent,PendingIntent.FLAG_ONE_SHOT)

        builder.setContentIntent(pendingIntent)
        manager.notify(0,builder.build())
    }
   /* fun getManager():NotificationManager{
         manager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        return (manager as NotificationManager)
    }*/

}
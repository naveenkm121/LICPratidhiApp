package com.ecommerce.app.services.fcm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat
import android.os.Build
import com.ecommerce.app.R
import com.ecommerce.app.ui.activities.HomeActivity
import com.ecommerce.app.utils.DebugHandler
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.io.IOException
import java.net.URL

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        DebugHandler.log( "Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // FCM registration token to your app server.
         sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String?) {
        DebugHandler.log("sendRegistrationTokenToServer($token)")
    }



    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.data.size > 0) {
            DebugHandler.log("Message Data payload: " + remoteMessage.data)
            val value = remoteMessage.data["notification"]

        }
        if (remoteMessage.notification != null) {
            DebugHandler.log("Message notification payload: " +  remoteMessage.notification)
            sendNotification(
                remoteMessage.notification!!.body, remoteMessage.notification!!.title, "null"
            )
        }
    }

    private fun sendNotification(messageBody: String?, title: String?, imgUrl: String) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        var bmp: Bitmap? = null
        DebugHandler.log( "sendNotification: " + imgUrl.toString())
        try {
            val `in` = URL(imgUrl.toString()).openStream()
            bmp = BitmapFactory.decodeStream(`in`)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val channelId = getString(R.string.app_name)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder: NotificationCompat.Builder =
            NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_facebook)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bmp))
                .setPriority(Notification.PRIORITY_HIGH)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
    }



}
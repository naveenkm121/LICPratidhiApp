package com.licapps.bmmis.services


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.os.Build
import android.text.TextUtils
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.utils.DebugHandler
import timber.log.Timber


class MyFirebaseMessagingService : FirebaseMessagingService() {


    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Timber.d("From: ${remoteMessage.from}")

        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Timber.d("Message data payload: ${remoteMessage.data}")

            if (true) {
                // For long-running tasks (10 seconds or more) use WorkManager.
                scheduleJob()
            } else {
                // Handle message within 10 seconds
                handleNow()
            }
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Timber.d("Message Notification Body: ${it.body}")
            sendNotification(it.title.orEmpty(), it.body.orEmpty(), "")
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }


    override fun onNewToken(token: String) {
        super.onNewToken(token);
        DebugHandler.log("Hello edsds")
        Timber.d("Refreshed token: $token")
        sendRegistrationToServer(token)
    }


    /**
     * Schedule async work using WorkManager.
     */

    private fun scheduleJob() {
        // [START dispatch_job]
        /*   val work = OneTimeWorkRequest.Builder(MyWorker::class.java).build()
           WorkManager.getInstance(this).beginWith(work).enqueue()

         */
        // [END dispatch_job]
    }

    /**
     * Handle time allotted to BroadcastReceivers.
     */

    private fun handleNow() {
        Timber.d("Short lived task is done.")
    }


    private fun sendRegistrationToServer(token: String?) {
        Timber.d("sendRegistrationTokenToServer($token)")
    }



    private fun sendNotification(title: String, messageBody: String, imageUrl: String) {
        val intent = Intent(this, NewHomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        val channelId = getString(R.string.app_name)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
            .setContentText(messageBody)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)



        if (!TextUtils.isEmpty(title)) {
            notificationBuilder.setContentTitle(title)
        } else {
            notificationBuilder.setContentTitle(getString(R.string.app_name))
        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(AppConstants.NOTIFICATION_ID, notificationBuilder.build())
    }



    companion object {

        private const val TAG = "MyFirebaseMsgService"
    }
}

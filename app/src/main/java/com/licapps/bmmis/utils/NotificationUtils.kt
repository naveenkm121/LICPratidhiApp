package com.licapps.bmmis.utils

import android.R
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.core.app.NotificationCompat
import com.licapps.bmmis.constants.AppConstants


class NotificationUtils(val context: Context) {



    private fun showSmallNotification(
        mBuilder: NotificationCompat.Builder,
        icon: Int,
        title: String,
        message: String,
        timeStamp: String,
        resultPendingIntent: PendingIntent,
        alarmSound: Uri
    ) {
        val inboxStyle: Notification.InboxStyle = Notification.InboxStyle()
        inboxStyle.addLine(message)
        val notification: Notification
        notification = mBuilder.setSmallIcon(icon).setTicker(title).setWhen(0)
            .setAutoCancel(true)
            .setContentTitle(title)
            .setContentIntent(resultPendingIntent)
            .setSound(alarmSound)
            .setSmallIcon(R.mipmap.sym_def_app_icon)
            .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), icon))
            .setContentText(message)
            .build()
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(AppConstants.NOTIFICATION_ID, notification)
    }
}
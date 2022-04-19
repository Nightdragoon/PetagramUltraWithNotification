package com.joaquinemmanuel.petagramultra;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.Gravity;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public final static String CHANNEL_ID = "DEDSEC";
    public final static int NOTIFICATION_ID = 1;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        createNoti(message.getNotification().getBody() , message.getFrom());


    }

    public void createNoti(String message , String from) {
        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);
        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Action action = new NotificationCompat.Action(R.drawable.icons8_usuario_de_g_nero_neutro_90,
                "Entra a tu perfil" ,
                pendingIntent);
        NotificationCompat.WearableExtender extender = new NotificationCompat.WearableExtender()
                .setHintHideIcon(true)
                .setBackground(BitmapFactory.decodeResource(getResources() , R.drawable.cynder_p))
                .setGravity(Gravity.CENTER_VERTICAL);
        NotificationCompat.Builder noBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.cynder_p)
                .setContentTitle(from)
                .setContentText(message)
                .setSound(sonido)
                .setAutoCancel(true)
                .extend(extender.addAction(action))
                .addAction(action);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID , noBuilder.build());


    }

    public void createNotiChan() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "dedsec", importance);
            notificationManager.createNotificationChannel(channel);
        }
    }
}

package com.example.tictactoe;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class notification extends AppCompatActivity {

    private static final String CHANNEL_ID = "New Channel";
    private static final int NOTIFICATION_ID = 100;

    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.notification, null);
    BitmapDrawable bitmapDrawable =  (BitmapDrawable) drawable;
    Bitmap largeIcon ;

    {
        assert bitmapDrawable != null;
        largeIcon = bitmapDrawable.getBitmap();
    }

    public notification(String OorX, String Winner){

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this, CHANNEL_ID)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.notification)
                    .setContentText(Winner)
                    .setSubText(OorX)
                    .setChannelId(CHANNEL_ID)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Channel", NotificationManager.IMPORTANCE_HIGH));

        }else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.notification)
                    .setContentText(Winner)
                    .setSubText(OorX)
                    .build();
        }

        nm.notify(NOTIFICATION_ID, notification);
    }

}

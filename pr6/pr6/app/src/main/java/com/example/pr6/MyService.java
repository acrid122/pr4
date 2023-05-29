package com.example.pr6;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyService extends Service {

    private final int NOTIFICATION_SERVICE = 101;
    WindowManager manager;
    View rootView;

    public MyService() {
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
//        Intent notificationIntent = new Intent(this, MainActivity.class);
//        PendingIntent pendingIntent =
//                PendingIntent.getActivity(this, 0, notificationIntent,
//                        PendingIntent.FLAG_IMMUTABLE);
//
//        Notification notification =
//                new Notification.Builder(this, "channel_id")
//                        .setContentTitle(getText(R.string.notification_service_title))
//                        .setContentText(getText(R.string.notification_service_text))
//                        .setSmallIcon(R.drawable.ic_launcher_foreground)
//                        .setContentIntent(pendingIntent)
//                        //.setTicker(getText(R.string.notification_text))
//                        .build();
//
//        startForeground(NOTIFICATION_SERVICE, notification);

        manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        rootView = LayoutInflater.from(this).inflate(R.layout.service, null);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                200,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.RIGHT;
        params.x = 0;
        params.y = 0;

        manager.addView(rootView, params);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialogIntent = new Intent(getApplicationContext(), MainActivity.class);
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(dialogIntent);
                stopSelf();
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onDestroy() {
        manager.removeView(rootView);
        super.onDestroy();
    }
}
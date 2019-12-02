package com.bellarhoa.idle_sport;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class RecycleViewAdapter_bawah extends RecyclerView.Adapter<RecycleViewAdapter_bawah.ViewHolder> {
    LayoutInflater mInflater;
    ArrayList<DataUpgrade> itemPotatoes;
    Context context;

    //notification
    private static final String CHANNEL_ID = "ch001";
    public static int NOTIFICATION_ID = 1;
    private  static final String CHANNEL_NAME = "Channel Name";

    public RecycleViewAdapter_bawah(Context context, ArrayList<DataUpgrade> itemPotatoes) {
        this.mInflater = (LayoutInflater) LayoutInflater.from(context);
        this.itemPotatoes = itemPotatoes;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button namaButton;
        TextView txt;

        public ViewHolder(View v) {
            super(v);
            namaButton = (Button) v.findViewById(R.id.btn);
            txt = (TextView) v.findViewById(R.id.tv_text);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowview, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final DataUpgrade current = itemPotatoes.get(position);
        holder.txt.setText(current.nama);
        if(current.getLevel()<4)holder.namaButton.setText("BELI\n"+String.valueOf(current.getHarga()));
        else holder.namaButton.setText("MAX!");
        switch (current.getLevel()) {
            case 4:
                holder.namaButton.setEnabled(false);
                holder.namaButton.setBackgroundResource(R.drawable.btn_round4);
                break;
            case 3:
                holder.namaButton.setBackgroundResource(R.drawable.btn_round3);
                break;
            case 2:
                holder.namaButton.setBackgroundResource(R.drawable.btn_round2);
                break;
            case 1:
                holder.namaButton.setBackgroundResource(R.drawable.btn_round1);
                break;
        }
        ImageView image = ResourceArray.imageView[current.type];
        image.setImageResource(ResourceArray.data[current.type][current.getLevel() > 4 ? 4 : current.getLevel()]);


        holder.namaButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Button btnn = (Button) v.findViewById(R.id.btn);
                SharedPreferences dataSP = context.getSharedPreferences("dataSP", 0);
                int currTap;
                SharedPreferences.Editor editData = dataSP.edit();
                int currPoint = dataSP.getInt("keyPoint", 0);
                if(currPoint>=current.getHarga() && current.getLevel()<4) {
                    switch (current.getLevel()) {
                        case 3:
                            btnn.setBackgroundResource(R.drawable.btn_round4);
                            btnn.setEnabled(false);
                            break;
                        case 2:
                            btnn.setBackgroundResource(R.drawable.btn_round3);
                            break;
                        case 1:
                            btnn.setBackgroundResource(R.drawable.btn_round2);
                            break;
                        case 0:
                            btnn.setBackgroundResource(R.drawable.btn_round1);
                            break;
                    }
                    currPoint-=current.getHarga();
                    current.setLevel(current.getLevel() + 1);
                    current.setHarga(current.getHarga()*2+400);
                    if(current.level<4)btnn.setText("BELI\n"+String.valueOf(current.getHarga()));
                    else btnn.setText("MAX!");
                    ImageView image = ResourceArray.imageView[current.type];
                    image.setImageResource(ResourceArray.data[current.type][current.getLevel()]);
                    current.setNama(current.getNama() + " level: " + String.valueOf(current.getLevel() + 1));
                    currTap = dataSP.getInt("keyTap", 5);
                    editData.putInt("keyPoint", currPoint);
                    editData.putInt("keyTap", currTap + current.level);
                    editData.putInt("keyHarga"+String.valueOf(position), current.getHarga());
                    editData.putInt("keyLevel"+String.valueOf(position), current.getLevel());
                    editData.apply();
                    Notification("Upgrade "+current.getNama(),current.getNama()+" udah di upgrade nih (≧▽≦)",context, new Intent());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemPotatoes.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public final void Notification(String title, String konten, Context context, Intent intent) {
        NotificationManager notificationManager =
                (NotificationManager)
                        context.getSystemService(Context.NOTIFICATION_SERVICE);

        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_foreground).setContentTitle(title).setContentText(konten);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntent(intent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}
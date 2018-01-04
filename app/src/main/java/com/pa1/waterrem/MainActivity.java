package com.pa1.waterrem;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSAlarm,btnStAlarm;
    EditText etAccept;
    TextView tvTotal;
    static int accept;
    static int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSAlarm= (Button) findViewById(R.id.btnSAlarm);
        btnStAlarm= (Button) findViewById(R.id.btnStAlarm);
        etAccept= (EditText) findViewById(R.id.etAccept);
        tvTotal = (TextView) findViewById(R.id.tvTotal);

        Intent i = new Intent(MainActivity.this,BR1.class);
        final PendingIntent pi =PendingIntent.getBroadcast(getApplicationContext(),1234,i,0);
        final AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        btnSAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 accept= Integer.parseInt(etAccept.getText().toString());
                am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(accept*1000),pi);
                count++;
            }
        });

        btnStAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             am.cancel(pi);

            }
        });
    }
}

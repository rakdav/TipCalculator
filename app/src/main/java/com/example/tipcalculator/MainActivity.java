package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private SeekBar seek;
    private TextView sum,tip,total;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text);
        seek=findViewById(R.id.seek);
        sum=findViewById(R.id.sum);
        tip=findViewById(R.id.tip);
        total=findViewById(R.id.total);
        send=findViewById(R.id.send);
        
    }
}
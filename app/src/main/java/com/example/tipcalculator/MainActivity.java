package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.nfc.FormatException;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private SeekBar seek;
    private TextView sum,tip,total;
    private Button send;
    private static final String LOG="log";
    private double Summa;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text);
        seek=findViewById(R.id.seek);
        sum=findViewById(R.id.sum);
        tip=findViewById(R.id.tip);
        total=findViewById(R.id.total);
        send=findViewById(R.id.send);
        result=findViewById(R.id.result);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(LOG,s.toString());
                try {
                    if(s.toString().length()!=0) {
                        Summa = Double.parseDouble(s.toString());
                        int Tip = seek.getProgress();
                        double Total = Summa + (Summa * Tip / 100);
                        sum.setText(Double.toString(Summa));
                        tip.setText(Integer.toString(Tip)+"% "+Double.toString(Summa * Tip / 100));
                        total.setText(Double.toString(Total));
                    }
                    else
                    {
                        sum.setText("");
                        tip.setText("");
                        total.setText("");
                    }
                }
                catch (NumberFormatException ex)
                {

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Summa = Double.parseDouble(text.getText().toString());
                int Tip = progress;
                double Total = Summa + (Summa * Tip / 100);
                sum.setText(Double.toString(Summa));
                tip.setText(Integer.toString(Tip)+"% "+Double.toString(Summa * Tip / 100));
                total.setText(Double.toString(Total));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OkActivity.class);
                startActivity(intent);
            }
        });
    }
}
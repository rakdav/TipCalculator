package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OkActivity extends AppCompatActivity {
    private TextView okSum,okTip,okTotal;
    private Button yes,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok);
        Bundle arg=getIntent().getExtras();
        okSum=findViewById(R.id.okSum);
        okTip=findViewById(R.id.okTip);
        okTotal=findViewById(R.id.okTotal);
        okSum.setText(arg.get(MainActivity.SUM).toString());
        okTip.setText(arg.get(MainActivity.TIP).toString());
        okTotal.setText(arg.get(MainActivity.TOTAL).toString());
        yes=findViewById(R.id.Yes);
        no=findViewById(R.id.No);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data=new Intent();
                data.putExtra(MainActivity.TOTAL,"Yes");
                setResult(RESULT_OK,data);
                finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
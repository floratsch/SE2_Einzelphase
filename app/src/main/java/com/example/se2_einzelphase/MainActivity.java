package com.example.se2_einzelphase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn;
    private EditText matNo;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        matNo =  findViewById(R.id.inputMatNo);
        result =  findViewById(R.id.result);

        btn.setOnClickListener( (View.OnClickListener) this);
    }


    @Override
    public void onClick(View v) {

    }

}
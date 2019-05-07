package com.myapplicationdev.android.problemstatementl03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class data extends AppCompatActivity {

    Button btnSubmit;
    RadioGroup rdg;
    TextView tvWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        btnSubmit = findViewById(R.id.buttonSubmit);
        rdg = findViewById(R.id.radioGroup);
        tvWeek = findViewById(R.id.textViewWeek4);

        Intent i = getIntent();
        final int no = i.getIntExtra("no",0) + 1;

        tvWeek.setText("Week " + no);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rdg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);
                String grade = rb.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("grade", grade);
                setResult(RESULT_OK, intent);
                finish();

            }
        });


    }
}

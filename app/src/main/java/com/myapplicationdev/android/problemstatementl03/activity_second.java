package com.myapplicationdev.android.problemstatementl03;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class activity_second extends AppCompatActivity {

    private final static int REQUEST_CODE_1 = 1;

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Modules> mols;
    Button btnInfo;
    Button btnEmail;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        lv = findViewById(R.id.listView);
        btnInfo = findViewById(R.id.buttonInfo);
        btnEmail = findViewById(R.id.buttonEmailFaci);
        btnAdd = findViewById(R.id.buttonAdd);
        mols = new ArrayList<Modules>();

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        if (position == 0) {

            setTitle("Info for C347");

            mols.add(new Modules(1, "C347", "Daily Grade", "B"));
            mols.add(new Modules(2, "C347", "Daily Grade", "A"));
            mols.add(new Modules(3, "C347", "Daily Grade", "C"));
        } else if (position == 1) {

            setTitle("Info for C302");

            mols.add(new Modules( 1, "C302", "Daily Grade", "A"));
            mols.add(new Modules( 2, "C302", "Daily Grade", "A"));
            mols.add(new Modules( 3, "C302", "Daily Grade", "C"));
        }

        aa = new ModulesAdapter(this, R.layout.row, mols);
        lv.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);

                String message = "Hi faci, \n I am...\n Please see my remarks so far, thank you!\n\n";

                for (int i = 0; i < mols.size(); i++) {
                    message += "Week " + mols.get(i).getWeek() + ": " + "Daily Grade: " + mols.get(i).getGrade() + "\n";
                }

                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_second.this, data.class);
                int no = mols.get(mols.size() - 1).getWeek();
                i.putExtra("no", no);
                startActivityForResult(i, REQUEST_CODE_1);

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);
        switch (requestCode) {
            case REQUEST_CODE_1:
                if (resultCode == RESULT_OK) {
                    String grade = dataIntent.getStringExtra("grade");
                    mols.add(new Modules( mols.get(mols.size() - 1).getWeek()+1, "C347", "Daily Grade",grade));
                    aa.notifyDataSetChanged();

                }
        }
    }


}

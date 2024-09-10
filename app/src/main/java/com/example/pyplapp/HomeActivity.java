package com.example.pyplapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    TextView homeTv;
    public static String TAG = HomeActivity.class.getSimpleName();
    Button btnSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeTv = findViewById(R.id.tvHome);
        btnSelect = findViewById(R.id.btnSelect);


      String data =  getIntent().getExtras().getString("pypl");
      homeTv.setText(data);

    }

    @Override
    protected void onStart() {
        super.onStart();
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etCon = findViewById(R.id.etContact);
                String contact = etCon.getText().toString();
                Intent dataIntent = new Intent();
                dataIntent.putExtra("con",contact);
                setResult(RESULT_OK,dataIntent);
                finish();

            }
        });
    }
}
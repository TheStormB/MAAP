package com.example.lab_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("ID", ((EditText)findViewById(R.id.inputfield)).getText().toString());
                i.putExtra("Name", ((EditText)findViewById(R.id.namefield)).getText().toString());
                i.putExtra("SurName", ((EditText) findViewById(R.id.surnamefield)).getText().toString());
                i.putExtra("age", Integer.parseInt((((EditText) findViewById(R.id.agefield)).getText().toString())));
//                i.putExtra("rating", Integer.parseInt((((RatingBar)findViewById(R.id.ratingBar));


                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}
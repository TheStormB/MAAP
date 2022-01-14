package com.example.lab_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
                i.putExtra("mainText", ((TextView)findViewById(R.id.textView2)).getText().toString());
                i.putExtra("secText", ((TextView) findViewById(R.id.textView3)).getText().toString());
                i.putExtra("age", Integer.parseInt((((TextView) findViewById(R.id.textView4)).getText().toString())));
                i.putExtra("rating", Integer.parseInt((((TextView)findViewById(R.id.textView4)).getText().toString())));


                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
            }
        });
    }
}
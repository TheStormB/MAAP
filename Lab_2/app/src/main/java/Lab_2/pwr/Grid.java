package Lab_2.pwr;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Lab_2.pwr.adapters.GridImage;

public class Grid extends AppCompatActivity {

    String[] list = {"Position 1", "Position 2", "Position 3"};
    String[] p = {"1", "2", "3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        GridView view = (GridView)findViewById(R.id.GridView);
        view.setAdapter(new GridImage(this));

        String arg1 = getIntent().getStringExtra("ARG1");
        Integer arg2 = getIntent().getIntExtra("ARG2", 0);

        Toast.makeText(getApplicationContext(), arg1 + arg2, Toast.LENGTH_SHORT).show();

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Selected: " + p[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected" , Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> adptr = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adptr.addAll(list);
        adptr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adptr);
    }
}
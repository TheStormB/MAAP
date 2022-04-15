package Lab_2.pwr;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Lab_2.pwr.adapters.NewGridImage;

public class NewGrid extends AppCompatActivity {
    String[] pics ={
            "Picture 1",
            "Picture 2",
            "Picture 3",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_grid);
        GridView view = (GridView)findViewById(R.id.New_Grid_View);
        view.setAdapter(new NewGridImage(this));
    }
}
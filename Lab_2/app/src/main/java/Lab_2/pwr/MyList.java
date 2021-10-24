package Lab_2.pwr;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Lab_2.pwr.adapters.MyListAdapter;

public class MyList extends AppCompatActivity {

    String[] title = {
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10",
    };

    String[] subtitle = {
            "1 1",
            "2 2",
            "3 3",
            "4 4",
            "5 5",
            "6 6",
            "7 7",
            "8 8",
            "9 9",
            "10 10",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_list);

        MyListAdapter a = new MyListAdapter(title, subtitle, this );
        ListView lv = findViewById(R.id.my_list_view);
        lv.setAdapter(a);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
package Lab_2.pwr;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MultiChoiceList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] items = {
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
            "Item 11",
            "Item 12",
            "Item 13",
            "Item 14",
            "Item 15",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multichoice_list);

        ArrayAdapter<String> arr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice);
        arr.addAll(items);

        ListView lv = findViewById(R.id.multichoice_list_view);
        lv.setAdapter(arr);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String info = " ";
        SparseBooleanArray checked = ((ListView)findViewById(R.id.multichoice_list_view)).getCheckedItemPositions();

        for(int i= 0; i < checked.size(); i++){
            if(checked.valueAt(i)){
                int indeks = checked.keyAt(i);
                info = (" " + String.valueOf(indeks+1));
            }
        }

        Toast.makeText(getApplicationContext(), "You have selected: " + info, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
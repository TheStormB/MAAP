package Lab_2.pwr;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Lab_2.pwr.adapters.ContactsAdapter;

public class ContactList extends AppCompatActivity {

    String[] title = {
            "John",
            "Alex",
            "Julia",
            "TEST",
    };

    String[] number = {
            "500",
            "600",
            "800",
            "900",
    };

    Integer[] image = {
            R.drawable.empty_pic_1,
            R.drawable.empty_pic_2,

    };

    ContactsAdapter contactsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);

        this.contactsAdapter = new ContactsAdapter(title, number, image, this);
        ListView listView = findViewById(R.id.contact_list_view);
        listView.setAdapter(this.contactsAdapter);








    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
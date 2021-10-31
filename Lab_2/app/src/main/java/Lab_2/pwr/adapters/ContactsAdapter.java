package Lab_2.pwr.adapters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.RequiresApi;

import java.util.Random;

import Lab_2.pwr.ContactList;
import Lab_2.pwr.Grid;
import Lab_2.pwr.MyList;
import Lab_2.pwr.NewGrid;
import Lab_2.pwr.R;

class TEST{
    TextView tv1;
    TextView tv2;
    ImageView img;
    Button dial;
    Button web;
}

public class ContactsAdapter extends BaseAdapter {
    String[] name_surname;
    String [] number;
    LayoutInflater inflater = null;
    Context context;

    public Integer[] image = {
            R.drawable.empty_pic_1,
            R.drawable.empty_pic_2,

    };

    public ContactsAdapter(String[] name_surname, String[] number, Integer[] image, Context ctx) {
        super();
        this.name_surname = name_surname;
        this.number = number;

        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        context = ctx;
    }

    @Override
    public int getCount() {

        return name_surname.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TEST item = new TEST();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_row_2, null);
            item.tv1 = (TextView)convertView.findViewById(R.id.my_tv1);
            item.tv2 = (TextView)convertView.findViewById(R.id.my_tv2);
            item.img = (ImageView)convertView.findViewById(R.id.empty_pic);
            item.dial = (Button)convertView.findViewById(R.id.Call);
            item.web = (Button)convertView.findViewById(R.id.web);
            convertView.setTag(item);
        }else {
            item = (TEST)convertView.getTag();
        }

        item.tv1.setText(name_surname[position]);
        item.tv2.setText(number[position]);

        item.img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context.getApplicationContext(), NewGrid.class);
                context.startActivity(intent);
                return false;
            }
        });

        item.dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = number[position];
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                context.startActivity(intent);
            }
        });

        item.web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://www.google.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                context.startActivity(webIntent);
            }
        });
        return convertView;
    }


}

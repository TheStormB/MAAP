package Lab_2.pwr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import Lab_2.pwr.R;

class lVitem {
    TextView tv1;
    TextView tv2;
    ImageView img;
    CheckBox cBox;
}

public class MyListAdapter extends BaseAdapter {
    String[] title;
    String[] subtitle;
    boolean[] checked;
    LayoutInflater inflater = null;
    Context context;

    public MyListAdapter(String[] title, String[] subtitle, Context ctx){
        this.subtitle = subtitle;
        this.title = title;
        this.checked = new boolean[title.length];
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        context = ctx;
    }

    @Override
    public int getCount() {
        return title.length;
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
        lVitem item = new lVitem();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_row, null);
            item.cBox = (CheckBox) convertView.findViewById(R.id.lrow_checkBox);
            item.tv1 = (TextView)convertView.findViewById(R.id.row_tv1);
            item.tv2 = (TextView)convertView.findViewById(R.id.row_tv2);
            item.img = (ImageView)convertView.findViewById(R.id.row_image);
            convertView.setTag(item);
        }else {
            item = (lVitem) convertView.getTag();
        }

        item.tv1.setText(title[position]);
        item.tv2.setText(subtitle[position]);
        item.cBox.setChecked(checked[position]);

        item.cBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                checked[position] = ((CheckBox) view).isChecked();
                Toast.makeText(context, "Checkbox Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}

package Lab_2.pwr.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import Lab_2.pwr.R;

class Button {
    Button web;
}


public class NewGridImage extends BaseAdapter {
    private Context ctx;

    public Integer[] imgIDs = {
            R.drawable.empty_pic_1, R.drawable.empty_pic_2, R.drawable.empty_pic_1,
    };

    public NewGridImage(Context c){
        ctx = c;
    }

    @Override
    public int getCount() {
        return imgIDs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView mV;
        ImageView web;


        if(convertView == null){
            mV = new ImageView(ctx);

            mV.setLayoutParams(new ViewGroup.LayoutParams(400, 400));
            mV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mV.setPadding(8,8,8,8);



        }else {
            mV = (ImageView) convertView;

        }
        mV.setImageResource(imgIDs[position]);
        mV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = position + 1;
                Toast.makeText(ctx.getApplicationContext(), "Item Selected" + num, Toast.LENGTH_SHORT).show();
            }
        });










        return mV;
    }
}

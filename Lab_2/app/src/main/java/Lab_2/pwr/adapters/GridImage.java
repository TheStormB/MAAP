package Lab_2.pwr.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import Lab_2.pwr.R;

public class GridImage extends BaseAdapter {
    private Context ctx;

    public Integer[] imgIDs = {
            R.drawable.heineken, R.drawable.corona, R.drawable.zywiec,
            R.drawable.corona, R.drawable.zywiec, R.drawable.heineken,
            R.drawable.zywiec, R.drawable.heineken, R.drawable.corona
    };

    public GridImage(Context c){
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

        if(convertView == null){
            mV = new ImageView(ctx);
            mV.setLayoutParams(new ViewGroup.LayoutParams(400, 400));
            mV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mV.setPadding(8,8,8,8);
        }else {
            mV = (ImageView) convertView;
        }
        mV.setImageResource(imgIDs[position]);
        return mV;
    }
}

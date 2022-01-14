package com.example.lab_5.DataPackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_5.DataPackage.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.lab_5.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.ViewHolder> {

    private List<ItemData> mValues;


    public MyRVAdapter(List<ItemData> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mMainText.setText(holder.mItem.txtMain);
        holder.mTextTwo.setText(holder.mItem.txtSecond);
        holder.mAvatar.setImageResource(android.R.drawable.btn_plus);


        if(holder.mItem.rating > 3){
            holder.mRating.setImageResource(android.R.drawable.btn_plus);
        }else{
            holder.mRating.setImageResource(android.R.drawable.btn_minus);
        }
    }

    void setData(List<ItemData> items){
        mValues = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mMainText;
        public final TextView mTextTwo;
        public final ImageView mAvatar;
        public final ImageView mRating;
        public ItemData mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mMainText = binding.itemTxtMain;
            mTextTwo = binding.itemTxt2;
            mAvatar = binding.avatarImage;
            mRating = binding.itemRatingImage;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMainText.getText() + "'";
        }
    }
}
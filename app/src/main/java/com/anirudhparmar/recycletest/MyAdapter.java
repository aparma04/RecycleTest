package com.anirudhparmar.recycletest;

/**
 * Created by Anirudh on 2/22/2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anirudh on 2/21/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Buisness> listItems;
    private Context context;

    public MyAdapter(List<Buisness> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Buisness listItem = listItems.get(position);
        //holder.mImageViewMain. main image set later
        //holder.mImageViewMain. rating image set later
        holder.mTextViewName.setText(listItem.getName());
        holder.mTextViewAddress.setText(listItem.getAddress());


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewName;
        public TextView mTextViewAddress;


        public ViewHolder(View itemView) {
            super(itemView);

//            mImageViewMain = (ImageView) itemView.findViewById(R.id.main_image);
//            mImageViewRating = (ImageView) itemView.findViewById(R.id.rating_image);
            mTextViewName = (TextView) itemView.findViewById(R.id.text_name);
            mTextViewAddress = (TextView) itemView.findViewById(R.id.address_text);

        }
    }
}

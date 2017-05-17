package com.example.shrav.expensemanagerandreminder;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * Created by shrav on 11/15/2016.
 */
    public class RecyclerViewAdapter extends RecyclerView.Adapter<itemViewHolder> {
    List<ReportItem> list = Collections.emptyList();
    Context context;

    public RecyclerViewAdapter(Context context, List<ReportItem> list ) {
        this.list = list;
        this.context = context;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        itemViewHolder holder = new itemViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(itemViewHolder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.name.setText(list.get(position).name);
        holder.amount.setText(list.get(position).amouunt);
        holder.date.setText(list.get(position).date);
        File imgFile = new File(list.get(position).image);
        if(imgFile.exists())
        {
            holder.mImageView.setImageURI(Uri.fromFile(imgFile));

        }else
        {
            holder.mImageView.setImageDrawable(null);
        }





    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, ReportItem data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(ReportItem data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}
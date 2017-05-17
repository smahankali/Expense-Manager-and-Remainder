package com.example.shrav.expensemanagerandreminder;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shrav on 11/15/2016.
 */
public class itemViewHolder extends RecyclerView.ViewHolder {


    public TextView name;
    public TextView amount;
    public TextView date;
    public ImageView mImageView;


    public itemViewHolder(View view) {
        super(view);


        this.name = (TextView) view.findViewById(R.id.expense_name);
        this.amount = (TextView) view.findViewById(R.id.expense_amount);
        this.date= (TextView) view.findViewById(R.id.expense_date);
        this.mImageView = (ImageView) view.findViewById(R.id.icon);



    }


}
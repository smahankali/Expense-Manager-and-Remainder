package com.example.shrav.expensemanagerandreminder;

/**
 * Created by shrav on 11/26/2016.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.

 */
public class DisplayReminderFragment extends Fragment {

    // the fragment initialization parameters, e.g. view,recyclerview,edittext
    private View view;
    private static RecyclerView recyclerView;
    /**
     * Represent the class which handles the data base operation
     */
    private DbOperation db;

    /**
     * Represent the database object
     */
    private SQLiteDatabase dbs;

    /**
     * Represent a Cursor object for obtaining the data
     */
    private Cursor cursor=null;

    /**
     * Represent an EditText object for entering the start date
     */
    private EditText Date1;

    /**
     * Represent an EditText object for entering the end date
     */
    private EditText Date2;

    /**
     * Represent a Button object
     */
    private Button btnRemove;

    /**
     * Represent an int to hold the selected item position
     */
    private int mustRemoveItemposition;
    private RecyclerViewAdapter adapter;
    List<ReportItem> arrayList = new ArrayList<>();


    /**
     * Fires on the creation of the class and shows the activity base on the XML design and obtain the handle for all the XML objects
     * @param savedInstanceState represent the saved Instance State
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_display_reminder, container, false);

       /* Date1= (EditText) view.findViewById(R.id.Date1_remainder);
        Date2= (EditText) view.findViewById(R.id.Date2_remainder);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String date = sdf.format(new Date());
        Date1.setText(String.valueOf(date.toCharArray(),0,8)+"01");
        Date2.setText(date);*/
        db=new DbOperation(this.getContext());
        dbs= db.getWritableDatabase();
        Button get=(Button)view.findViewById(R.id.get_reminder);
        final Context context=getActivity();
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if (Date1.getText().toString().length()!=10)
                {
                    Toast.makeText(getContext(), " Enter the From date correctly, please"+"\n The correct format is yyyy/MM/dd", Toast.LENGTH_LONG).show();
                    return;
                }
                if (Date2.getText().toString().length()!=10)
                {
                    Toast.makeText(getContext(), " Enter the To date correctly, please"+"\n The correct format is yyyy/MM/dd", Toast.LENGTH_LONG).show();
                    return;
                }*/



                arrayList.clear();
                String condition="";


                cursor=dbs.rawQuery("select * From Payment_Reminder", null);
                cursor.moveToFirst();




                while(cursor.moveToNext())
                {

                    arrayList.add(new ReportItem(cursor.getString(cursor.getColumnIndex("Name")).toString(),Float.toString(cursor.getFloat(cursor.getColumnIndex("Amt"))),
                            cursor.getString(cursor.getColumnIndex("PayDueDate")).toString(),""));

                }
                setRecyclerView();

            }
        });
        return view;

    }
    //Setting recycler view
    private void setRecyclerView() {

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items
        adapter = new RecyclerViewAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview*/

    }


}

package com.example.shrav.expensemanagerandreminder;

/**
 * Created by shrav on 11/26/2016.
 */

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;*/

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.

 */
public class ReminderFragment extends Fragment {

    // the fragment initialization parameters, e.g. view,recyclerview,edittext
    private View view;
    /**
     * Represent the class which handles the data base operation
     */
    private DbOperation db;

    /**
     * Represent the database object
     */
    private SQLiteDatabase dbs;

    /**
     * Represent an ArrayAdapter for formatting and collecting list items (regular)
     */
    private ArrayAdapter<String> adapter;

    /**
     * Represent a Cursor object for obtaining the data
     */
    private Cursor cursor;
    /**
     * Represent an EditText object for entering the name of the payment
     */
    private EditText name;

    /**
     * Represent an EditText object for entering the amount of the payment
     */
    private EditText amount;

    /**
     * Represent an EditText object for entering any Explanation for the payment
     */
    private EditText comment;

    /**
     * Represent a Button object
     */
    private Button btnSave;
    /**
     * Represent a Button object
     */
    private Button btnAdd;

    /**
     * Represent an EditText object for entering the start date
     */
    private EditText date;
    private AlarmManagerBroadcastReceiver alarm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_reminder, container, false);
        db=new DbOperation(this.getActivity());
       /* MobileAds.initialize(getActivity(), "ca-app-pub-5050005320107816~2559190681");
        AdView mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
        dbs= db.getWritableDatabase();

        name= (EditText) view.findViewById(R.id.reminder);
        amount = (EditText) view.findViewById(R.id.amount_due);
        comment = (EditText) view.findViewById(R.id.reminder_comment);
        date=(EditText)view.findViewById(R.id.due_date);
        btnSave= (Button) view.findViewById(R.id.reminderSave);
        btnAdd=(Button)view.findViewById(R.id.btnAdd);

        alarm = new AlarmManagerBroadcastReceiver();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().length()<1)
                {
                    Toast.makeText(getContext(), " Enter the name of the payment, please", Toast.LENGTH_LONG).show();
                    return;
                }
                if (amount.getText().toString().length()<1)
                {
                    Toast.makeText(getContext(), " Enter the amount of the payment, please", Toast.LENGTH_LONG).show();
                    return;
                }
                if (Float.parseFloat(amount.getText().toString())==0f)
                {
                    Toast.makeText(getContext(), "The amount of the payment could not be 0, please", Toast.LENGTH_LONG).show();
                    return;
                }
                String date_string = date.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String entryDate = sdf.format(new Date());

                dbs.execSQL("Insert into Payment_Reminder values(NULL,'"+ name.getText().toString() +"','"+ date_string +"',"+ Float.parseFloat(amount.getText().toString()) + ",'"+ comment.getText().toString() +"','"+ entryDate+"')");
                Toast.makeText(getContext(), amount.getText().toString()+" Added to the Payments successfully", Toast.LENGTH_LONG).show();
                amount.setText("");
                comment.setText("");
               name.setText("");
                date.setText("");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount.setText("");
                comment.setText("");
                name.setText("");
                date.setText("");
            }
        });
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btnAlarm);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),AlarmActivity.class);
                startActivity(intent);
            }
        });


        return view;

    }





}


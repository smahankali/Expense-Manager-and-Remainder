package com.example.shrav.expensemanagerandreminder;

/**
 * Created by shrav on 11/26/2016.
 */

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.

 */
public class ExpenseFragment extends Fragment {

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
     * Represent a ImageView object that shows the taken image for the current payment
     */
    private ImageView imageView;

    /**
     * Represent a Button object
     */
    private Button btnImage;
    /**
     * Represent a Button object
     */
    private Button clearImage;

    /* Represent a Button object
    */
    private Button Image;

    /**
     * Represent an int object
     */
    private static final int CAM_REQUEST = 1;
    /**
     * Represent a Bitmap object
     */
    private Bitmap myBitmap;


    /**
     * Fires on the creation of the a and shows the fragment on the XML design and obtain the handle for all the XML objects
     *
     * @param inflater represents the Layoutinflater
     * @param container represents the Viewgroup
     * @param savedInstanceState represent the saved Instance State
     */


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.content_main, container, false);
        db=new DbOperation(this.getActivity());
        dbs= db.getWritableDatabase();
        btnImage= (Button) view.findViewById(R.id.btnImage);
        clearImage=(Button) view.findViewById(R.id.btnClearImage);
        imageView = (ImageView) view.findViewById(R.id.billImage);
        name= (EditText) view.findViewById(R.id.expense);
        amount = (EditText) view.findViewById(R.id.amount);
        comment = (EditText) view.findViewById(R.id.comment);

        btnSave= (Button) view.findViewById(R.id.btnSave);
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


                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String date = sdf.format(new Date());
                String imagepath;
                if (imageView.getDrawable() != null){imagepath=getfile().getAbsolutePath();} else {imagepath="";}

               // dbs.execSQL("Insert into Expense_Payment values(NULL,"+ name +",'"+ date +"',"+ Float.parseFloat(amount.getText().toString()) + ",'"+ comment.getText().toString() +"','"+ imagepath +"')");
                dbs.execSQL("Insert into Expense_Payment values(NULL,'"+ name.getText().toString() +"','"+ date +"',"+ Float.parseFloat(amount.getText().toString()) + ",'"+ comment.getText().toString() +"','"+ imagepath+"')");
                Toast.makeText(getContext(), name.getText().toString()+" Added to the Payments successfully", Toast.LENGTH_LONG).show();
                amount.setText("");
                comment.setText("");
                name.setText("");
                imageView.setImageDrawable(null);

            }
        });
        /**
         *  Clears the image from the image view object and it is the onclick listener for the clear image button
         * @param view represent the view object
         */
        clearImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(null);

            }
        });
        /**
         *  Open a camera app and it is the onclick listener for the Bill Image button
         * @param view represent the view object
         */
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent,CAM_REQUEST);
            }
        });

        return view;

    }
    /**
     * process the returned data from the camera app
     * @param requestCode an int represent the requestCode
     * @param resultCode an int represent the resultCode
     * @param data an intent represent the data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {



            super.onActivityResult(requestCode, resultCode, data);



                if (requestCode == CAM_REQUEST) {
                    myBitmap = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(myBitmap);
                    this.getActivity().getContentResolver().delete(data.getData(), null, null);
                }



    }

    /**
     * Create a unique file name for the image and save it in specific folder
     */
    private File getfile()
    {
        //Create the folder in the program's cache directory and with the uninstall it will be deleted to
        File folder = new File(this.getActivity().getCacheDir(),"Bill_Manager");
        if(!folder.exists())
        {
            folder.mkdirs();
        }

        File image_file= new File(folder,"EX"+(new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()))+".jpg");
        try {
            FileOutputStream fOut = new FileOutputStream(image_file);
            myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return image_file;
    }







}

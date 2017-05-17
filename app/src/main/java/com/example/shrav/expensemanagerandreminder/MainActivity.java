package com.example.shrav.expensemanagerandreminder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
     * Represent an int object
     */
    private static final int CAM_REQUEST = 1;
    /**
     * Represent a Bitmap object
     */
    private Bitmap myBitmap;
    private DrawerLayout drawer;
    android.support.v4.app.Fragment fragment;
    Class fragmentClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



      drawer= (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        fragmentClass=ExpenseFragment.class;
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        try {
            fragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        // Handle navigation view item clicks here.
        // Create a new fragment and specify the fragment to show based on nav item clicked
       switch(menuItem.getItemId()) {
            case R.id.display_expense:
                fragmentClass = ExpenseFragment.class;
                break;
            case R.id.expense_report:
                fragmentClass = ExpenseReportFragment.class;
                break;
           case R.id.set_reminder:
               fragmentClass = ReminderFragment.class;
               break;
           case R.id.display_reminder:
               fragmentClass = DisplayReminderFragment.class;
               break;

            default:
                fragmentClass = ExpenseFragment.class;
        }

        try {
            fragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawer.closeDrawers();

       /* Fragment fragment = null;
        Class fragmentClass;

        int id = menuItem.getItemId();

       *//* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }*//*

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);*/
        return true;
    }













}

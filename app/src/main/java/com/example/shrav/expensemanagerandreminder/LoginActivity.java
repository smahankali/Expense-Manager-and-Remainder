package com.example.shrav.expensemanagerandreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public Button enter;
    public EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            enter=(Button) findViewById(R.id.enter);
            email=(EditText) findViewById(R.id.input_email);
            password=(EditText)findViewById(R.id.input_password);
                        enter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String login,password_text;
                    login=email.getText().toString();
                    password_text=password.getText().toString();
                    if(login.equals("user@gmail.com")&& password_text.equalsIgnoreCase("user"))
                    {
                        callMainActivity();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Email or Password is incorrect",Toast.LENGTH_LONG);
                    }
                }
            });

        }
    public void callMainActivity()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}

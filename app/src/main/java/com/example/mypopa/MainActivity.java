package com.example.mypopa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText full_name, email,password, phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner country;
        country = findViewById(R.id.country);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.country_value,android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Apply adapter to the spinner
        country.setAdapter(adapter);


        submit = findViewById(R.id.submit);
        full_name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone_number = findViewById(R.id.phone_number);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String fullname, eid, pd;
                int pnum;
                fullname = full_name.getText().toString();
                eid = email.getText().toString();
                pd = password.getText().toString();
                pnum = Integer.parseInt(phone_number.getText().toString());

                Toast.makeText(getApplicationContext(),fullname+" "+eid+" "+pd+" "+pnum,Toast.LENGTH_LONG).show();
            }
        });



    }





}
package com.example.mypopa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText full_name, email,password, phone_number;
    Spinner country;
    RadioButton male,female,others;
    TextView error_msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        male = findViewById(R.id.rd_male);
        female = findViewById(R.id.rd_female);
        others = findViewById(R.id.rd_others);
        error_msg = findViewById(R.id.error_msg);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String fullname, eid, pd, pnumstring, gender, cn;
                String email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                int pnum;
                fullname = full_name.getText().toString();
                eid = email.getText().toString();
                pd = password.getText().toString();
                pnumstring = phone_number.getText().toString();
                if (pnumstring.isEmpty())
                    pnum = 0;
                else
                    pnum = Integer.parseInt(pnumstring);
                /*
                int x = 5;
                int y = 10;
                int z;
                z=(x<10)?x:y;

                 */
                gender = (male.isChecked()) ? "Male" : (female.isChecked()) ? "Female" : (others.isChecked()) ? "Others" : "";
                cn = country.getSelectedItem().toString();

                if (fullname.length() == 0) {
                    error_msg.setText("Please, Enter Full Name.");
                    return;
                }
                else{

                if (eid.length() == 0) {
                    error_msg.setText("Please, Enter Email ID.");
                    return;
                } else {
                    if (!eid.trim().matches(email_pattern)) {

                        error_msg.setText("Invalid Email Address.");
                        return;
                    } else {

                        if (pd.length() == 0) {
                            error_msg.setText("Password can not be empty.");
                            return;
                        } else {
                            if (pd.length() < 8) {
                                error_msg.setText("Password must be at least eight characters.");
                                return;
                            } else {
                                if (pnum < 1) {
                                    error_msg.setText("Please, Enter phone number.");
                                    return;
                                } else {
                                    if(gender.isEmpty()) {
                                        error_msg.setText("Please, Select Gender.");

                                    } else {
                                        error_msg.setText("Everything Looks Fine.");

                                    }
                                    return;
                                }
                            }
                        }

                    }
                }
            }


                //error_msg.setText("Country Selected: "+cn);
                /*
                Toast toast = Toast.makeText(getApplicationContext(),"Country is: "+cn,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP| Gravity.CENTER, 0, 0);
                toast.show();

                 */
               
                //Toast.makeText(getApplicationContext(), gender,Toast.LENGTH_LONG).show();
            }
        });



    }





}
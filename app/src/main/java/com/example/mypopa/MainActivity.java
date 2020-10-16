package com.example.mypopa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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
    CheckBox cbox_music, cbox_game,cbox_book;


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
        cbox_music = findViewById(R.id.cbox_music);
        cbox_game = findViewById(R.id.cbox_game);
        cbox_book = findViewById(R.id.cbox_book);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String fullname, eid, pd, pnumstring, gender, cn;
                String interest = "";

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
                /*
                if(cbox_music.isChecked()){
                    interest +=cbox_music.getText().toString();
                }
                if(cbox_game.isChecked()){
                    interest +=", "+cbox_game.getText().toString();
                }

                if(cbox_book.isChecked()){
                    interest +=", "+cbox_book.getText().toString();
                }

                error_msg.setText(interest);
                return;
                */


               EmailValidation ev = new EmailValidation();

                if (fullname.length() == 0) {
                    //error_msg.setText("Please, Enter Full Name.");
                    full_name.setError("Enter Full Name");
                    full_name.requestFocus();

                    return;
                }
                else{

                if (eid.length() == 0) {
                    error_msg.setText("Please, Enter Email ID.");
                    return;
                } else {
                    if (ev.isEmailValid(eid)==false) {
                        email.setError("Invalid Email Address.");
                        email.requestFocus();
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
    //hide keyboard on outside touch
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int[] scrcoords = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }

    public static void hideKeyboard(Activity act) {
        if(act!=null)
            ((InputMethodManager)act.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((act.getWindow().getDecorView().getApplicationWindowToken()), 0);
    }





}
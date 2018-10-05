package com.ibrickedlabs.textfields;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private AppCompatEditText username;
    private AppCompatEditText password;
    private TextInputLayout userLayout;
    private  TextInputLayout passLayout;
    private RelativeLayout relativeLayout;

    /**
     * We can set the colors for EditTexts from colors.xml using
     * colorAscent-EditTextcolor
     * colorError-for error
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userLayout=(TextInputLayout)findViewById(R.id.usernameTextLayout);
        username = (AppCompatEditText) findViewById(R.id.username);
        password = (AppCompatEditText) findViewById(R.id.password);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        passLayout=(TextInputLayout)findViewById(R.id.passwordTextLayout);

        //If user clicks out of the field it will remove foucus from that field
        relativeLayout.setOnClickListener(null);

        //RequiredFields Implementation
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            //will call when the user focuses on it
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(username.getText().toString().isEmpty()){
                    userLayout.setEnabled(true);
                    userLayout.setError("Please enter your username");
                }
                else{
                    userLayout.setErrorEnabled(false);

                }
            }
        });
            //will call when the user type something because we want to remove the error of Edittxt has someting
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //becz it will called soon we enter something & we will remove the error
                if(username.getText().toString().isEmpty()){
                    userLayout.setEnabled(true);
                    userLayout.setError("Please enter your username");
                }
                else{
                    userLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //TO set counter for password field (but send inside on focus for better results)
        passLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(8);






































        // To see which letter is user typing
        /**
         username.addTextChangedListener(new TextWatcher() {
        @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
        System.out.println("onTextChangedInvoked -"+s);
        }

        @Override public void afterTextChanged(Editable s) {

        }
        });**/

        //To check which view has the focus

        /** username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        @Override public void onFocusChange(View v, boolean hasFocus) {
        System.out.println(hasFocus);
        }
        });**/


    }
}

package com.example.faiz_faizal.simpleapps.helper;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;

/**
 * Created by faiz-faizal on 7/11/2017.
 */

public class InputValidation {

    public Context context;

    public InputValidation(Context context) {
        this.context = context;
    }

    public boolean isInputEditTextFilled(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){

        String value = textInputEditText.getText().toString().trim();
        if( value.isEmpty()) {
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }

        else{
            textInputLayout.setErrorEnabled(false);
        }

        return true;

    }

    public boolean isInputEditTextEmail(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){

        String value = textInputEditText.getText().toString().trim();
        if(value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;

        }

        else{
            textInputLayout.setErrorEnabled(false);
        }

        return true;

    }
    
}
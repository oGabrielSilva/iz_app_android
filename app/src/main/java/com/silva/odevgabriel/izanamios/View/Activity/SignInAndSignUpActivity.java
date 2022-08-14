package com.silva.odevgabriel.izanamios.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.silva.odevgabriel.izanamios.Api.FirebaseApi;
import com.silva.odevgabriel.izanamios.R;
import com.silva.odevgabriel.izanamios.View.Listeners.SignInAndSignUpListeners;
import com.silva.odevgabriel.izanamios.View.UI.DialogLoading;

public class SignInAndSignUpActivity extends AppCompatActivity {

    private final ViewHolder viewHolder = new ViewHolder();

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_and_sign_up);

        this.mAuth = FirebaseAuth.getInstance();
        setViewHolder();
        setListeners();
    }

    private void setListeners() {
        new SignInAndSignUpListeners(
                viewHolder.mEmail,
                viewHolder.mTextEmailError,
                viewHolder.mPassword,
                viewHolder.mPasswordEye,
                viewHolder.mTextPasswordEye
        ).setListeners();

        viewHolder.mButtonSignIn.setOnClickListener(view -> {
            boolean validation = SignInAndSignUpListeners.validFieldsAndShowDialog(SignInAndSignUpActivity.this, getResources(), null);
        });

        viewHolder.mButtonSignUp.setOnClickListener(view -> {
            DialogLoading dialog = new DialogLoading(SignInAndSignUpActivity.this);
            dialog.show();
            dialog.setBody(getResources().getString(R.string.sign_up_wait_message_title), getResources().getString(R.string.sign_up_wait_message));
            boolean isValid = SignInAndSignUpListeners.validFieldsAndShowDialog(SignInAndSignUpActivity.this, getResources(), dialog);

            if(isValid) {
                FirebaseApi.createUser(
                        SignInAndSignUpActivity.this,
                        mAuth,
                        String.valueOf(viewHolder.mEmail.getText()),
                        String.valueOf(viewHolder.mPassword.getText()),
                        dialog
                );
            }
        });
    }

    private void setViewHolder() {
        viewHolder.mEmail = findViewById(R.id.edit_email);
        viewHolder.mPassword = findViewById(R.id.edit_password);
        viewHolder.mPasswordEye = findViewById(R.id.image_see_password);
        viewHolder.mTextPasswordEye = findViewById(R.id.text_password);
        viewHolder.mTextEmailError = findViewById(R.id.text_email_error);
        viewHolder.mButtonSignIn = findViewById(R.id.button_sign_in);
        viewHolder.mButtonSignUp = findViewById(R.id.button_sign_up);
    }

    private static class ViewHolder {
        EditText mEmail;
        EditText mPassword;
        ImageView mPasswordEye;
        TextView mTextPasswordEye;
        TextView mTextEmailError;
        Button mButtonSignIn;
        Button mButtonSignUp;
    }
}
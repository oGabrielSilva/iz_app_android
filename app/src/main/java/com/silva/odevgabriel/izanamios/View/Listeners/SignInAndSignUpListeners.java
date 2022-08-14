package com.silva.odevgabriel.izanamios.View.Listeners;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.silva.odevgabriel.izanamios.R;
import com.silva.odevgabriel.izanamios.Utils.Validation;
import com.silva.odevgabriel.izanamios.View.UI.DialogConfirm;
import com.silva.odevgabriel.izanamios.View.UI.DialogLoading;

public class SignInAndSignUpListeners {
    private boolean isPasswordVisible;
    private final EditText mEmail;
    private final TextView mEmailTextError;
    private final EditText mPassword;
    private final ImageView mPasswordEye;
    private final TextView mTextPasswordEye;

    private static Integer emailErrorCode = R.string.email_error_invalid;
    private static Integer passwordErrorCode = R.string.password_error;

    public SignInAndSignUpListeners(
            EditText mEmail,
            TextView mEmailTextError,
            EditText mPassword,
            ImageView mPasswordEye,
            TextView mTextPasswordEye
    ) {
        this.isPasswordVisible = false;
        this.mEmail = mEmail;
        this.mEmailTextError = mEmailTextError;
        this.mPassword = mPassword;
        this.mPasswordEye = mPasswordEye;
        this.mTextPasswordEye = mTextPasswordEye;
    }

    public void setListeners() {

        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                emailErrorCode = Validation.emailValidation(String.valueOf(s));
                if (emailErrorCode != null) {
                    mEmailTextError.setText(emailErrorCode);
                    return;
                }
                mEmailTextError.setText("");
            }
        });

        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordErrorCode = Validation.passwordValidation(String.valueOf(s));
                if (isPasswordVisible) {
                    mTextPasswordEye.setText(String.valueOf(s));
                } else {
                    mTextPasswordEye.setText("");
                }
            }
        });

        mPasswordEye.setOnClickListener(view -> {
            isPasswordVisible = !isPasswordVisible;
            eyePasswordListener(view);
        });

    }

    private void eyePasswordListener(View view) {
        if (view instanceof ImageView) {
            ImageView v = (ImageView) view;
            if (isPasswordVisible) {
                v.setImageResource(R.drawable.ic_eye_off);
                mTextPasswordEye.setText(mPassword.getText());
                return;
            }
            mTextPasswordEye.setText("");
            v.setImageResource(R.drawable.ic_eye);
        }
    }

    public static boolean validFieldsAndShowDialog(Context context, Resources resources, DialogLoading dialogLoading) {
        boolean i = true;
        DialogConfirm dialogConfirm = new DialogConfirm(context);

        if (emailErrorCode != null) {
            dialogConfirm.show();
            dialogConfirm.setTitle(resources.getString(emailErrorCode));
            i = false;
        } else if (passwordErrorCode != null) {
            dialogConfirm.show();
            dialogConfirm.setTitle(resources.getString(passwordErrorCode));
            i = false;
        }

        if(!i && dialogLoading != null) dialogLoading.cancel();

        return i;
    }
}

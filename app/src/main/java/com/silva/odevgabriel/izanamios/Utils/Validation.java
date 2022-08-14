package com.silva.odevgabriel.izanamios.Utils;

import com.silva.odevgabriel.izanamios.R;

public class Validation {
    public static Integer emailValidation(String email) {
        Integer errors = null;
        if(email.length() < 5) return R.string.email_error_invalid;
        if(email.split(" ").length > 1) return R.string.email_error_invalid;
        String[] emailSplit = email.split("@");
        if(emailSplit.length <= 1) {
            errors = R.string.email_error_missing_at;
            return errors;
        }
        if(!emailSplit[1].contains(".")) {
            errors = R.string.email_error_missing_dot;
            return errors;
        }

        String[] emailSplitDot = emailSplit[1].split("\\.");
        if(emailSplitDot.length <= 1) {
            errors = R.string.email_error_invalid;
            return errors;
        }
        return errors;
    }

    public static Integer passwordValidation(String password) {
        return password.length() < 8 ? R.string.password_error : null;
    }
}

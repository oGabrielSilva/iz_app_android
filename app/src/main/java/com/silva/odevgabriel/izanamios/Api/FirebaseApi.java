package com.silva.odevgabriel.izanamios.Api;

import android.app.Activity;
import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.silva.odevgabriel.izanamios.R;
import com.silva.odevgabriel.izanamios.View.UI.DialogConfirm;
import com.silva.odevgabriel.izanamios.View.UI.DialogLoading;

public class FirebaseApi {
    public static void createUser(Context c, FirebaseAuth auth, String email, String password, DialogLoading dialogLoading) {
        if (auth != null) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Activity) c, task -> {
                if (!task.isSuccessful()) {
                    DialogConfirm dialog = new DialogConfirm(c);
                    dialog.show();
                    dialog.setTitle(c.getResources().getString(R.string.generic_server_error));
                }

                if(dialogLoading != null) dialogLoading.cancel();
            });
        }
    }

    public static void verifyUser(FirebaseAuth mAuth) {
        FirebaseUser user = mAuth.getCurrentUser();

        if(!user.isEmailVerified()) {

        }
    }
}

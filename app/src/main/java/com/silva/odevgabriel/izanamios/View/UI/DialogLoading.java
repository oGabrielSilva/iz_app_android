package com.silva.odevgabriel.izanamios.View.UI;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.silva.odevgabriel.izanamios.R;

public class DialogLoading extends Dialog {
    private final ViewHolder viewHolder = new ViewHolder();

    public DialogLoading(@NonNull Context context) {
        super(context);
    }

    public void setBody(String title, String message) {
        if (this.viewHolder != null) {
            if (this.viewHolder.title != null) this.viewHolder.title.setText(title);
            if(this.viewHolder.message != null) this.viewHolder.message.setText(message);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog_loading);
        setCancelable(false);
        Window w = getWindow();
        w.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        w.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        this.viewHolder.title = findViewById(R.id.text_title_dialog_loading);
        this.viewHolder.message = findViewById(R.id.text_message_dialog_loading);
    }

    private static class ViewHolder {
        TextView title;
        TextView message;
    }
}

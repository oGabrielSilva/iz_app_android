package com.silva.odevgabriel.izanamios.View.UI;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.silva.odevgabriel.izanamios.R;

public class DialogConfirm extends Dialog {
    private final ViewHolder viewHolder = new ViewHolder();

    public DialogConfirm(@NonNull Context context) {
        super(context);
    }

    public void setTitle(String title) {
        if (this.viewHolder != null && this.viewHolder.title != null)
            this.viewHolder.title.setText(title);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog_confirm);

        setCancelable(false);

        Window w = getWindow();
        w.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        w.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        this.viewHolder.title = findViewById(R.id.text_title_dialog_confirm);
        this.viewHolder.confirm = findViewById(R.id.button_confirm_dialog_confirm);

        setClickListener();
    }

    private void setClickListener() {
        viewHolder.confirm.setOnClickListener(view -> cancel());
    }

    private static class ViewHolder {
        Button confirm;
        TextView title;
    }
}

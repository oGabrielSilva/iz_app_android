package com.silva.odevgabriel.izanamios.View.Listeners;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;

import java.util.Calendar;

public class DatePicker implements View.OnClickListener {
    private Context context;
    private DatePickerDialog.OnDateSetListener listener;

    public DatePicker(Context context, DatePickerDialog.OnDateSetListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        Calendar c = Calendar.getInstance();

        c.set(2008, 11, 31);

        DatePickerDialog dialog = new DatePickerDialog(context, android.R.style.Theme_DeviceDefault_Dialog_Alert, listener, 2010, 11, 18);
        dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
        dialog.show();
    }
}

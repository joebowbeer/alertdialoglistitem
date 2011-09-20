package com.example.alertdialoglistitem;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.widget.ListAdapter;

public class CheckableListPreference extends ListPreference {

    public CheckableListPreference(Context context) {
        super(context);
    }

    public CheckableListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onPrepareDialogBuilder(Builder builder) {
        int index = findIndexOfValue(getValue()); 
        ListAdapter adapter = new CheckableListAdapter(
                getContext(), getEntries(), index,
                R.layout.list_item, android.R.id.text1, android.R.id.button1);
        builder.setAdapter(adapter, null);
        super.onPrepareDialogBuilder(builder);
    }
}

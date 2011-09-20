package com.example.alertdialoglistitem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends PreferenceActivity implements OnClickListener {

    private static final int DLG_VEGGIE = 0;

    private String[] fruit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    /* AlertDialog with custom ListAdapter */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("AlertDialog");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        showDialog(DLG_VEGGIE);
        return true;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id != DLG_VEGGIE) {
            return null;
        }
        fruit = getResources().getStringArray(R.array.fruit);
        ListAdapter adapter = new CheckableListAdapter(this, fruit, -1,
                R.layout.list_item, android.R.id.text1, android.R.id.button1);
        return new AlertDialog.Builder(this)
                .setTitle("Fruit")
                .setAdapter(adapter, this)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(this, fruit[which] + " selected", Toast.LENGTH_SHORT).show();
    }
}

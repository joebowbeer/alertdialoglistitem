package com.example.alertdialoglistitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.RadioButton;
import android.widget.TextView;

public class CheckableListAdapter extends BaseAdapter {

    private final Context context;
    private final CharSequence[] names;
    private final int selected;
    private final int layoutId;
    private final int labelId;
    private final int checkableId;

    public CheckableListAdapter(Context context, CharSequence[] names,
            int selected, int layoutId, int labelId, int checkableId) {
        this.context = context;
        this.names = names;
        this.selected = selected;
        this.layoutId = layoutId;
        this.labelId = labelId;
        this.checkableId = checkableId;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(layoutId, parent, false);
            TextView label = (TextView) view.findViewById(labelId);
            RadioButton button = (RadioButton) view.findViewById(checkableId);
            view.setTag(new Holder(label, button));
        }
        Holder holder = (Holder) view.getTag();
        holder.label.setText(names[position]);
        holder.checkable.setChecked(position == selected);
        return view;
    }

    private static class Holder {

        public final TextView label;
        public final Checkable checkable;

        public Holder(TextView label, Checkable button) {
            this.label = label;
            this.checkable = button;
        }
    }
}

package com.example.jsonparse;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentsAdapter<S> extends ArrayAdapter<String> {

    public StudentsAdapter(Context context, int resource) {
        super(context, resource);
    }

    public StudentsAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public StudentsAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public StudentsAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public StudentsAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    public StudentsAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.activity_list_item, parent, false);

        TextView textView = (TextView) customView.findViewById(R.id.l_item_txt);

        String item = getItem(position);

        String[] splitItem = item.split(" ");
        double grade = Double.parseDouble(splitItem[1]);

        textView.setText(item);

        if (grade > 7.0) {
            textView.setBackgroundColor(Color.RED);
        }

        return customView;
    }
}
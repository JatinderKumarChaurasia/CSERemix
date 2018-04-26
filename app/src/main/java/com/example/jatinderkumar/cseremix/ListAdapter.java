package com.example.jatinderkumar.cseremix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jatinderkumar.cseremix.data.Person;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Person> {

    public ListAdapter(@NonNull Context context,ArrayList<Person> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout,parent,false);
        }
        Person person = (Person)getItem(position);
        TextView name = null;
        if (view != null) {
            name = view.findViewById(R.id.nameLayout);
        }
        TextView address = null;
        if (view != null) {
            address = view.findViewById(R.id.addressLayout);
        }
        if (name != null) {
            assert person != null;
            name.setText(person.getName());
        }
        assert address != null;
        assert person != null;
        address.setText(String.valueOf(person.getPhone()));
        return view;
    }
}

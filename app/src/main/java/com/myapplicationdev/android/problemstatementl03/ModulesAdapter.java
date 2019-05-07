package com.myapplicationdev.android.problemstatementl03;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModulesAdapter extends ArrayAdapter<Modules> {

    private ArrayList<Modules> modules;
    private Context context;
    private TextView tvDG;
    private TextView tvGrade;
    private TextView tvWeek;
    private TextView tvModuleCode;
    private ImageView iv;

    public ModulesAdapter(Context context, int resource, ArrayList<Modules> objects){
        super(context,resource,objects);
        // Store the food that is passed to this adapter
        modules = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvDG = rowView.findViewById(R.id.textViewDG);

        tvGrade = rowView.findViewById(R.id.textViewGrade);
        tvWeek =  rowView.findViewById(R.id.textViewWeek);
        tvModuleCode = rowView.findViewById(R.id.textViewModuleCode);
        iv = rowView.findViewById(R.id.imageViewImg);

        Modules currentMol = modules.get(position);

        tvWeek.setText(String.valueOf("Week" + currentMol.getWeek()));
        tvModuleCode.setText(currentMol.getModuleCode());
        tvDG.setText(currentMol.getDG());
        tvGrade.setText((currentMol.getGrade()));
        iv.setImageResource(R.drawable.dg);

        // Return the nicely done up View to the ListView
        return rowView;
    }

}

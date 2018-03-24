package com.example.obi.gymactivitylog;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String>
{
    public CustomAdapter(Context context, ArrayList<String> stringval){
        super (context,0,stringval);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = convertView;
        if(MainActivity.showcheckboxes)
        {
 //           v.findViewById(R.id.checkbox).setVisibility(convertView.VISIBLE);
        }
        else
        {
//            v.findViewById(R.id.checkbox).setVisibility(convertView.INVISIBLE);
        }
        if(MainActivity.showextrabuttons)
        {
            //Set Visibility On for extra buttons
        }

        return v;
    }
}

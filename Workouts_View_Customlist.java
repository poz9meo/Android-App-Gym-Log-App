package com.example.obi.gymactivitylog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
/**
 * Created by OBI on 7/22/2017.
 */

public class Workouts_View_Customlist extends ArrayAdapter<String> {

    private Activity mycontext;
    private List<String> Activityname;
    private List<Integer> imageId;
    private List<String> Weightvalue;
    private List<String> Repsvalue;

    public Workouts_View_Customlist(Activity mycontext,List<String> Activityname, List<Integer> imageId,
                                    List<String> Weight, List<String> Reps)
    {
        super(mycontext,R.layout.custom_workouts_view_list,Activityname);
        this.mycontext=mycontext;
        this.Activityname=Activityname;
        this.imageId=imageId;
        this.Weightvalue = Weight;
        this.Repsvalue = Reps;
    }

    public void SetListEntries (Activity mycontextMember,List<String> activityNameMember,List<Integer> imageIDMember,
                                List<String> weightMember, List<String> repsMember)
    {
        this.mycontext = mycontextMember;
        this.Activityname = activityNameMember;
        this.imageId = imageIDMember;
        this.Weightvalue = weightMember;
        this.Repsvalue = repsMember;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflate = mycontext.getLayoutInflater();
        View rowview = inflate.inflate(R.layout.custom_workouts_view_list,null,true);
        TextView txtTitle = (TextView) rowview.findViewById(R.id.Activity);
        TextView weight = (TextView) rowview.findViewById(R.id.Weight);
        TextView reps = (TextView) rowview.findViewById(R.id.Reps);

        txtTitle.setText(Activityname.get(position));
        weight.setText((Weightvalue.get(position)));
        reps.setText((Repsvalue.get(position)));

        return rowview;
    }
}

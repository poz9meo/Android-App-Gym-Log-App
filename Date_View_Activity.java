package com.example.obi.gymactivitylog;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Date_View_Activity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener{

    List<String> date_list = new ArrayList<String>();
    ArrayAdapter<String> date_list_Adapter;
    boolean modifying = false;
    int clickedMenuPosition = 0;
    public static String date_position_name;
    public String Log_File_Name = (MainActivity.Home_List_Member_Clicked + "Log");
    public static Integer [] Date_View_List_Latest_Position = new Integer[1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_view);

        final ListView Date_View_List = (ListView) findViewById(R.id.Date_View_List) ;

        date_list = get_Date_List_String_Info();
       // MainActivity.List_Position_Clicked

        date_list_Adapter = new ArrayAdapter(this, R.layout.text_date_list,R.id.item2,date_list);
        Date_View_List.setAdapter(date_list_Adapter);
        registerForContextMenu(Date_View_List);

        final FloatingActionButton FloatingButton = (FloatingActionButton) findViewById(R.id.fab_date_view);

        FloatingButton.setOnClickListener(new View.OnClickListener(){
                                              public void onClick(View v){
                                                  fabdatepressed();
                                              }
                                          }
        );

       Date_View_List.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                date_position_name = date_list.get(position);
                Date_date_list_view_item_clicked(position);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflatemenu = getMenuInflater();
        inflatemenu.inflate(R.menu.menu_main,menu);

    }

    public void onBackPressed()
    {

    }

    //Called by activity when Date FAB is pressed
    public void fabdatepressed()
    {
        DialogFragment newFrag = new DateDialogFragment();
        newFrag.show(getFragmentManager(),"DatePicker");
        modifying = false;

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String[] Weekdays = { "Wednesday","Thursday","Friday", "Saturday","Sunday", "Monday","Tuesday"};
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DATE, dayOfMonth);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        String Month_Display = Integer.toString(month+1);
        String Day_Display = Integer.toString(dayOfMonth);
        if(Month_Display.length()<2)
            Month_Display = ("0"+Month_Display);
        if(Day_Display.length() < 2)
            Day_Display = ("0"+Day_Display);
        save_Date_List_String_Info(Weekdays[dayOfWeek-1]+" - "+Month_Display+"."+Day_Display+"."+Integer.toString(year));
        Date_View_List_Latest_Position[MainActivity.home_position] = 0;
        date_list_Adapter.notifyDataSetChanged();
    }

    //Save String Info Entered
    public void save_Date_List_String_Info(String stringtosave)
    {
        boolean String_Was_Added_To_List = false;
        if(date_list.contains(stringtosave))
        {
            Toast.makeText(this,"Entry already exists",Toast.LENGTH_SHORT).show();
        }
        else if(modifying)
            date_list.set(clickedMenuPosition, stringtosave);
        else
        {
            date_list.add(stringtosave);
            for (int i = date_list.size(); i > 1; i = i - 1) {
                date_list.set(i-1,date_list.get(i-2));
            }
            date_list.set(0,stringtosave);
            String_Was_Added_To_List = true;
        }


        StringBuilder Compiled_String = new StringBuilder();
        for (String s:date_list)
        {
            Compiled_String.append(s);
            Compiled_String.append(",");
        }
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString(Log_File_Name, Compiled_String.toString());
        medit.commit(); //Save List even after app is closed

        if(String_Was_Added_To_List)
            Date_date_list_view_item_clicked(0);
    }

    //Gets the string info when app is started
    private List<String> get_Date_List_String_Info()
    {
        List<String> Home_Screen_List = new ArrayList<String>();
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        String Compiled_String = sharedpref.getString(Log_File_Name," ");

        String[] individual_entries = Compiled_String.split(",");

        for (int i = 0; i < individual_entries.length; i++) {
            if (individual_entries[i].trim().length()>0)
                Home_Screen_List.add(individual_entries[i]);
        }
        return Home_Screen_List;
    }

    public void remove_item(int position)
    {
        date_list.remove(position);
        Date_View_List_Latest_Position[MainActivity.home_position] = date_list.size();

        StringBuilder Compiled_String = new StringBuilder();
        for (String s:date_list)
        {
            Compiled_String.append(s);
            Compiled_String.append(",");
        }
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString(Log_File_Name, Compiled_String.toString());
        medit.commit(); //Save List even after app is closed

        //Remove workouts_view_lists too (images, activity name, reps)
    }
    public void ModifyItem(final int listMenuPosition)
    {
        DialogFragment newFrag = new DateDialogFragment();
        newFrag.show(getFragmentManager(),"DatePicker");
        modifying = true;
        clickedMenuPosition = listMenuPosition;
    }

    public void Date_date_list_view_item_clicked(int position)
    {
        Intent intent = new Intent();
        date_position_name =  date_list.get(position);
                                            //Name of activity created
        intent.setClass(Date_View_Activity.this,Workouts_View_Activity.class);
        startActivityForResult(intent, Intent_Constants.INTENT_REQUEST_CODE_2);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId())
        {
            case R.id.Delete_Item:
                remove_item(menuInfo.position);
                date_list_Adapter.notifyDataSetChanged();
                return true;
            case R.id.Modify_Item:
                ModifyItem(menuInfo.position);
                date_list_Adapter.notifyDataSetChanged();
            default:
                return super.onContextItemSelected(item);
        }
    }
}

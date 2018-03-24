package com.example.obi.gymactivitylog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static boolean showcheckboxes = false;
    public static boolean showextrabuttons = false;
    public static String Home_List_Member_Clicked;
    public static int home_position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //set view for main activity

        //set up list in main activity and adapter for syncing list entries; tied to get_home_list_string_info
        final ListView Home_View_List = (ListView) findViewById(R.id.Home_View_List) ;
       // list = get_Home_List_String_Info();

        String[] list_string = {"History","Stats","Activity Library","Schedule","Suggested Reads"};
        List<String> list = Arrays.asList(list_string);
        ArrayAdapter<String> list_Adapter;
        list_Adapter = new ArrayAdapter<String>(this,R.layout.center_text_home_list,R.id.item,list);
        Home_View_List.setAdapter(list_Adapter);

        //Set up menu for long clicking list entries; tied to onCreateContextMenu, onContextItemSelected
      //  registerForContextMenu(Home_View_List);

        //Set up floating button and button action tied to fabhomepressed
      /*  final FloatingActionButton FloatingButton = (FloatingActionButton) findViewById(R.id.fab);
        FloatingButton.setOnClickListener(new View.OnClickListener(){
                                              public void onClick(View v){
                                                  fabhomepressed(list_Adapter);
                                              }
                                          }
        ); */

        //set up what happens when list item is clicked; tied to list_view_item_clicked
        Home_View_List.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    list_view_item_clicked(position);
                }
            }
        });

    }

    //Called by activity when home FAB is pressed
   /* public void fabhomepressed(final ArrayAdapter<String> adapter)
    {
        //Create builder for the alert dialog
        final AlertDialog log_week_entry_builder = new AlertDialog.Builder(this).create();

        //set up view for the alert dialog
        final View log_week_entry_view = getLayoutInflater().inflate(R.layout.home_fab_dialog_fragment, null);
        final EditText log_week_text = (EditText) log_week_entry_view.findViewById(R.id.textView);
        Button ok_button = (Button) log_week_entry_view.findViewById(R.id.button);
        Button cancel_button = (Button) log_week_entry_view.findViewById(R.id.button2);

        //Link builder to the view
        log_week_entry_builder.setView(log_week_entry_view);

        //Show the alert dialog
        log_week_entry_builder.show();

        //Set up Ok button listener; tied to save_home_list_string_info
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!log_week_text.getText().toString().isEmpty())&(log_week_text.getText().toString().trim().length()>0) )
                {
                    //Save to String list of Week Logs if not empty
                    save_Home_List_String_Info(log_week_text.getText().toString());
                    //Refreshes view list
                    adapter.notifyDataSetChanged();
                }

                log_week_entry_builder.dismiss();
            }
        });

        //Set up cancel button listener
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log_week_entry_builder.dismiss();
            }
        });
    }*/

    //Save String Info Entered
  /*  public void save_Home_List_String_Info(String stringtosave)
    {

        //Check if entry already exists to avoid duplicate names
        if(list.contains(stringtosave))
        {
            Toast.makeText(this,"Entry already exists",Toast.LENGTH_SHORT).show();
        }

        else
            list.add(stringtosave); //Add entry to list

        //Format string and add "," to separate entries
        StringBuilder Compiled_String = new StringBuilder();
        for (String s:list)
        {
            Compiled_String.append(s);
            Compiled_String.append(",");
        }

        //Shared preferences initialization and save list to shared preferences
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString("Home_Screen_Log", Compiled_String.toString());
        medit.commit(); //Save List even after app is closed
    } */

    //Gets the string info when app is started
  /*  private List<String> get_Home_List_String_Info()
    {
        List<String> Home_Screen_List = new ArrayList<String>();
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        String Compiled_String = sharedpref.getString("Home_Screen_Log"," ");

        String[] individual_entries = Compiled_String.split(",");

        for (int i = 0; i < individual_entries.length; i++) {
            if (individual_entries[i].trim().length()>0)
            Home_Screen_List.add(individual_entries[i]);
        }
        return Home_Screen_List;
    }

    //Removing item from the home list
    public void remove_item(int position)
    {
        //Remove item based off position from the list

        String LogfileNameActivityName;
        String LogfileNameImageID;
        String LogfileNameWeight;
        String LogfileNameReps;

    if(Date_View_Activity.Date_View_List_Latest_Position[position]!= null)
       for(int iterator=0;(iterator <Date_View_Activity.Date_View_List_Latest_Position[position]);iterator++)
        {
            LogfileNameWeight = ("HomeView_" + list.get(position) + "_DateView_" +
                    Integer.toString(iterator) + "_Weight");
            LogfileNameImageID = ("HomeView_" + list.get(position) + "_DateView_" +
                    Integer.toString(iterator) + "_ImageID");
            LogfileNameActivityName = ("HomeView_" + list.get(position)+ "_DateView_" +
                    Integer.toString(iterator) + "_ActivityName");
            LogfileNameReps = ("HomeView_" + list.get(position) + "_DateView_" +
                    Integer.toString(iterator) + "_Reps");

            SharedPreferences sharedpref_ActivityName = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
            SharedPreferences.Editor medit_ActivityName = sharedpref_ActivityName.edit();
            medit_ActivityName.remove(LogfileNameActivityName);

            SharedPreferences sharedpref_ImageID = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
            SharedPreferences.Editor medit_ImageID = sharedpref_ImageID.edit();
            medit_ImageID.remove(LogfileNameImageID);

            SharedPreferences sharedpref_Weight = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
            SharedPreferences.Editor medit_Weight = sharedpref_Weight.edit();
            medit_Weight.remove(LogfileNameWeight);

            SharedPreferences sharedpref_Reps = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
            SharedPreferences.Editor medit_Reps = sharedpref_Reps.edit();
            medit_Reps.remove(LogfileNameReps);
        }

        String corresponding_date_view_data_name = (list.get(position)+ "Log");
        list.remove(position);

        //Redo list with ","
        StringBuilder Compiled_String = new StringBuilder();
        for (String s:list)
        {
            Compiled_String.append(s);
            Compiled_String.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString("Home_Screen_Log", Compiled_String.toString());
        medit.commit(); //Save List even after app is closed

        //Update shared preferences to remove the date view activity entry for list entry to be removed
        SharedPreferences sharedpref2 = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit2 = sharedpref2.edit();
        medit2.remove(corresponding_date_view_data_name);
        medit2.commit(); //Save List even after app is closed
    }
*/
    //Set up intent to run date view activity when list item is clicked
    public void list_view_item_clicked(int position_clicked)
    {
        Intent intent = new Intent();
        home_position = position_clicked;
       // Home_List_Member_Clicked = list.get(position_clicked);
                                            //Name of activity created
        intent.setClass(MainActivity.this,Date_View_Activity.class);
        startActivityForResult(intent, Intent_Constants.INTENT_REQUEST_CODE);
    }

  /*  public void ModifyItem(final int listMenuPosition)
    {
        //initialize dialog builder
        final AlertDialog log_week_entry_builder = new AlertDialog.Builder(this).create();

        //Initialize dialog view
        final View log_week_entry_view = getLayoutInflater().inflate(R.layout.home_fab_dialog_fragment, null);
        final EditText log_week_text = (EditText) log_week_entry_view.findViewById(R.id.textView);
        Button ok_button = (Button) log_week_entry_view.findViewById(R.id.button);
        Button cancel_button = (Button) log_week_entry_view.findViewById(R.id.button2);

        //Initialize text shown to list entry text to be modified
        log_week_text.setText(list.get(listMenuPosition));

        //link builder with view
        log_week_entry_builder.setView(log_week_entry_view);

        //show dialog
        log_week_entry_builder.show();

        //Set up OK button action and save entry only when entry isn't empty; tied to save_Modified_Home_List_String_Info
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!log_week_text.getText().toString().isEmpty())&(log_week_text.getText().toString().trim().length()>0) )
                {
                    //Save to String list of Week Logs if not empty
                    save_Modified_Home_List_String_Info(log_week_text.getText().toString(), listMenuPosition);
                    //Refreshes view list
                    list_Adapter.notifyDataSetChanged();
                }

                log_week_entry_builder.dismiss();
            }
        });

        //set up cancel button action
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log_week_entry_builder.dismiss();
            }
        });
    }

    public void save_Modified_Home_List_String_Info(String string, int position)
    {

        //Check if entry already exists to avoid duplicate names
        if(list.contains(string))
        {
            Toast.makeText(this,"Entry already exists",Toast.LENGTH_SHORT).show();
        }

        else
            list.set(position, string);

        //Format string and add "," to separate entries
        StringBuilder Compiled_String = new StringBuilder();
        for (String s:list)
        {
            Compiled_String.append(s);
            Compiled_String.append(",");
        }

        //Initialize sharedpreferences and save list entry
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString("Home_Screen_Log", Compiled_String.toString());
        medit.commit(); //Save List even after app is closed

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflatemenu = getMenuInflater();
        inflatemenu.inflate(R.menu.menu_main,menu);

    }

    //Context Menu set up
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId())
        {
            case R.id.Delete_Item:
                remove_item(menuInfo.position);
                list_Adapter.notifyDataSetChanged();
                return true;
            case R.id.Modify_Item:
                ModifyItem(menuInfo.position);
                list_Adapter.notifyDataSetChanged();
            default:
                return super.onContextItemSelected(item);
        }
    }*/
}

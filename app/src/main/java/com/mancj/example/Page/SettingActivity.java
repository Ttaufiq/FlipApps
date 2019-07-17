package com.mancj.example.Page;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mancj.example.R;
import com.mancj.example.dialog.SingleChoiceDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SettingActivity extends AppCompatActivity implements SingleChoiceDialog.SingleChoiceListener {

    ListView listViewSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = findViewById(R.id.toolbar);
        listViewSetting = findViewById(R.id.listViewSetting);

        // For the App Bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Setting"); // Set the title for the app bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Give the app bar a back button

        // For the list view
        HashMap<String, String> a = new HashMap<>();
        a.put("Notification", "Manage notification setting");
        a.put("App Download Preferences", "Over any network");
        a.put("Auto-Update apps", "Auto-Update apps over Wi-Fi only");
        a.put("Add icon to Home Screen", "For new apps");
        a.put("Clear local search history", "Remove searches you have performed from this device");

        List<HashMap<String, String>> list = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.custom_setting_layout,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.settingTitle, R.id.subtitleSetting});

        Iterator it = a.entrySet().iterator();
        while(it.hasNext()) {
            HashMap<String, String> result = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            result.put("First Line", pair.getKey().toString());
            result.put("Second Line", pair.getValue().toString());
            list.add(result);
        }

        listViewSetting.setAdapter(adapter);
        listViewSetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        openDialog("app_download");
                        break;
                    case 4:
                        openDialog("app_update");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void openDialog(String title) {
        DialogFragment singleChoiceDialog = new SingleChoiceDialog(title);
        singleChoiceDialog.setCancelable(false);
        singleChoiceDialog.show(getSupportFragmentManager(), "Single Choice Dialog");
    }

    @Override
    public void onPositiveButtonClicked(String[] list, int position) {

    }

    @Override
    public void onNegativeButtonClicked() {

    }
}

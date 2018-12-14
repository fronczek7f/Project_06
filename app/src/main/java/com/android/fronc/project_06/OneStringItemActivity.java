package com.android.fronc.project_06;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class OneStringItemActivity extends AppCompatActivity {

    private ListView lvListItems;
    private String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_string_item);

        lvListItems = (ListView) findViewById(R.id.lvOneStringItem);
        initResource();
        initListView();
    }

    private void initResource() {
        Resources resources = getResources();
        listItems = resources.getStringArray(R.array.listItems);
    }

    private void initListView() {
        lvListItems.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_expandable_list_item_1, listItems)
        );

        lvListItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listItems[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

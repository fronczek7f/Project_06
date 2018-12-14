package com.android.fronc.project_06;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleItemLayoutActivity extends AppCompatActivity {

    private ListView lvListItems;
    private String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_item_layout);

        lvListItems = (ListView) findViewById(R.id.lvSimpleItem);
        initResource();
        initListView();
    }

    private void initResource() {
        Resources resources = getResources();
        listItems = resources.getStringArray(R.array.listItems);
    }

    private void initListView() {
        lvListItems.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(), R.layout.simple_item_layout, listItems)
        );

        lvListItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listItems[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.android.fronc.project_06;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoStringItemActivity extends AppCompatActivity {

    private ListView lvListItems;
    private String[] listItemTitles;
    private String[] listItemSubTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_string_item);

        lvListItems = (ListView) findViewById(R.id.lvTwoStringItem);
        initResource();
        initListView();
    }

    private void initResource() {
        Resources resources = getResources();
        listItemTitles = resources.getStringArray(R.array.listItemTitles);
        listItemSubTitles = resources.getStringArray(R.array.listItemSubTitles);
    }

    private void initListView() {
        ArrayList<Map<String, String>> arrayList = new ArrayList<Map<String, String>>();
        int arrayLength = listItemTitles.length;
        for (int i = 0; i < arrayLength; i++) {
            Map<String, String> listItemMap = new HashMap<String, String>();
            listItemMap.put("title", listItemTitles[i]);
            listItemMap.put("description", listItemSubTitles[i]);
            arrayList.add(listItemMap);
        }

        lvListItems.setAdapter(new SimpleAdapter(getApplicationContext(), arrayList,
                android.R.layout.simple_list_item_2,
                new String[]{"title", "description"},
                new int[]{android.R.id.text1, android.R.id.text2})
        );

        lvListItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listItemTitles[position] + "\n" + listItemSubTitles[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.android.fronc.project_06;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomActivity extends AppCompatActivity {

    private ListView lvCustom;
    private String[] title;
    private String[] subTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        lvCustom = (ListView) findViewById(R.id.lvCustom);
        initResources();
        initLanguagesListView();
    }

    private void initResources() {
        Resources res = getResources();
        title = res.getStringArray(R.array.listItems);
        subTitle = res.getStringArray(R.array.listItemSubTitles);
    }

    private void initLanguagesListView() {
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, title, subTitle);
        lvCustom.setAdapter(adapter);

        lvCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                Toast.makeText(CustomActivity.this, title[pos], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

class CustomArrayAdapter extends ArrayAdapter<String> {

    private Activity activity;
    private String[] lvCustomTitle;
    private String[] lvCustomSubTitle;

    public CustomArrayAdapter(Activity activity, String[] lvCustomTitle, String[] lvCustomSubTitle) {
        super(activity, R.layout.custom_layout, lvCustomTitle);
        this.activity = activity;
        this.lvCustomTitle = lvCustomTitle;
        this.lvCustomSubTitle = lvCustomSubTitle;
    }

    static class ViewHolder {
        public TextView tvCustomTitle;
        public TextView tvCustomSubTitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.custom_layout, null, true);
            viewHolder = new ViewHolder();
            viewHolder.tvCustomTitle = (TextView) view.findViewById(R.id.customTitle);
            viewHolder.tvCustomSubTitle = (TextView) view.findViewById(R.id.customSubTitle);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvCustomTitle.setText(lvCustomTitle[position]);
        viewHolder.tvCustomSubTitle.setText(lvCustomSubTitle[position]);
        return view;
    }
}

package com.example.mauro.listviewexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.a_main_et)
    EditText editText;
    @BindView(R.id.a_main_btn)
    Button button;
    @BindView(R.id.a_main_list)
    ListView listView;

    private List<String> stringList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setUpListView();
    }

    private void setUpListView() {
        stringList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(adapter);
    }

    public void addElement(View view) {
        String text = editText.getText().toString();

        stringList.add(text);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }
}

package com.example.utsav.exampledb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.listView);
        ExampleDB db=new ExampleDB( this );
        ArrayList<Map<String,String>>arrayList= new ArrayList();
        arrayList=db.getDatafromDatabase();
        ListAdapter adapter=new ListAdapter(this,arrayList);
        listView.setAdapter((android.widget.ListAdapter) adapter);
    }
}

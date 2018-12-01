package com.example.utsav.exampledb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Map<String, String>> arr;
    public ListAdapter(Context context, ArrayList <Map <String, String>> arr)
    {
        this.context=context;
        this.arr=arr;
    }
    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customview;
        customview = LayoutInflater.from(context).inflate( R.layout.list_item,viewGroup,false);
        TextView name = customview.findViewById( R.id.tv1);
        TextView college = customview.findViewById( R.id.tv2);
        name.setText(arr.get(i).get(ExampleDB.FIRST_NAME));
        college.setText(arr.get(i).get(ExampleDB.LAST_NAME));
        return customview;
    }
}

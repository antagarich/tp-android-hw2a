package com.example.tp_android_hw;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter{

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getItem(int listnumber) {
		// TODO Auto-generated method stub
		return listnumber;
	}

	@Override
	public long getItemId(int listnumber) {
		// TODO Auto-generated method stub
		return listnumber;
	}

	@Override
	public View getView(int listnumber, View convertView, ViewGroup parent) 
    {
		// TODO Auto-generated method stub
        View view=convertView;
        if(convertView==null)
            view = inflater.inflate(R.layout.item, null);

        TextView text=(TextView)view.findViewById(R.id.text);;
        ImageView image=(ImageView)view.findViewById(R.id.image);
        image.setImageResource(R.drawable.placeholder);
        text.setText("Element " + listnumber);
        
        Task task = new Task(image);
        task.execute(data[listnumber]);
        return view;
    }
	
	private Activity activity;
    private String[] data;
    private static LayoutInflater inflater = null; 
    
    public Adapter(Activity adapter, String[] data) {
        this.activity = adapter;
        this.data = data;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
}

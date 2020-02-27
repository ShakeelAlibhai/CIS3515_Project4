package edu.temple.newcolorproject;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    private Context c;
    private String[] data;

    public ColorAdapter(Context c, String[] data) {
        this.c = c;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView t = new TextView(c);
        t.setText(getItem(position).toString());

        //These are used to set the colors internally
        //These names are not displayed to the user
        //Note: The order of the colors here much match the order in strings.xml
        String internalColors[] = {
                "Blue",
                "Red",
                "White",
                "Yellow",
                "Green",
                "Aqua",
                "Olive",
                "Lime",
                "Cyan",
                "Silver"
        };

        t.setBackgroundColor(Color.parseColor(internalColors[position]));
        return t;
    }
}

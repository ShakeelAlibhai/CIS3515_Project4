package edu.temple.newcolorproject;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {


    public CanvasFragment() {
        // Required empty public constructor
    }

    int colorIndex;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();
        if(b != null) {
            colorIndex = b.getInt("indexKey");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);

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

        v.setBackgroundColor(Color.parseColor(internalColors[colorIndex]));

        TextView colorTextView = v.findViewById(R.id.colorText);
        String colors[] = getResources().getStringArray(R.array.colors_array);
        colorTextView.setText(colors[colorIndex]);

        return v;
    }

    public static CanvasFragment newInstance(int colorIndex) {
        CanvasFragment c = new CanvasFragment();
        Bundle b = new Bundle();
        b.putInt("indexKey", colorIndex);
        c.setArguments(b);
        return c;
    }
}

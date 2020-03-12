package edu.temple.newcolorproject;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {


    public PaletteFragment() {
        // Required empty public constructor
    }

    PaletteInterface parentActivity;
    String colors[];
    private boolean firstSelection = true;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof PaletteInterface) {
            parentActivity = (PaletteInterface)context;
        } else {
            throw new RuntimeException("Please implement PaletteInterface!");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();
        if(b != null) {
            colors = b.getStringArray("colors");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        Spinner s;
        s = v.findViewById(R.id.spinner);

//        Context context = getApplicationContext();
//        Resources res = context.getResources();
        String colors[] = getResources().getStringArray(R.array.colors_array);

        ColorAdapter a = new ColorAdapter(getActivity(), colors);
        s.setAdapter(a);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(firstSelection) {
                    firstSelection = false;
                } else {
                    parentActivity.colorChosen(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    public static PaletteFragment newInstance(String colors[]) {
        PaletteFragment p = new PaletteFragment();
        Bundle b = new Bundle();
        b.putStringArray("colors", colors);
        p.setArguments(b);
        return p;
    }

    interface PaletteInterface {
        public void colorChosen(int colorIndex);
    }

}

package edu.temple.newcolorproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity  implements PaletteFragment.PaletteInterface {

    public static final String INTENT_COLOR_KEY = "color";
    private boolean firstSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        Context context = getApplicationContext();
        Resources res = context.getResources();
        String colors[] = res.getStringArray(R.array.colors_array);

        PaletteFragment p = PaletteFragment.newInstance(colors);
        FragmentManager f = getSupportFragmentManager();
        FragmentTransaction t = f.beginTransaction();
        t.add(R.id.container1, p);
        t.commit();
    }

    public void colorChosen(int colorIndex) {
        //Call CanvasFragment to change the color to the color at colorIndex
        CanvasFragment c = CanvasFragment.newInstance(colorIndex);

        FragmentManager f = getSupportFragmentManager();
        FragmentTransaction t = f.beginTransaction();
        t.addToBackStack(null).add(R.id.container1, c);
        t.commit();
    }
}

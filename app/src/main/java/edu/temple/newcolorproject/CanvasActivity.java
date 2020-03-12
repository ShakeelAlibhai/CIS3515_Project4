package edu.temple.newcolorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intent = getIntent();
        int colorIndex = intent.getIntExtra(PaletteActivity.INTENT_COLOR_KEY, 0);

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

        findViewById(R.id.canvasFragment).setBackgroundColor(Color.parseColor(internalColors[colorIndex]));

        TextView colorTextView = findViewById(R.id.colorText);
        Context context = getApplicationContext();
        Resources res = context.getResources();
        String colors[] = res.getStringArray(R.array.colors_array);
        colorTextView.setText(colors[colorIndex]);
    }
}

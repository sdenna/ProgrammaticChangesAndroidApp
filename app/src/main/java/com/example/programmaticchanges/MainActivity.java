package com.example.programmaticchanges;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // variables for the whole activity
    // includes references to all the XML components I will use
    int clickCount;
    TextView labelTV;
    ConstraintLayout myLayout;
    ImageView starImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickCount = 0;

        // instantiating the XML components so they are ready to use in all methods
        labelTV = findViewById(R.id.textView);
        myLayout = findViewById(R.id.main_layout);
        // I set an id for the ConstraintLayout in activity_main.xml
        // so I could reference the entire view background

        starImage = findViewById(R.id.starButton);

    }

    public void oneMethod(View v) {
        clickCount++;
        String buttonName = "none";

        /*
        Gets the button that was clicked on to trigger this method call.
        https://stackoverflow.com/questions/13032333/droid-how-to-get-button-id-from-onclick-method-described-in-xml
         */

        switch (v.getId()) {
            case R.id.colorButton:
                buttonName = "colorButton";
                // do something
                break;
            case R.id.otherButton:
                // do something
                buttonName = "otherButton";
                break;
        }
        Log.i("Denna", "Clicked on: " + buttonName + " and clickCount is: " + clickCount);

        if (buttonName.equals("colorButton")) {
            if (clickCount % 2 == 0) {
                labelTV.setText(R.string.tealText);
                myLayout.setBackgroundColor(getResources().getColor(R.color.teal_200));
            } else {
                labelTV.setText(R.string.yellowText);
                myLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
        } else if (buttonName.equals("otherButton")) {
            // toggle image visability
            if (clickCount % 2 == 0) {
                starImage.setVisibility(View.VISIBLE);
            }
            else {
                starImage.setVisibility(View.INVISIBLE);
            }
        }
    }

}








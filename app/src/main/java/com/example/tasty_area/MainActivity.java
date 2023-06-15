package com.example.tasty_area;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    static final int GET_RESULT = 1;

    SliderAdaptor sliderAdaptor;
    ViewPager viewPager;
    TextView radiusText;
    SeekBar seekBar;
    Button searchButton;
    int radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view);
        sliderAdaptor = new SliderAdaptor(this);
        viewPager.setAdapter(sliderAdaptor);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        radiusText = (TextView) findViewById(R.id.radiusText);
        radiusText.setText("200m");
        radius = 200;

        searchButton = (Button) findViewById(R.id.searchButton);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                switch (seekBar.getProgress()) {
                    case 0:
                        radiusText.setText("200m");
                        radius = 200;
                        break;
                    case 1:
                        radiusText.setText("400m");
                        radius = 400;
                        break;
                    case 2:
                        radiusText.setText("600m");
                        radius = 600;
                        break;
                    case 3:
                        radiusText.setText("800m");
                        radius = 800;
                        break;
                    case 4:
                        radiusText.setText("1km");
                        radius = 1000;
                        break;
                }
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapComponent.class);
                intent.putExtra("radius", radius);
                startActivity(intent);
            }
        });

    }
}
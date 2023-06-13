package com.example.tasty_area;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SliderAdaptor sliderAdaptor;
    ViewPager viewPager;
    TextView radiusText;
    SeekBar seekBar;
    int radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view);
        sliderAdaptor = new SliderAdaptor(this);
        viewPager.setAdapter(sliderAdaptor);

        seekBar = findViewById(R.id.seekBar);
        radiusText = findViewById(R.id.radiusText);
        radiusText.setText("200m");
        radius = 200;

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

    }
}
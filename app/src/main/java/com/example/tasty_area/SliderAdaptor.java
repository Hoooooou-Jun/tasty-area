package com.example.tasty_area;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdaptor extends PagerAdapter {

    private int[] images = { R.drawable.korea, R.drawable.china, R.drawable.japan, R.drawable.usa };
    private LayoutInflater inflater;
    private Context context;

    public SliderAdaptor(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.component_slider, container, false);

        ImageView foodView = (ImageView) v.findViewById(R.id.foodView);
        TextView foodTextView = (TextView) v.findViewById(R.id.foodTextView);

        foodView.setImageResource(images[position]);
        switch (position) {
            case 0:
                foodTextView.setText("한식");
                break;
            case 1:
                foodTextView.setText("중식");
                break;
            case 2:
                foodTextView.setText("일식");
                break;
            case 3:
                foodTextView.setText("양식");
                break;
        }
        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int posision, Object object) {
        container.invalidate();
    }

}

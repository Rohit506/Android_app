package com.rohit.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class SliderImage extends AppCompatActivity {
    ImageSlider slider;
    ArrayList<SlideModel> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_image);
        slider= findViewById(R.id.image_slider);
        list.add(new SlideModel(R.drawable.lotus,"Lotus"));
        list.add(new SlideModel("https://i.pinimg.com/474x/11/df/b1/11dfb16b885a5ac4c3babae6956730dd.jpg", "Beautiful Girl"));
        list.add(new SlideModel(R.drawable.quote,"Quote"));
        list.add(new SlideModel(R.drawable.sunset,"Sunset"));
        list.add(new SlideModel(R.drawable.tiger,"Tiger"));
        slider.setImageList(list);
    }
}

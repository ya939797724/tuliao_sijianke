package com.example.gdmap;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.amap.api.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import basemap.BaseMapActivity;

public class MainActivity extends BaseMapActivity {
    private RelativeLayout linear;
    protected List<LatLng> latLngs = new ArrayList<>();
    @Override
    protected int bandLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linear = findViewById(R.id.linear);
        addMap(linear,savedInstanceState);
    }
}
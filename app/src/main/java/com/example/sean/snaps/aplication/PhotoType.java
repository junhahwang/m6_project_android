package com.example.sean.snaps.aplication;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sean.snaps.R;

public class PhotoType extends AppCompatActivity {

    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_type);
    }
    public void onButtonClickedcouplesnap(View v){
        Intent intent = new Intent(getApplicationContext(), PhotographerList.class);
        type = "couple";
        intent.putExtra("type", type);
        startActivity(intent);
        finish();
    }
    public void onButtonClickedfirstbirthsnap(View v){
        Intent intent = new Intent(getApplicationContext(), PhotographerList.class);
        type = "firstbirth";
        intent.putExtra("type", type);
        startActivity(intent);
        finish();
    }
    public void onButtonClickedhwangabsnap(View v){
        Intent intent = new Intent(getApplicationContext(), PhotographerList.class);
        type = "sitybirth";
        intent.putExtra("type", type);
        startActivity(intent);
        finish();
    }
    public void onButtonClickedweddingsnap(View v){
        Intent intent = new Intent(getApplicationContext(), PhotographerList.class);
        type = "wedding";
        intent.putExtra("type", type);
        startActivity(intent);
        finish();
    }
}

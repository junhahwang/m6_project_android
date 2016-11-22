package org.androidtown.snaps1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PhotoType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_type);
    }
    public void onButtonClickedcouplesnap(View v){
        Intent intent = new Intent(getApplicationContext(), PhotographerList.class);
        startActivity(intent);
        finish();
    }
    public void onButtonClickedfirstbirthsnap(View v){
        Intent intent = new Intent(getApplicationContext(), PhotographerList.class);
        startActivity(intent);
        finish();
    }
    public void onButtonClickedhwangabsnap(View v){
        Intent intent = new Intent(getApplicationContext(), PhotographerList.class);
        startActivity(intent);
        finish();
    }
    public void onButtonClickedweddingsnap(View v){
        Intent intent = new Intent(getApplicationContext(), PhotographerList.class);
        startActivity(intent);
        finish();
    }
}

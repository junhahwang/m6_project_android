package org.androidtown.snaps1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClickedLogin(View v){
        Intent intent = new Intent(getApplicationContext(), PhotoType.class);
        startActivity(intent);
        finish();
    }
    public void onButtonClickedJoin(View v){
        Intent intent = new Intent(getApplicationContext(), JoinSystem.class);
        startActivity(intent);
        finish();
    }

}
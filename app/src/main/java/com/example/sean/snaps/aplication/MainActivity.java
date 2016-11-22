package com.example.sean.snaps.aplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sean.snaps.R;
import com.example.sean.snaps.client.*;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText idInput;
    private EditText passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idInput = (EditText)findViewById(R.id.idInput);
        passwordInput = (EditText)findViewById(R.id.passwordInput);

    }



    public void onButtonClickedLogin(View v)  {
        String host = "192.168.0.2";
        String port = "5555";

        ClientConnectors cc = new ClientConnectors(host, port);
        cc.sendMessage("push");



        String id = idInput.getText().toString();
        String pw = passwordInput.getText().toString();

        Intent intent = new Intent(getApplicationContext(), PhotoType.class);

        intent.putExtra("id",id);
        intent.putExtra("pw",pw);
//boolean 사용하여 넘어가는지 아닌지 확인
        Toast.makeText(getApplicationContext(),intent.getStringExtra("id") + "로그인 되었습니다", Toast.LENGTH_SHORT).show();

        startActivity(intent);
        finish();
    }



    public void onButtonClickedJoin(View v) {
        Intent intent = new Intent(getApplicationContext(), JoinSystem.class);
        startActivity(intent);
        finish();
    }

}

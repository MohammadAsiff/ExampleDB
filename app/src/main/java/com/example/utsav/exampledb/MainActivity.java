package com.example.utsav.exampledb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button button,button1;
    public static final String FIRST_NAME="First";
    public static final  String LAST_NAME="Last";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        button=findViewById(R.id.b);
        button1=findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid=true;
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString().trim();
                if (s1.isEmpty()){
                    isValid=false;
                    e1.setError( "Enter First Name" );
                }
                if(s2.isEmpty()){
                    isValid=false;
                    e2.setError( "Enter Last Name" );
                }

                if(isValid){
                    SharedPreferences preferences=getSharedPreferences( "prefs",MODE_PRIVATE );
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString(FIRST_NAME,s1 );
                    editor.putString( LAST_NAME,s2 );
                    editor.apply();
                    ExampleDB db=new ExampleDB( MainActivity.this );
                    db.insert(s1,s2);
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }
}

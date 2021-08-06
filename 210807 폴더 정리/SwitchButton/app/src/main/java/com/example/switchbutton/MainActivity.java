package com.example.switchbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import static com.example.switchbutton.R.id.putswitch;

public class MainActivity extends AppCompatActivity {

//switch button sharedpreference 적용 완료
    private Switch aSwithch;
    private SharedPreferences sharedPreferences;
    public static final String ex = "Switch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwithch = (Switch) findViewById(putswitch);
        sharedPreferences = getSharedPreferences("", 0);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        aSwithch.setChecked(sharedPreferences.getBoolean(ex, false));
        aSwithch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putBoolean(ex, true);
                } else {
                    editor.putBoolean(ex, false);
                }
                editor.commit() ;
            }
        });
    }

}
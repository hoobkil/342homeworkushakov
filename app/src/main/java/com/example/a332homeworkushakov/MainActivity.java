package com.example.a332homeworkushakov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private Spinner languageSpinner;
    private Spinner colorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        init();
        initSpinner();

    }

    public void init(){
        languageSpinner = findViewById(R.id.languageSpinner);
        colorSpinner = findViewById(R.id.colorSpinner);
        button  = findViewById(R.id.okBtnLanguage);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(languageSpinner.getSelectedItem().toString().contains("Русский")){
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    if(colorSpinner.getSelectedItem().toString().contains("Черный")){
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);
                    } else if (colorSpinner.getSelectedItem().toString().contains("Синий")){
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                    } else if (colorSpinner.getSelectedItem().toString().contains("Зеленый")) {
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                    }
                    recreate();
                } else if (languageSpinner.getSelectedItem().toString().contains("English")){
                    Locale locale = new Locale("en");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    if(colorSpinner.getSelectedItem().toString().contains("Черный")){
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);
                    } else if (colorSpinner.getSelectedItem().toString().contains("Синий")){
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                    } else if (colorSpinner.getSelectedItem().toString().contains("Зеленый")) {
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                    }
                    recreate();
                }
            }
        });


    }

    private void initSpinner(){
        ArrayAdapter<?> languageAdapter = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(languageAdapter);

        ArrayAdapter<?> colorAdapter = ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        colorSpinner.setAdapter(colorAdapter);


    }


}

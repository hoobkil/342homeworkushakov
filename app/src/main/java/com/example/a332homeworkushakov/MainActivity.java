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
    private Spinner sizeSpinner;

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
        sizeSpinner = findViewById(R.id.sizeSpinner);
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
                    if(sizeSpinner.getSelectedItem().toString().contains("Мелкие")){
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_SMALL);
                    } else if (sizeSpinner.getSelectedItem().toString().contains("Средние")){
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MEDIUM);
                    } else if (sizeSpinner.getSelectedItem().toString().contains("Большие")){
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_LARGE);
                    }
                    recreate();
                } else if (languageSpinner.getSelectedItem().toString().contains("English")){
                    Locale locale = new Locale("en");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    if(sizeSpinner.getSelectedItem().toString().contains("Мелкие")){
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_SMALL);
                    } else if (sizeSpinner.getSelectedItem().toString().contains("Средние")){
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MEDIUM);
                    } else if (sizeSpinner.getSelectedItem().toString().contains("Большие")){
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_LARGE);
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

        ArrayAdapter<?> sizeAdapter = ArrayAdapter.createFromResource(this, R.array.size, android.R.layout.simple_spinner_item);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(sizeAdapter);
    }


}

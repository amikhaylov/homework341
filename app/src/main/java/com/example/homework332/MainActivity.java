package com.example.homework332;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        final Spinner languages = findViewById(R.id.languages);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languages.setAdapter(adapter);

        final Spinner colors = findViewById(R.id.colors);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colors.setAdapter(adapter);

        final Button apply = findViewById(R.id.apply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (colors.getSelectedItem().toString().equals(getResources().getString(R.string.green))) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                }
                if (colors.getSelectedItem().toString().equals(getResources().getString(R.string.blue))) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                }
                if (colors.getSelectedItem().toString().equals(getResources().getString(R.string.black))) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                }
                if (languages.getSelectedItem().toString().equals(getResources().getString(R.string.english))) {
                    Locale locale = new Locale("en");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                } else if (languages.getSelectedItem().toString().equals(getResources().getString(R.string.russian))) {
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }
            }
        });
    }
}

package com.twitter.challenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.twitter.challenge.util.TemperatureConverter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView temperatureView = (TextView) findViewById(R.id.temperature);
        temperatureView.setText(getString(R.string.temperature, 34f, TemperatureConverter.celsiusToFahrenheit(34)));
    }

    //todo First load current Weather
    //todo fetch data and display in Fragment_Current


}

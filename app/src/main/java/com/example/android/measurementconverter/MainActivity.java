package com.example.android.measurementconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String spinnerSelection;
    String sourceUnit;
    String targetUnit;
    Scanner scanner;
    TextView sourceUnitLabel;
    TextView targetUnitLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up spinner
        Spinner selectConversion = findViewById(R.id.selectConversion);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversions_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectConversion.setAdapter(adapter);
        selectConversion.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        spinnerSelection = parent.getItemAtPosition(pos).toString();
        scanner = new Scanner(spinnerSelection);
                
        sourceUnit = scanner.next();
        scanner.next();
        targetUnit = scanner.next();
        
        sourceUnitLabel = findViewById(R.id.SourceUnitLabel);
        sourceUnitLabel.setText(sourceUnit);
        targetUnitLabel = findViewById(R.id.TargetUnitLabel);
        targetUnitLabel.setText(targetUnit);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        sourceUnitLabel.setText(R.string.miles);
        targetUnitLabel.setText(R.string.kilometers);
    }
}

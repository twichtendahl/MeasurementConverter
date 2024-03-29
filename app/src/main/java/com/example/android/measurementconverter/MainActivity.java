package com.example.android.measurementconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
    EditText inputQuantity;
    TextView displayConversion;

    double toConvert;
    double converted;

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

        displayConversion = findViewById(R.id.displayConversion);
        inputQuantity = findViewById(R.id.inputQuantity);
        sourceUnitLabel = findViewById(R.id.SourceUnitLabel);
        targetUnitLabel = findViewById(R.id.TargetUnitLabel);

        inputQuantity.setText("0.0");
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        spinnerSelection = parent.getItemAtPosition(pos).toString();
        scanner = new Scanner(spinnerSelection);
                
        sourceUnit = scanner.next();
        scanner.next();
        targetUnit = scanner.next();

        sourceUnitLabel.setText(sourceUnit);
        targetUnitLabel.setText(targetUnit);

        toConvert = Double.parseDouble(inputQuantity.getText().toString());
        switch(sourceUnit) {
            case "Miles":
                converted = ConversionFunction.milesToKilometers(toConvert);
                break;
            case "Kilometers":
                converted = ConversionFunction.kilometersToMiles(toConvert);
                break;
            case "Inches":
                converted = ConversionFunction.inchesToCentimeters(toConvert);
                break;
            case "Centimeters":
                converted = ConversionFunction.centimetersToInches(toConvert);
                break;
            default:
                converted = ConversionFunction.milesToKilometers(toConvert);
        }
        displayConversion.setText(Double.toString(converted));
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

}

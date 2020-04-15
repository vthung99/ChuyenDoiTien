package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinerCurrency1, spinnerCurrency2;
    ArrayAdapter<String> currencyAdapter1, curencyAdapter2;
    Float input1, input2;
    EditText editInput1;
    TextView outPut;
    static final float VN_EURO = 25778.1439f;
    static final float VN_DOLLAR = 23471.0f;
    static final float VN_WON = 19.4f;
    static final float VN_YUAN = 3.331f;
    static final float EURO_DOLLAR = 25778.1439f;
    static final float EURO_WON = 25778.1439f;
    static final float EURO_YUAN = 25778.1439f;
    static final float DOLLAR_WON = 25778.1439f;
    static final float DOLLAR_YUAN = 25778.1439f;
    int selected1 = 0, selected2 = 0;
    int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        editInput1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s!=null||s.length()>0) {
                    input1 = Float.parseFloat(String.valueOf(editInput1.getText()));
                    input2 = event(input1, selected1, selected2);
                    outPut.setText(input2.toString());
                } else outPut.setText("");
            }
        });
        spinerCurrency1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected1=position;
                if(input1!=null){
                input2 = event(input1, selected1, selected2);
                outPut.setText(input2.toString());}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerCurrency2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected2=position;
                if(input1!=null){
                input2 = event(input1, selected1, selected2);
                outPut.setText(input2.toString());}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private float event(float input1, int selected1, int selected2) {
        float input2 = 0;
        if (selected1 == selected2)
            return input1;
        if (selected1 == 0 && selected2 == 1)
            return input1 / VN_EURO;
        if (selected1 == 1 && selected2 == 0)
            return input1 * VN_EURO;
        if (selected1 == 0 && selected2 == 2)
            return input1 / VN_DOLLAR;
        if(selected1==2&&selected2==0)
            return input1*VN_DOLLAR;
        if(selected1==0&& selected2==3)
            return input1/VN_WON;
        if(selected1==3&& selected2==0)
            return input1*VN_WON;
        if(selected1==0&& selected2==4)
            return input1/VN_YUAN;
        if(selected1==4&& selected2==0)
            return input1*VN_YUAN;

        else return input1;

    }


    private void addControls() {
        spinerCurrency1 = findViewById(R.id.spinner1);
        spinnerCurrency2 = findViewById(R.id.spinner2);
        editInput1 = findViewById(R.id.editText1);
        outPut = findViewById(R.id.editText2);
        currencyAdapter1 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        currencyAdapter1.add("Vietname- Dong");
        currencyAdapter1.add("Europ- Euro");
        currencyAdapter1.add("UnitedState- Dollar");
        currencyAdapter1.add("Korea- Won");
        currencyAdapter1.add("China- Yuan");
        currencyAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinerCurrency1.setAdapter(currencyAdapter1);
        curencyAdapter2 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        curencyAdapter2.add("Vietname- Dong");
        curencyAdapter2.add("Europ- Euro");
        curencyAdapter2.add("UnitedState- Dollar");
        curencyAdapter2.add("Korea- Won");
        curencyAdapter2.add("China- Yuan");
        curencyAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrency2.setAdapter(curencyAdapter2);

    }


}

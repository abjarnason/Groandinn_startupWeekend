package com.example.Groandinn;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class groandinn_main extends Activity {

    public final static String PLANT_VALUE = "";
    Button btnPlant, btnArea, btnDarlings;
    Spinner spiPlant, spiArea;
    TextView texTest;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.gardener_silver);

        addItemsOnSpinnerPlant();
        addItemsOnSpinnerArea();
        addListenerOnClick();
    }

    public void addItemsOnSpinnerPlant(){
        spiPlant= (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Choose a plant");
        list.add("Potato (Solanum tuberosum)");
        list.add("Cauliflower (Brassica oleracea)");
        list.add("Maize (Zea mays)");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiPlant.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinnerArea(){
        spiArea = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Choose your area");
        list.add("Reykjavík");
        list.add("Þykkvibær");
        list.add("Grímstaðir á Fjöllum");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiArea.setAdapter(dataAdapter);
    }

    public void addListenerOnClick(){

        btnPlant = (Button) findViewById(R.id.button);
        btnArea = (Button) findViewById(R.id.button1);
        btnDarlings = (Button) findViewById(R.id.button2);

        btnPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spiPlant.performClick();
            }
        });

        btnArea.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                spiArea.performClick();
            }
        });

        btnDarlings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String test = groandinn_get.getInfo("1");
                //TextView text = (TextView) findViewById(R.id.textView1);

                String plantValue = String.valueOf(spiPlant.getSelectedItem());
                String areaValue = String.valueOf(spiArea.getSelectedItem());
                String areaTemperature;

                if(areaValue.equals("Reykjavík")){
                    areaTemperature = groandinn_get.getInfo("1");
                }
                else if(areaValue.equals("Þykkvibær")){
                    areaTemperature = groandinn_get.getInfo("6208");
                }
                else if(areaValue.equals("Grímstaðir á Fjöllum")){
                    areaTemperature = groandinn_get.getInfo("4323");
                }
                else areaTemperature = "Choose your area";

                Intent intent = new Intent(groandinn_main.this, groandinn_info.class);
                intent.putExtra("plant",plantValue);
                intent.putExtra("areaTemp",areaTemperature);
                intent.putExtra("area",areaValue);
                startActivity(intent);



                /*
                Intent intent = new Intent(groandinn_main.this,groandinn_info.class);



                intent.putExtra("spiPlant",plantValue);
                intent.putExtra("spiArea",areaValue);

                groandinn_main.this.startActivity(intent);
                */
            }
        });


    }




}

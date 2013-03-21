package com.example.Groandinn;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: asgeir
 * Date: 3/17/13
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class groandinn_info extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        String getPlantName = getIntent().getExtras().getString("plant");
        String getAreaValue = getIntent().getExtras().getString("area");
        String getAreaTemp = getIntent().getExtras().getString("areaTemp");

        TextView text = (TextView) findViewById(R.id.textView);
        TextView text1 = (TextView) findViewById(R.id.textView1);
        TextView text2 = (TextView) findViewById(R.id.textView2);
        //text.setBackgroundColor(Color.GREEN);

        text.setText("The temperature at " + getAreaValue + " is " + getAreaTemp + "°C");

        double areaTempDouble = Double.parseDouble(getAreaTemp);

        if(getPlantName.equals("Potato (Solanum tuberosum)")){
            if(areaTempDouble > 2){
                text1.setText("I‘m doing fine, there is even an Icelandic congress man singing about me...");
            }
            else if(areaTempDouble <= 2 &&  areaTempDouble > -5){
                text1.setText("Help me now I‘m very fragile to frost damage and my leafs will shut down soon.");
                text2.setText("Advise: Spray water in a fine mist to make a protective layer and freeze instead of the plant cells.");
            }
            else if(areaTempDouble <= -5){
                text1.setText("My leafs are dying and most probably dead, You have failed me o mighty god.");
            }
            else text1.setText("Do something...");
        }

        else if(getPlantName.equals("Cauliflower (Brassica oleracea)")){
            if(areaTempDouble > 4){
                text1.setText("Aaahh I‘m pretty hardy, I‘m doing fine now.");
            }
            else if(areaTempDouble <= 4 && areaTempDouble > 0){
                text1.setText("My cells are not working properly. Will you help me?");
                text2.setText("Advise: Water the earth, increasing humidity and protecting roots.");
            }
            else if(areaTempDouble <= 0){
                text1.setText("Cellular destruction, I'm dying...");
                text2.setText("CPR: Spray water over the plants until frozen, the plant will be damaged but there is hope.");
            }
            else text1.setText("Do something...");
        }
        else if(getPlantName.equals("Maize (Zea mays)")){
            if(areaTempDouble > 8){
                text1.setText("I‘m a warm climate plant, I‘m doing good now.");
            }
            else if(areaTempDouble <= 8 && areaTempDouble > 2){
                text1.setText("My cells are not working properly. Will you help me?");
                text2.setText("Advise: Water the earth, increasing humidity and protecting roots.");
            }
            else if(areaTempDouble <= 2){
                text1.setText("My cells are breaking down, change the temperature. Master, I'm dying.");
            }
        }
        else text1.setText("Do something...");




        //if(areaTempdouble < 0) text1.setText("Það er frost!");

        //text1.setText(Double.toString(areaTempdouble));
        //else text1.setText("ekki alveg viss...");

        //if(areaTempInt > 5) text1.setText("mjöög heitt...");
        //else if(areaTempInt < 5) text1.setText("frekar kalt...");



        /*
        TextView text2 = (TextView) findViewById(R.id.textView2);

        text1.setText(getPlantValue);
        text2.setText(getAreaValue);
        */
    }
}

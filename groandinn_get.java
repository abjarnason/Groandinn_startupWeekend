package com.example.Groandinn;

import android.app.Activity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created with IntelliJ IDEA.
 * User: asgeir
 * Date: 3/16/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class groandinn_get extends Activity {

    public static String getInfo(String ids){
        String vedurUrl = "http://xmlweather.vedur.is/?op_w=xml&type=obs&lang=en&view=xml&ids=";
        String vedurUrlWithIds = vedurUrl + ids;

        Pattern pattern = Pattern.compile("<T>(.*?)</T>");

        try
        {

            URL url = new URL(vedurUrlWithIds);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    return matcher.group(1);
                }
            }
            return "IO Error2";

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return "IO Error2";
        }
    }
}

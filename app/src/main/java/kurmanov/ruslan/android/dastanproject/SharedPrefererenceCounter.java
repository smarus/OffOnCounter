package kurmanov.ruslan.android.dastanproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;

/**
 * Created by ruslan on 10/19/17.
 */

public class SharedPrefererenceCounter {

    SharedPreferences sharedPreferences;

    public static SharedPrefererenceCounter instance;


    private SharedPrefererenceCounter(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPrefererenceCounter getInstance (Context context){
        if (instance == null)
            instance = new SharedPrefererenceCounter(context);
        return instance;
    }

    public void setSharedPreferences(int counter){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("value",String.valueOf(counter));
        editor.apply();
    }

    public String getSharedPreferences() {
        return sharedPreferences.getString("value","0");
    }

    public void setOffCounter(int offCounter){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("value_of",String.valueOf(offCounter));
        editor.apply();
    }

    public void setOnCounter(int onCounter){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("value_on",String.valueOf(onCounter));
        editor.apply();
    }

    public String getOffCounter(){
        return sharedPreferences.getString("value_of","0");
    }

    public String getOnCounter(){
        return sharedPreferences.getString("value_on","0");
    }

    public void delete(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().apply();
    }
}

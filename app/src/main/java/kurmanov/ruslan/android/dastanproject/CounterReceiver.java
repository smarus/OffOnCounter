package kurmanov.ruslan.android.dastanproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ruslan on 10/19/17.
 */

public class CounterReceiver extends BroadcastReceiver {

    public static int  counter = 0;
    public static int  counterOff = 0;
    public static int  counterOn = 0;
    SharedPrefererenceCounter sharedPrefererenceCounter;

    @Override
    public void onReceive(Context context, Intent intent) {


        sharedPrefererenceCounter = SharedPrefererenceCounter.getInstance(context);
        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            sharedPrefererenceCounter.setOnCounter(counterOn++);
            sharedPrefererenceCounter.setSharedPreferences(counter++);
        }
        else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            sharedPrefererenceCounter.setOffCounter(counterOff++);
            sharedPrefererenceCounter.setSharedPreferences(counter++);
            Log.e("TAG",counter+" ");
        }

    }
}

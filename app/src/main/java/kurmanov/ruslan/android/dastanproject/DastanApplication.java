package kurmanov.ruslan.android.dastanproject;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ruslan on 10/20/17.
 */

public class DastanApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if(!isServiceRunning(LockService.class)) {
            startService(new Intent(this, LockService.class));
            Log.e("TAG","TSG");
        }
    }

    private boolean isServiceRunning(Class<?> serviceClass){
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        for(ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}

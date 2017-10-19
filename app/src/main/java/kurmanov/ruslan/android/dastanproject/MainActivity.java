package kurmanov.ruslan.android.dastanproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements SharedPreferences.OnSharedPreferenceChangeListener {

    TextView textCounter,textOnCounter,textOffCounter;
    SharedPrefererenceCounter counter;
    SharedPreferences sharedPreferences;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       startService(new Intent(this,LockService.class));
        counter = SharedPrefererenceCounter.getInstance(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        textCounter =(TextView)findViewById(R.id.cout_textview);
        textOffCounter = (TextView)findViewById(R.id.text_off_counter);
        textOnCounter = (TextView)findViewById(R.id.text_on_counter);
        button = (Button)findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.delete();
            }
        });
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Log.e("TAG","onSharedPrefereneChanged");
        if (s.equals("value")){
            textCounter.setText(counter.getSharedPreferences());
        }
        else if (s.equals("value_of")){
            textOffCounter.setText(counter.getOffCounter());
        }
        else if (s.equals("value_on")){
            textOnCounter.setText(counter.getOnCounter());
        }
    }
}

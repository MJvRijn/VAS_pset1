package nl.mjvrijn.matthewvanrijn_pset1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.HashMap;
import java.util.Map;

public class PotatoActivity extends AppCompatActivity {

    SharedPreferences preferences;
    Map<View, View> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potato);

        map.put(findViewById(R.id.checkbox_arms), findViewById(R.id.potato_arms));
        map.put(findViewById(R.id.checkbox_ears), findViewById(R.id.potato_ears));
        map.put(findViewById(R.id.checkbox_eyebrows), findViewById(R.id.potato_eyebrows));
        map.put(findViewById(R.id.checkbox_eyes), findViewById(R.id.potato_eyes));
        map.put(findViewById(R.id.checkbox_glasses), findViewById(R.id.potato_glasses));
        map.put(findViewById(R.id.checkbox_hat), findViewById(R.id.potato_hat));
        map.put(findViewById(R.id.checkbox_mouth), findViewById(R.id.potato_mouth));
        map.put(findViewById(R.id.checkbox_mustache), findViewById(R.id.potato_mustache));
        map.put(findViewById(R.id.checkbox_nose), findViewById(R.id.potato_nose));
        map.put(findViewById(R.id.checkbox_shoes), findViewById(R.id.potato_shoes));

        preferences = getSharedPreferences("PotatoState", Context.MODE_PRIVATE);

        for(Map.Entry<View,View> pair : map.entrySet()) {
            CheckBox checkbox = (CheckBox) pair.getKey();
            View bodypart = pair.getValue();

            boolean visible = preferences.getBoolean((String) checkbox.getText(), false);

            if(visible) {
                bodypart.setVisibility(View.VISIBLE);
                checkbox.setChecked(true);
            } else {
                checkbox.setChecked(false);
            }
        }
    }

    public void toggleImage(View view) {
        String name = (String) ((CheckBox) view).getText();
        View bodypart = map.get(view);

        SharedPreferences.Editor editor = preferences.edit();

        boolean visible = preferences.getBoolean(name, false);

        if(visible) {
            bodypart.setVisibility(View.INVISIBLE);
            editor.putBoolean(name, false);
        } else {
            bodypart.setVisibility(View.VISIBLE);
            editor.putBoolean(name, true);
        }

        editor.apply();

    }
}

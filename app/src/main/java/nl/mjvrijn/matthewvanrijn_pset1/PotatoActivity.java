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

    /* Set the checkboxes and images to their correct states when the app is opened or the phone is
     * rotated. This uses Android's SharedPreferences, as described in part 17 of Derek Banas'
     * Youtube tutorial series linked on the course website (https://www.youtube.com/watch?v=1DOeLy26hOE).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potato);

        /* The relationship between the checkboxes and the images are mapped in a map. Here
         * this map is initialised.
         */
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

        /* Whether a body part should be visible is stored as a shared preference. When the app is
         * opened/rotated it is necessary to iterate through all these preferences to set the images
         * and checkboxes to the correct state. Since we have a map containing all these pairs we
         * iterate through all entries in the map and read the preference for that body part.
         */
        preferences = getSharedPreferences("PotatoState", Context.MODE_PRIVATE);

        for(Map.Entry<View,View> pair : map.entrySet()) {
            CheckBox checkbox = (CheckBox) pair.getKey();
            View bodypart = pair.getValue();
            String name = (String) checkbox.getText(); // Preference key is the body part's name.

            boolean visible = preferences.getBoolean(name, false);

            if(visible) {
                bodypart.setVisibility(View.VISIBLE);
                checkbox.setChecked(true);
            } else {
                checkbox.setChecked(false);
            }
        }
    }

    /* Toggle the visibility of a given body part and update the value of the preference. */
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

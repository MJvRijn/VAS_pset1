package nl.mjvrijn.matthewvanrijn_pset1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PotatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potato);

    }

    public void toggleImage(View view) {
        switch(view.getId()) {
            case R.id.checkbox_arms:
                toggleVisibility(findViewById(R.id.potato_arms));
                break;
            case R.id.checkbox_ears:
                toggleVisibility(findViewById(R.id.potato_ears));
                break;
            case R.id.checkbox_eyebrows:
                toggleVisibility(findViewById(R.id.potato_eyebrows));
                break;
            case R.id.checkbox_eyes:
                toggleVisibility(findViewById(R.id.potato_eyes));
                break;
            case R.id.checkbox_glasses:
                toggleVisibility(findViewById(R.id.potato_glasses));
                break;
            case R.id.checkbox_hat:
                toggleVisibility(findViewById(R.id.potato_hat));
                break;
            case R.id.checkbox_mouth:
                toggleVisibility(findViewById(R.id.potato_mouth));
                break;
            case R.id.checkbox_mustache:
                toggleVisibility(findViewById(R.id.potato_mustache));
                break;
            case R.id.checkbox_nose:
                toggleVisibility(findViewById(R.id.potato_nose));
                break;
            case R.id.checkbox_shoes:
                toggleVisibility(findViewById(R.id.potato_shoes));
                break;
        }
    }

    private void toggleVisibility(View view) {
        if(view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.INVISIBLE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }
}

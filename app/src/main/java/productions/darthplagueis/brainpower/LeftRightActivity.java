package productions.darthplagueis.brainpower;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Map;

public class LeftRightActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private Button headLeftButton, headRightButton, crossLeftButton, crossRightButton,
            legsLeftButton, legsRightButton;
    private Context context;
    private TinyDB tinyDB;
    private String left = "left";
    private String right = "right";
    private static final String TAG = "FriendshipActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_right);

        variableSetUp();
        setButtons();
    }

    private void variableSetUp() {
        headLeftButton = (Button) findViewById(R.id.head_left_button);
        headRightButton = (Button) findViewById(R.id.head_right_button);
        crossLeftButton = (Button) findViewById(R.id.cross_left_button);
        crossRightButton = (Button) findViewById(R.id.cross_right_button);
        legsLeftButton = (Button) findViewById(R.id.legs_left_button);
        legsRightButton = (Button) findViewById(R.id.legs_right_button);

        context = getApplicationContext();
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        tinyDB = new TinyDB(context);
    }

    private void setButtons() {
        final TinyDB tinyDB = new TinyDB(context);
        headLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("headLeft", right);

            }
        });
        headRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("headRight", left);

            }
        });
        crossLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("crossLeft", right);

            }
        });
        crossRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("crossRight", left);
            }
        });
        legsLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("legsLeft", right);
                unlimitedPower();
                displayResults();
            }
        });
        legsRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("legsRight", left);
                unlimitedPower();
                displayResults();
            }
        });
    }

    private boolean unlimitedPower() {
        ArrayList<String> leftList = new ArrayList<>();
        ArrayList<String> rightList = new ArrayList<>();
        String hemisphere;

        Map<String, ?> keys = preferences.getAll();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            hemisphere = tinyDB.getString(entry.getKey());
            Log.d(TAG, entry.getKey() + ": " + entry.getValue().toString());
            if (hemisphere.equalsIgnoreCase(left)) {
                leftList.add(hemisphere);
            } else {
                rightList.add(hemisphere);
            }
        }
        if (leftList.size() > rightList.size()) {
            return true;
        }
        return false;
    }

    private void displayResults() {
        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
        if (unlimitedPower()) {
            tinyDB.putString("leftRightHemisphere", left);
            startActivity(intent);
        } else {
            tinyDB.putString("leftRightHemisphere", right);
            startActivity(intent);
        }
    }
}

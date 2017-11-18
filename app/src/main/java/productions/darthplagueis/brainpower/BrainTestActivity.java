package productions.darthplagueis.brainpower;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import productions.darthplagueis.brainpower.controller.BrainTestAdapter;
import productions.darthplagueis.brainpower.model.BrainTest;

public class BrainTestActivity extends AppCompatActivity {

    private RecyclerView brainTestView;
    private SharedPreferences preferences;
    private List<BrainTest> brainTestList;
    private Context context;
    private TinyDB tinyDB;
    private Button selectedButton;
    private static final String TAG = "BrainTest";
    private String left = "left";
    private String right = "right";
    private String checked = "checked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_test);

        setBrainTestView();
        setTinyDB();
        setSelectedButton();
    }

    private void setBrainTestView() {
        brainTestView = (RecyclerView) findViewById(R.id.braintest_recyclerview);

        brainTestList = new ArrayList<>();

        brainTestList.add(new BrainTest(R.string.question01));
        brainTestList.add(new BrainTest(R.string.question02));
        brainTestList.add(new BrainTest(R.string.question03));
        brainTestList.add(new BrainTest(R.string.question04));
        brainTestList.add(new BrainTest(R.string.question05));
        brainTestList.add(new BrainTest(R.string.question06));
        brainTestList.add(new BrainTest(R.string.question07));
        brainTestList.add(new BrainTest(R.string.question08));
        brainTestList.add(new BrainTest(R.string.question09));
        brainTestList.add(new BrainTest(R.string.question10));
        brainTestList.add(new BrainTest(R.string.question11));
        brainTestList.add(new BrainTest(R.string.question12));
        brainTestList.add(new BrainTest(R.string.question13));
        brainTestList.add(new BrainTest(R.string.question14));
        brainTestList.add(new BrainTest(R.string.question15));
        brainTestList.add(new BrainTest(R.string.question16));
        brainTestList.add(new BrainTest(R.string.question17));
        brainTestList.add(new BrainTest(R.string.question18));

        BrainTestAdapter brainTestAdapter = new BrainTestAdapter(brainTestList);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        brainTestView.setHasFixedSize(true);
        brainTestView.setAdapter(brainTestAdapter);
        brainTestView.setLayoutManager(manager);

        selectedButton = (Button) findViewById(R.id.braintest_selected);
    }

    private void setTinyDB() {
        context = getApplicationContext();
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        tinyDB = new TinyDB(context);
    }

    private void setSelectedButton() {
        selectedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "";
                int counter = 0;
                for (BrainTest brainTest : brainTestList) {
                    if (brainTest.isSelected()) {
                        text += brainTest.getQuestion() + " ";
                        counter++;
                        String key = String.valueOf(counter);
                        tinyDB.putString(key, checked);
                    }
                }
                unlimitedPower03();
                Log.d(TAG,"Output : " + text);
                displayResults();
            }
        });
    }

    private boolean unlimitedPower() {
        ArrayList<String> leftList = new ArrayList<>();
        ArrayList<String> rightList = new ArrayList<>();
        String hemisphere;

        Map<String, ?> keys = preferences.getAll();
        Log.d(TAG, "unlimitedPower: num keys" +keys.entrySet().size());

        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            hemisphere = tinyDB.getString(entry.getKey());
            Log.d(TAG, entry.getKey() + ": " + entry.getValue().toString());
            if (hemisphere.equalsIgnoreCase(checked)) {
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

    private boolean unlimitedPower02() {
        int listSize = tinyDB.getListString(checked).size();
        String sizeCheck = String.valueOf(listSize);
        Log.d(TAG, sizeCheck);
        if (listSize >= 9) {
            return true;
        }
        return false;
    }

    private boolean unlimitedPower03() {
        ArrayList<String> testChoices = new ArrayList<>();
        String choices;

        Map<String, ?> keys = preferences.getAll();
        Log.d(TAG, "unlimitedPower: num keys " +keys.entrySet().size());

        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            choices = tinyDB.getString(entry.getKey());
            Log.d(TAG, entry.getKey() + ": " + entry.getValue().toString());
            testChoices.add(choices);
        }
        int listSize = testChoices.size();
        String listCheck = String.valueOf(listSize);
        Log.d(TAG, "listCheck: " + listCheck);

        if (listSize >= 9) {
            return true;
        }
        return false;
    }

    private void displayResults() {
        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
        if (unlimitedPower03()) {
            tinyDB.putString("leftRightHemisphere", left);
            startActivity(intent);
        } else {
            tinyDB.putString("leftRightHemisphere", right);
            startActivity(intent);
        }
    }
}

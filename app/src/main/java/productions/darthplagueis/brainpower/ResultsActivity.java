package productions.darthplagueis.brainpower;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private Context context;
    private TinyDB tinyDB;
    private TextView resultsView;
    private ImageView resultsImage;
    private Button resultsButton;
    private Button resultsHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        variableSetUp();
        setView();
        setResultsButton();
    }

    private void variableSetUp() {
        resultsView = (TextView) findViewById(R.id.results_textview);
        resultsImage = (ImageView) findViewById(R.id.results_imageview);
        resultsButton = (Button) findViewById(R.id.results_button);
        resultsHomeButton = (Button) findViewById(R.id.go_home_button);

        context = getApplicationContext();
        tinyDB = new TinyDB(context);
    }

    private void setView() {
        String dataString = tinyDB.getString("leftRightHemisphere");
        if (dataString.equalsIgnoreCase("left")) {
            resultsView.setText(R.string.results_left);
            resultsImage.setImageResource(R.drawable.left_brain);
        } else {
            resultsView.setText(R.string.results_right);
            resultsImage.setImageResource(R.drawable.right_brain);
        }
    }

    private void setResultsButton() {
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.clear();
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
            }
        });
        resultsHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.clear();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}

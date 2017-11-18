package productions.darthplagueis.brainpower;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ThreeShapeActivity extends AppCompatActivity {

    private ImageButton circleButton, abstractButton, doodleButton;
    private Context context;
    private TinyDB tinyDB;
    private String left = "left";
    private String right = "right";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_shape);

        variableSetUp();
        setButtons();
    }

    private void variableSetUp() {
        circleButton = (ImageButton) findViewById(R.id.circle_button);
        abstractButton = (ImageButton) findViewById(R.id.abstract_button);
        doodleButton = (ImageButton) findViewById(R.id.doodle_button);
        context = getApplicationContext();
    }

    private void setButtons() {
        tinyDB = new TinyDB(context);
        final Intent intent = new Intent(getApplicationContext(), SquareCircleActivity.class);
        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("circle", left);
                startActivity(intent);
            }
        });
        abstractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("abstract", left);
                tinyDB.putString("abstract02", right);
                startActivity(intent);
            }
        });
        doodleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("doodle", right);
                startActivity(intent);
            }
        });
    }
}

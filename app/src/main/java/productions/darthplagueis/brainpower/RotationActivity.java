package productions.darthplagueis.brainpower;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RotationActivity extends AppCompatActivity {

    private ImageButton counterButton, clockwiseButton;
    private Context context;
    private TinyDB tinyDB;
    private String left = "left";
    private String right = "right";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);

        variableSetUp();
        setButtons();
    }

    private void variableSetUp() {
        counterButton = (ImageButton) findViewById(R.id.counter_button);
        clockwiseButton = (ImageButton) findViewById(R.id.clockwise_button);
        context = getApplicationContext();
    }

    private void setButtons() {
        tinyDB = new TinyDB(context);
        final Intent intent = new Intent(getApplicationContext(), ThreeShapeActivity.class);
        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("counter", left);
                startActivity(intent);
            }
        });
        clockwiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("clockwise", right);
                startActivity(intent);
            }
        });
    }
}

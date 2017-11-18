package productions.darthplagueis.brainpower;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SquareCircleActivity extends AppCompatActivity {

    private ImageButton orangeButton, greyButton, brokenButton;
    private Context context;
    private TinyDB tinyDB;
    private String left = "left";
    private String right = "right";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_circle);

        setVariables();
        setButtons();
    }

    private void setVariables() {
        orangeButton = (ImageButton) findViewById(R.id.orange_circle_button);
        greyButton = (ImageButton) findViewById(R.id.grey_circle_button);
        brokenButton = (ImageButton) findViewById(R.id.broken_circle_button);
        context = getApplicationContext();
    }

    private void setButtons() {
        tinyDB = new TinyDB(context);
         final Intent intent = new Intent(getApplicationContext(), FriendshipActivity.class);
        orangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("orange", left);
                startActivity(intent);
            }
        });
        greyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("grey", right);
                startActivity(intent);
            }
        });
        brokenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("broken", right);
                startActivity(intent);
            }
        });
    }
}

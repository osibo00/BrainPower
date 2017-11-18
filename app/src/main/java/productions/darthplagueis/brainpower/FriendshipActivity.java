package productions.darthplagueis.brainpower;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FriendshipActivity extends AppCompatActivity {

    private ImageButton friend01Button, friend02Button, friend03Button;
    private Context context;
    private TinyDB tinyDB;
    private String left = "left";
    private String right = "right";
    private static final String TAG = "FriendshipActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendship);

        setVariables();
        setButtons();
    }

    private void setVariables() {
        friend01Button = (ImageButton) findViewById(R.id.friend01_button);
        friend02Button = (ImageButton) findViewById(R.id.friend02_button);
        friend03Button = (ImageButton) findViewById(R.id.friend03_button);

        context = getApplicationContext();
    }

    private void setButtons() {
        tinyDB = new TinyDB(context);
        final Intent intent = new Intent(getApplicationContext(), LeftRightActivity.class);
        friend01Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        friend02Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("friend02", left);
                startActivity(intent);
            }
        });
        friend03Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinyDB.putString("friend03", right);
                startActivity(intent);
            }
        });
    }
}

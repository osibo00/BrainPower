package productions.darthplagueis.brainpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button startButton01;
    private Button startButton02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        variableSetUp();
        setStartButton();
    }

    private void variableSetUp() {
        startButton01 = (Button) findViewById(R.id.start_button01);
        startButton02 = (Button) findViewById(R.id.start_button02);
    }

    private void setStartButton() {
        startButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rotAct = new Intent(getApplicationContext(), RotationActivity.class);
                startActivity(rotAct);
            }
        });
        startButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent brainAct = new Intent(getApplicationContext(), BrainTestActivity.class);
                startActivity(brainAct);
            }
        });
    }
}

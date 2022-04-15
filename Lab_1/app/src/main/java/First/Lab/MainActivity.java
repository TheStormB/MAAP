package First.Lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, MainActivity2.class);
        Button button = (Button) findViewById(R.id.first_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
    public void openMainActivity3(View view){
        final Intent intent2 = new Intent(this, MainActivity3.class);
        startActivity(intent2);
    }

    public void openMainActivity4(View view){
        final Intent intent3 = new Intent(this, MainActivity4.class);
        startActivity(intent3);
    }
}




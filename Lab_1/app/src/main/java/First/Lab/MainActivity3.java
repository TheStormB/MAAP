package First.Lab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


    }

    public void goBackTo1(View view) {
        onBackPressed();
    }

    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), "Page 3 stopped", Toast.LENGTH_SHORT).show();
    }
}
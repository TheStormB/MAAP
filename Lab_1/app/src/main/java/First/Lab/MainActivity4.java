package First.Lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        View window = (View) findViewById(R.id.imageView3);
        window.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                finish();
                return false;
            }
        });

    }

    public void goBack(View view) {
        onBackPressed();
    }



    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), "Page 4 stopped", Toast.LENGTH_SHORT).show();
    }

    // Sir i thought that on subtask 2 we suppose to do it so thats why i already
    //started i hope it will not effect my point
}
package Lab_2.pwr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SimpleList(View view) {
        Intent intent = new Intent();
        intent.setClass(this, SimpleList.class);
        startActivity(intent);

    }

    public void MultichoiceList(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MultiChoiceList.class);
        startActivity(intent);
    }

    public void Grid(View view) {
        Intent intent = new Intent();
        intent.setClass(this, Grid.class);
        intent.putExtra("ARG1", "Value1");
        intent.putExtra("ARG2", 2);
        startActivity(intent);
    }


//    @Override
//    protected  void onActivityresult(int requestCode, int resultCode, @Nullable Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(resultCode == 0){
//            Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this, data.getStringExtra("RESULT"), Toast.LENGTH_SHORT).show();
//        }
//    }

}
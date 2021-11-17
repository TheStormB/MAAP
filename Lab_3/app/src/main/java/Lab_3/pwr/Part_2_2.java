package Lab_3.pwr;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Part_2_2 extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        menu.add(0,1,Menu.NONE,"1");
        menu.add(0,2,Menu.NONE,"2");

        SubMenu subMenu = menu.addSubMenu(0, 3, Menu.NONE,"MySub");
        MenuItem check_menu = subMenu.add(0,4,0,"Border");
        check_menu.setCheckable(true);
        subMenu.add(0,5,0,"Title");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 3:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                return true;

            default:
                Toast.makeText(getApplicationContext(), item.getTitle() + " " + item.getItemId(), Toast.LENGTH_SHORT).show();
                return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_2_2);

    }
}
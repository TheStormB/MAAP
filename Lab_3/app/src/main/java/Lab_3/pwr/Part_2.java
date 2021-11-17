package Lab_3.pwr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Part_2 extends AppCompatActivity {
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
        setContentView(R.layout.activity_part2);

//        registerForContextMenu(findViewById(R.id.kungfupanda));
//        registerForContextMenu(findViewById(R.id.pear2));
//        registerForContextMenu(findViewById(R.id.sponge2));


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.myBottomNavigation);
        bottomNavigationView.setOnNavigationItemReselectedListener(
                new BottomNavigationView.OnNavigationItemReselectedListener(){
                    @Override
                    public void onNavigationItemReselected(@NonNull MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.home:
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            case R.id.park:
                                startActivity(new Intent(getApplicationContext(), Part_2_2.class));
                            case R.id.plane:
                                startActivity(new Intent(getApplicationContext(), Part_2_3.class));

                        }

                    }



                }
        );
    }

    //BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.myBottomNavigation);

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        if(view.getId() == R.id.panda){
            menu.add(0,1,Menu.NONE,"1.Item");
            menu.add(0,2,Menu.NONE,"2.Item");
        }else if(view.getId() == R.id.pear){
            menu.add(0,3,Menu.NONE,"3.Item");
            menu.add(0,4,Menu.NONE,"4.Item");
        }else{
            menu.add(0,5,Menu.NONE,"5.Item");
            menu.add(0,6,Menu.NONE,"6.Item");
        }


    }


}
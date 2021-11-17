package Lab_3.pwr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener{
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,1,Menu.NONE,"1.Item");
        menu.add(0,2,Menu.NONE,"2.Item");
        menu.add(0,3,Menu.NONE,"3.Item");
        MenuItem check_menu = menu.add(0,4,Menu.NONE,"4.Item");
        check_menu.setCheckable(true);

        SubMenu subMenu = menu.addSubMenu(0, 3, Menu.NONE,"MySub");
        subMenu.add(0,3,0,"1.Item");
        subMenu.add(0,4,0,"2.Item");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 1:
                startActivity(new Intent(getApplicationContext(), Part_2.class));
                return true;
            case 3:
                startActivity(new Intent(getApplicationContext(), XML_Menu.class));
                return true;
            case 4:
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

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 2:
                startActivity(new Intent(getApplicationContext(), XML_Menu.class));
                return true;
            default:
                Toast.makeText(getApplicationContext(), item.getTitle() + " " + item.getItemId(), Toast.LENGTH_SHORT).show();
                return true;
        }
    }

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerForContextMenu(findViewById(R.id.panda));
        registerForContextMenu(findViewById(R.id.pear));
        registerForContextMenu(findViewById(R.id.sponge));

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.myBottomNavigation);
        bottomNavigationView.bringToFront();

//        bottomNavigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);
        bottomNavigationView.setSelectedItemId(R.id.home);


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
//    Home firstFragment = new Home();
//    Plane secondFragment = new Plane();
//    Park thirdFragment = new Park();

//private BottomNavigationView.OnNavigationItemReselectedListener navListener =
//        new BottomNavigationView.OnNavigationItemReselectedListener();
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//        switch (item.getItemId()) {
//            case R.id.plane:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
//                return true;
//
//            case R.id.home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
//                return true;
//
//            case R.id.park:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
//                return true;
//        }
//        return false;
//    }

    public void openActionMode(View view){
        startActionMode(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(0,1,Menu.NONE,"1.Item");
                menu.add(0,2,Menu.NONE,"2.Item");
                menu.add(0,3,Menu.NONE,"3.Item");
                menu.add(0,4,Menu.NONE,"4.Item");
                menu.add(0,5,Menu.NONE,"5.Item");
                menu.add(0,6,Menu.NONE,"6.Item");
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                Toast.makeText(getApplicationContext(), item.getTitle() + " " + item.getItemId(), Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {

    }
}
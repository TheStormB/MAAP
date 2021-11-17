package Lab_3.pwr;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Part_2_3 extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        menu.add(0,1,Menu.NONE,"Just");
        menu.add(0,2,Menu.NONE,"Clicks");

        SubMenu subMenu = menu.addSubMenu(0, 3, Menu.NONE,"MySub");
        MenuItem check_menu = subMenu.add(0,4,0,"Border");
        check_menu.setCheckable(true);
        MenuItem check_menu2 = subMenu.add(0,5,0,"Title");
        check_menu2.setCheckable(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        TextView itemTextView;
        itemTextView = (TextView) findViewById(R.id.mytitle);
        RelativeLayout background = findViewById(R.id.my_page);

        switch(item.getItemId()){
            case 4:
                if(item.isChecked()) {
                    item.setChecked(false);
                    background.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary_dark));
                    return true;
                }else
                    item.setChecked(true);
                    background.setBackgroundColor(getResources().getColor(R.color.cardview_light_background));
                return true;
            case 5:
                if(item.isChecked()) {
                    item.setChecked(false);
                    itemTextView.setVisibility(View.INVISIBLE);
                }else
                    item.setChecked(true);
                    itemTextView.setVisibility(View.VISIBLE);
                return true;
            default:
                Toast.makeText(getApplicationContext(), item.getTitle() + " " + item.getItemId(), Toast.LENGTH_SHORT).show();
                return true;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        if(view.getId() == R.id.pear2){
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_2_3);
        registerForContextMenu(findViewById(R.id.pear2));


    }


}
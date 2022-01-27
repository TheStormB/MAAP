package com.example.lab_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.lab_5.DataPackage.InteractionListener;
import com.example.lab_5.DataPackage.ItemData;
import com.example.lab_5.DataPackage.ItemFragment;
import com.example.lab_5.DataPackage.MyRepository;
import com.example.lab_5.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements InteractionListener {


    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private MyRepository repo;
    ListFragment myListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        repo = new MyRepository(this.getApplication());

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        ItemFragment f = (ItemFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_content_main);
        f.setData(repo.getDataList());

        ActivityResultLauncher<Intent> result_launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result){
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();

                            ItemData d = new ItemData();
                            d.txtMain = data.getStringExtra("Name");
                            d.txtSecond = data.getStringExtra("SurName");
                            d.age = data.getIntExtra("age", -1);
                            System.out.println("-----------------"+d.txtMain);
                            System.out.println("-----------------"+d.txtSecond);


                            repo.insertItem(d);
//                            myListFragment.setList(getRepositoryList());
                            f.setData(repo.getDataList());
                        }
                    }
                }
        );

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddItemActivity.class);
                result_launcher.launch(i);
            }
        });
    }



    @Override
    public void onDeleteItem(ItemData i) {
        repo.deleteItem(i);
    }

    @Override
    public List<ItemData> getItems() {
        return this.repo.getDataList();
    }
}
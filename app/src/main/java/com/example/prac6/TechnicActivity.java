package com.example.prac6;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class TechnicActivity extends AppCompatActivity {
    ImageView imageView ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.secondImage);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Тех. Центр");
            }
        NavigationBarView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(
                item->{
                    if (item.getItemId()==R.id.sto){
                        actionBar.setTitle("СТО");
                        imageView.setImageResource(R.drawable.service);
                    }else if(item.getItemId()==R.id.items){
                        actionBar.setTitle("Запчасти");
                        imageView.setImageResource(R.drawable.parts);
                    }else if(item.getItemId()==R.id.showroom){
                        actionBar.setTitle("Шоурум");
                        imageView.setImageResource(R.drawable.carsshowroom);
                    }
                    return false;
                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

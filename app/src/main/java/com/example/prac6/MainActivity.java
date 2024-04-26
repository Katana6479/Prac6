package com.example.prac6;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
//    public DrawerLayout drawer;
//    public ActionBarDrawerToggle toggle;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.drawler_activity);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar!=null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setTitle("Главная");
//            }
//        BottomNavigationView bottomNavigationView = findViewById(R.id.botNav);
//        bottomNavigationView.setOnNavigationItemSelectedListener(
//                item->{
//                    if (item.getItemId()==R.id.home){
//                        actionBar.setTitle("Главная");
//                    }else if(item.getItemId()==R.id.notification){
//                        actionBar.setTitle("Уведомления");
//                    }else if(item.getItemId()==R.id.settings){
//                        actionBar.setTitle("Настройки");
//                    }
//                    return false;
//                }
//        );
//        drawer = findViewById(R.id.drawerLayout);
//        toggle = new ActionBarDrawerToggle(MainActivity.this,
//                drawer, R.string.drawer_open, R.string.drawer_close);
//        if(drawer!=null){
//            drawer.addDrawerListener(toggle);
//        }
//        toggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        }
//        @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        if (toggle.onOptionsItemSelected(item)){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
public DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawler_activity);
        NavigationView navigationView;
        FrameLayout frameLayout;
        frameLayout = findViewById(R.id.content_frame);
        ImageView imageView = findViewById(R.id.image);
        actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Машины");
        }
        drawer = findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(MainActivity.this,
                drawer, R.string.drawer_open, R.string.drawer_close);
        if(drawer!=null){
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView= findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem menuItem) {
                        if(menuItem.getItemId()==R.id.cars_main){
                            actionBar.setTitle("Машины");
                            imageView.setImageResource(R.drawable.kartinki_mersedes_mercedes_9);
                        } else if (menuItem.getItemId()==R.id.tracks) {
                            actionBar.setTitle("Треки");
                            imageView.setImageResource(R.drawable.track);
                        } else if (menuItem.getItemId()==R.id.wheels) {
                            actionBar.setTitle("Диски");
                            imageView.setImageResource(R.drawable.wheelsimage);
                        } else if (menuItem.getItemId()==R.id.technic) {
                            Intent intent= new Intent(MainActivity.this, TechnicActivity.class);
                            startActivity(intent);
                        }
                        return false;
                    }
                }
        );
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
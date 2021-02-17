package jbaker57.cvtc.rtgame_minecraft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new InfoFragment());
        fragmentTransaction.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        drawerLayout.closeDrawer(GravityCompat.START);

        if (menuItem.getItemId() == R.id.rulesAndInfo) {

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new InfoFragment());
            fragmentTransaction.commit();

        }

        if (menuItem.getItemId() == R.id.wiki) {

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new WikiFragment());
            fragmentTransaction.commit();

        }

        if (menuItem.getItemId() == R.id.survival) {

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new SurvivalFragment());
            fragmentTransaction.commit();

        }

        if (menuItem.getItemId() == R.id.build) {

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new BuildFragment());
            fragmentTransaction.commit();

        }

        if (menuItem.getItemId() == R.id.creative) {

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new CreativeFragment());
            fragmentTransaction.commit();

        }

        /*if (menuItem.getItemId() == R.id.playerStats) {

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new PlayerFragment());
            fragmentTransaction.commit();

        }*/

        return true;

    }

    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis()) {

            super.onBackPressed();
            return;

        } else {

            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();

        }

        backPressedTime = System.currentTimeMillis();

    }
}
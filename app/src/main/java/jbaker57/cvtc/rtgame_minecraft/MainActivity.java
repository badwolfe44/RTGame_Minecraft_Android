package jbaker57.cvtc.rtgame_minecraft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    WebView wv;



    public String url;

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

        wv = (WebView) findViewById(R.id.webViewTest);
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://bookstack.rtgame.co.uk/books/minecraft");

        /*fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new InfoFragment());
        fragmentTransaction.commit();*/


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        drawerLayout.closeDrawer(GravityCompat.START);

        if (menuItem.getItemId() == R.id.rulesAndInfo) {

            wv.loadUrl("https://bookstack.rtgame.co.uk/books/minecraft");

        }

        if (menuItem.getItemId() == R.id.wiki) {

            wv.loadUrl("https://wiki.rtgame.co.uk/");

        }

        if (menuItem.getItemId() == R.id.survival) {

            wv.loadUrl("https://minecraft.rtgame.co.uk/map/survival");

        }

        if (menuItem.getItemId() == R.id.build) {

            wv.loadUrl("https://minecraft.rtgame.co.uk/map/build");

        }

        if (menuItem.getItemId() == R.id.creative) {

            wv.loadUrl("https://minecraft.rtgame.co.uk/map/creative");

        }

        /*if (menuItem.getItemId() == R.id.playerStats) {

            wv.loadUrl("https://bookstack.rtgame.co.uk/books/minecraft");

        }*/

        return true;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /*@Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis()) {

            super.onBackPressed();
            return;

        } else {

            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();

        }

        backPressedTime = System.currentTimeMillis();

    }*/

    @Override
    public void onBackPressed() {
        if (wv.canGoBack()) {
            wv.goBack();
        } else {

            if(backPressedTime + 2000 > System.currentTimeMillis()) {

                super.onBackPressed();
                return;

            } else {

                Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();

            }

            backPressedTime = System.currentTimeMillis();

        }
    }

}
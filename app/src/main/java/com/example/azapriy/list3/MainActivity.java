package com.example.azapriy.list3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String[] dataSet = { "Qaawws", "Bkxcsf", "sdfksskvuksjv fvjufvidfub", "sdfsdfs", "dfsdfsdf", "sfhsbfbsv", "sdfhsfhsmhfdhm",
            "111111111", "2222222222", "3333333333", "444444444", "55555555555", "6666666666", "77777777777777",
            "888888", "999999999", "1010101010110", "111111111111", "12121212121212", "13131313131313131313",
            "14141414141414", "151515151515", "16161616161616", "17171771717171", "1818181818818181" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FrameLayout main_container = (FrameLayout) findViewById(R.id.main_container);
        main_container.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);

        if (id == R.id.nav_linear_layout_dynamic) {
            ScrollView scroll = (ScrollView) inflater.inflate(R.layout.simple_linear_layout, null);
            LinearLayout list = (LinearLayout) (scroll.findViewById(R.id.simple_linear_layout));
            for(int i=0; i < 40; i++) {
                TextView list_item = (TextView) inflater.inflate(R.layout.list_item, null);
                list_item.setText("New Item " + i);
                list.addView(list_item);
            }
            main_container.addView(scroll);
        } else if (id == R.id.nav_list_view) {
            ListView list = (ListView) inflater.inflate(R.layout.list_view, null);
            list.setAdapter(new MyListViewAdapter(this, new ArrayList<>(Arrays.asList(dataSet))));
            main_container.addView(list);
        } else if (id == R.id.nav_recycler_view) {
            RecyclerView list = (RecyclerView) inflater.inflate(R.layout.recycler_view, null);
            list.setHasFixedSize(true);
            LinearLayoutManager manager = new LinearLayoutManager(this);
            list.setLayoutManager(manager);
            CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(dataSet);
            list.setAdapter(adapter);
            main_container.addView(list);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

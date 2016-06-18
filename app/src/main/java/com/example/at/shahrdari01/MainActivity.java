package com.example.at.shahrdari01;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import com.szugyi.circlemenu.view.CircleImageView;
import com.szugyi.circlemenu.view.CircleLayout;
import com.szugyi.circlemenu.view.CircleLayout.OnCenterClickListener;
import com.szugyi.circlemenu.view.CircleLayout.OnItemClickListener;
import com.szugyi.circlemenu.view.CircleLayout.OnItemSelectedListener;
import com.szugyi.circlemenu.view.CircleLayout.OnRotationFinishedListener;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnItemSelectedListener,
        OnItemClickListener, OnRotationFinishedListener, OnCenterClickListener  {


    protected CircleLayout circleLayout;
    protected TextView selectedTextView;


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



        // Set listeners
        circleLayout = (CircleLayout) findViewById(R.id.circle_layout);
        circleLayout.setOnItemSelectedListener(this);
        circleLayout.setOnItemClickListener(this);
        circleLayout.setOnRotationFinishedListener(this);
        circleLayout.setOnCenterClickListener(this);

        selectedTextView = (TextView) findViewById(R.id.selected_textView);

        String name = null;
        View view = circleLayout.getSelectedItem();
        if (view instanceof CircleImageView) {
            name = ((CircleImageView) view).getName();
        }
        selectedTextView.setText(name);


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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemSelected(View view) {
        final String name;
        if (view instanceof CircleImageView) {
            name = ((CircleImageView) view).getName();
        } else {
            name = null;
        }

        selectedTextView.setText(name);

        switch (view.getId()) {
            case R.id.main_akhbar_image:
                // Handle calendar selection
                break;
            case R.id.main_etelaresani_image:
                // Handle cloud selection
                break;
            case R.id.main_rahnama_image:
                // Handle key selection
                break;
            case R.id.main_khadamatelectronic_image:
                // Handle mail selection
                break;
//            case R.id.main_mihmandamavand_image:
                // Handle profile selection
//                break;
            case R.id.main_shahrdari_image:
                // Handle tap selection
                break;
        }
    }

    @Override
    public void onItemClick(View view) {
        String name = null;
        if (view instanceof CircleImageView) {
            name = ((CircleImageView) view).getName();
        }

        String text = getResources().getString(R.string.start_app, name);
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

        switch (view.getId()) {
            case R.id.main_akhbar_image:
                // Handle calendar selection
                break;
            case R.id.main_etelaresani_image:
                // Handle cloud selection
                break;
            case R.id.main_rahnama_image:
                // Handle key selection
                break;
            case R.id.main_khadamatelectronic_image:
                // Handle mail selection
                break;
//            case R.id.main_mihmandamavand_image:
                // Handle profile selection
//                break;
            case R.id.main_shahrdari_image:
                // Handle tap selection
                break;
        }
    }

    @Override
    public void onRotationFinished(View view) {
        Animation animation = new RotateAnimation(0, 360, view.getWidth() / 2, view.getHeight() / 2);
        animation.setDuration(250);
        view.startAnimation(animation);

        goToMihmandamavandActivity(view);


    }

    @Override
    public void onCenterClick() {
        Toast.makeText(getApplicationContext(), R.string.center_click, Toast.LENGTH_SHORT).show();
    }

    private void goToMihmandamavandActivity(View view) {

        String[] strList = null;
        String strTitle = new String();
        String strActionbar_color = new String();

        int iColor = 0;


        Intent intent = new Intent(this, MihmanDamavandActivity.class);

        switch (view.getId()) {
            case R.id.main_akhbar_image:
                // Handle calendar selection
                strList = new String[3];
                strList[0] = getResources().getString(R.string.akhbar_shahr);
                strList[1] = getResources().getString(R.string.akbar_shahrdari);
                strList[2] = getResources().getString(R.string.shahrvand_khabarnegar);

                strTitle = getResources().getString(R.string.akhbar);

                iColor = getResources().getColor(R.color.akhbar);
                break;
            case R.id.main_etelaresani_image:
                // Handle cloud selection
                strList = new String[3];
                strList[0] = getResources().getString(R.string.taqvim);
                strList[1] = getResources().getString(R.string.ab_hava);
                strList[2] = getResources().getString(R.string.oghatesharii);

                strTitle = getResources().getString(R.string.etelaresani);

                iColor = getResources().getColor(R.color.etelaresani);
                break;
            case R.id.main_rahnama_image:
                // Handle key selection
                strList = new String[4];
                strList[0] = getResources().getString(R.string.darbarh_shahrdari);
                strList[1] = getResources().getString(R.string.projects);
                strList[2] = getResources().getString(R.string.dastresi_be_site);
                strList[3] = getResources().getString(R.string.rahnamaye_narm_afzar);

                strTitle = getResources().getString(R.string.rahnama);

                iColor = getResources().getColor(R.color.rahnama);
                break;
            case R.id.main_khadamatelectronic_image:
                // Handle mail selection
                strList = new String[3];
                strList[0] = getResources().getString(R.string.samaneh137);
                strList[1] = getResources().getString(R.string.tarh_tafsili);
                strList[2] = getResources().getString(R.string.samaneh_nosazi);

                strTitle = getResources().getString(R.string.khadamtelectronic);

                iColor = getResources().getColor(R.color.khadamatelectronic);
                break;
/*            case R.id.main_mihmandamavand_image:
                // Handle profile selection
                strList = new String[7];
                strList[0] = getResources().getString(R.string.khadamat_eghamati);
                strList[1] = getResources().getString(R.string.panorama_photos);
                strList[2] = getResources().getString(R.string.khadamt_ertebati);
                strList[3] = getResources().getString(R.string.jazebehhaye_gardeshgari);
                strList[4] = getResources().getString(R.string.ketabe_karbordi);
                strList[5] = getResources().getString(R.string.setad_eskan_norouzi);
                strList[6] = getResources().getString(R.string.city_map);

                strTitle = getResources().getString(R.string.mihmanedamavand);

                iColor = getResources().getColor(R.color.mihmandamavand);
                break;
*/
            case R.id.main_shahrdari_image:
                // Handle tap selection
                strList = new String[2];
                strList[0] = getResources().getString(R.string.shahrdari_item01);
                strList[1] = getResources().getString(R.string.shahrdari_item02);


                strTitle = getResources().getString(R.string.shahrdari);

                iColor = getResources().getColor(R.color.shahrdari);
                break;
            case R.id.main_tourtasviri_image:
                // Handle tap selection
                strList = new String[4];
                strList[0] = getResources().getString(R.string.gardesh_tafrih);
                strList[1] = getResources().getString(R.string.gozari_dar_shahr);
                strList[2] = getResources().getString(R.string.amaken_tarikhi);
                strList[3] = getResources().getString(R.string.farhangi_mazhabi);

                strTitle = getResources().getString(R.string.tourtasviri);

                iColor = getResources().getColor(R.color.tourtasviri);
                //iColor = Color.parseColor("#"+Integer.toHexString(getResources().getColor(R.color.colorAccent2)));
                break;

            case R.id.main_khorouj_image:
                // Handle tap selection
                return;
        }

        intent.putExtra("strList", strList);
        intent.putExtra("strTitle", strTitle);

        strActionbar_color = "#" + Integer.toHexString(iColor);
        intent.putExtra("strActionbar_color",strActionbar_color);

      startActivity(intent);
    }




}

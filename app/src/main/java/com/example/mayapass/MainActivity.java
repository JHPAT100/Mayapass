package com.example.mayapass;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,BlankFragment.OnFragmentInteractionListener,login.OnFragmentInteractionListener,
        registro_usuario.OnFragmentInteractionListener,registro_h.OnFragmentInteractionListener,lista_h.OnFragmentInteractionListener,
        mostrar_h.OnFragmentInteractionListener,lista_1.OnFragmentInteractionListener,mostrar_todo.OnFragmentInteractionListener,
        lista_2.OnFragmentInteractionListener,mostrar_m.OnFragmentInteractionListener,lista_3.OnFragmentInteractionListener,mostrar_l.OnFragmentInteractionListener
        ,gracias.OnFragmentInteractionListener{
    public static View bf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment miFragment = new registro_h();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_principal,miFragment).commit();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        bf = findViewById(R.id.fab);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        bf = findViewById(R.id.fab); bf.setVisibility(View.GONE);
        //coloca un fragmento como principal
        Fragment fragment=new lista_2();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_principal,fragment).commit();
        //termina el codigo
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        Fragment miFragment=null;
        boolean fragmentSeleccionado=false;
        int id = item.getItemId();
         if (id == R.id.nav_2) {
            miFragment = new lista_1();
            fragmentSeleccionado = true;
             bf = findViewById(R.id.fab); bf.setVisibility(View.GONE);
        } else if (id == R.id.nav_3) {
            miFragment = new lista_2();
            fragmentSeleccionado = true;
        bf = findViewById(R.id.fab); bf.setVisibility(View.GONE);
        } else if (id == R.id.nav_4) {
             miFragment = new lista_3();
             fragmentSeleccionado = true;
             bf = findViewById(R.id.fab); bf.setVisibility(View.GONE);
        } else if (id == R.id.nav_5) {
            miFragment = new BlankFragment();
            fragmentSeleccionado = true;
         bf = findViewById(R.id.fab); bf.setVisibility(View.GONE);

        } else if (id == R.id.nav_6) {
             Intent intent = new Intent(Intent.ACTION_SEND);
             intent.setType("text/plain");
             intent.putExtra(Intent.EXTRA_TEXT, "Sigueme me ayudaria mucho https://www.facebook.com/jesus.JHAPT.3");
             startActivity(Intent.createChooser(intent, "Share with"));
             miFragment = new gracias();
             fragmentSeleccionado = true;
             bf = findViewById(R.id.fab); bf.setVisibility(View.GONE);

        } else if (id == R.id.nav_7) {
             miFragment = new gracias();
             fragmentSeleccionado = true;
             bf = findViewById(R.id.fab); bf.setVisibility(View.GONE);
             Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","sanhool@live.com.mx", null));
             emailIntent.putExtra(Intent.EXTRA_SUBJECT, "System 32:");
             startActivity(Intent.createChooser(emailIntent, "Tu opiniion es importante"));

    } else if (id == R.id.nav_8) {

    } else if (id == R.id.nav_9) {

    } else if (id == R.id.nav_10) {
        miFragment = new login();
        fragmentSeleccionado = true;
        bf = findViewById(R.id.fab); bf.setVisibility(View.GONE);
    }
        if(fragmentSeleccionado=true){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_principal,miFragment).commit();

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

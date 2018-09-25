package com.example.android.navigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int EMAIL_REQUEST = 1000;
    public static final String NAME_KEY = "name_key";
    public static final String EMAIL_KEY = "email_key";

    private static final String COORDINATES = "44.436967,26.090984";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmailListActivity.class);
                intent.putExtra(NAME_KEY, "Your Name");
                startActivityForResult(intent, EMAIL_REQUEST);
            }
        });
    }

    public void displayStarters(View view) {
        Intent intent = new Intent(this, StartersActivity.class);
        startActivity(intent);
    }

    public void displayEntrees(View view) {
        Intent intent = new Intent(this, EntreesActivity.class);
        startActivity(intent);
    }

    public void displayDesserts(View view) {
        Intent intent = new Intent(this, DessertsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EMAIL_REQUEST && resultCode == RESULT_OK) {
            String nameText = data.getStringExtra(NAME_KEY);
            String emailText = data.getStringExtra(EMAIL_KEY);
            Toast.makeText(this, "You entered: " + nameText + " and " + emailText,
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void displayMap(View view) {
        Uri uri = Uri.parse("geo:" + COORDINATES);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu ( Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);




        MenuItem item = menu.add (Menu.NONE, Menu.NONE, 99,"New Menu Item");

        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, "You chose the menu item",Toast.LENGTH_LONG).show();

                return false;
            }
        });

        return true; }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_about:
                Intent intent2 = new Intent(this, AboutActivity.class);
                startActivity(intent2);
                return true;


        }

        return super.onOptionsItemSelected(item);


    }

    }

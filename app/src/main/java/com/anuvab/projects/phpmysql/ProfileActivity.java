package com.anuvab.projects.phpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewUsername,textViewUserEmail;
    //Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        textViewUserEmail=findViewById(R.id.textViewUseremail);
        textViewUsername=findViewById(R.id.textViewUsername);

        textViewUserEmail.setText(SharedPrefManager.getInstance(this).getUseremail());
        textViewUsername.setText(SharedPrefManager.getInstance(this).getUsername());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id){
            case R.id.menuLogout:
                SharedPrefManager.getInstance(this).logOut();
                finish();
                startActivity(new Intent(this,LoginActivity.class));
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }
}

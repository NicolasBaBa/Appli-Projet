package com.example.nicolas.smartride2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.nicolas.smartride2.BDD.BDD;
import com.example.nicolas.smartride2.BDD.User;

public class ProfilActivity extends AppCompatActivity {
    private BDD bdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bdd = new BDD(this);
        setContentView(R.layout.activity_profil);
        setTitle("Profile");

        String login = null;
        if (savedInstanceState == null) {
            Bundle extras = this.getIntent().getExtras();
            if (extras == null) {
                login = null;
            } else {
                login = extras.getString("User_for_BDD");
            }
        }

        bdd.open();
        User user = bdd.getUserWithLogin(login);
        bdd.close();
        String ageS = Integer.toString(user.getAge());

        if  (user!=null) {
            TextView loginP = (TextView) findViewById(R.id.textlogin);
            loginP.setText(user.getLogin());
            TextView pswdP = (TextView) findViewById(R.id.textpswd);
            pswdP.setText("**********");
            TextView nameP = (TextView) findViewById(R.id.textnomprofil);
            nameP.setText(user.getName());
            TextView surnameP = (TextView) findViewById(R.id.textprenomprofil);
            surnameP.setText(user.getSurname());
            TextView ageP = (TextView) findViewById(R.id.textageprofil);
            ageP.setText(ageS);
        }

    }

}
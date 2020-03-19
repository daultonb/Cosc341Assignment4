package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Swiping extends AppCompatActivity {

    String [] names = {"Selena","Miranda","Freddie","Drake", "Josh"};
    String [] majors = {"Biology", "Chemistry", "Human Kinetics", "Music", "English"};
    String [] schools = {"Hogwarts", "UBC", "UVic", "UCLA", "UBCO"};
    String [] hometowns = {"Manhattan, NY", "San fransisco, CA", "London, UK", "Toronto, CA", "Vancouver, CA"};
    String [] bios = {"Hi, I am Selena.","Hi, I am Miranda.","Hi, I am Freddie.", "Hi, I am Drake.", "Hi, I am Josh."};

    int counter = 0;

    //These are attributes of the individual
    ImageView pic;
    TextView name;
    TextView major;
    TextView school;
    TextView hometown;
    TextView bio;
    //These are the fields that label the above textviews (ex. Major0 text = "Major:")
    TextView major0;
    TextView school0;
    TextView hometown0;
    TextView bio0;
    //Appears when no new users available
    TextView nofriends;
    View b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiping);

        pic = findViewById(R.id.profilepic);
        name = findViewById(R.id.name);
        major = findViewById(R.id.major1);
        major0 = findViewById(R.id.major);
        school = findViewById(R.id.school1);
        school0 = findViewById(R.id.school);
        hometown = findViewById(R.id.hometown1);
        hometown0 = findViewById(R.id.hometown);
        bio = findViewById(R.id.bio1);
        bio0 = findViewById(R.id.bio);
        nofriends = findViewById(R.id.nofriends);
        nofriends.setText("There are no new friends in your area. Please check back later.");
        nofriends.setVisibility(View.GONE);
        Swipe(b);
    }


    public void Swipe (View v){
        b = v;
        if (counter == 5){
            pic.setImageResource(R.drawable.missing);
            nofriends.setVisibility(View.VISIBLE);
            name.setVisibility(View.GONE);
            major.setVisibility(View.GONE);
            major0.setVisibility(View.GONE);
            school.setVisibility(View.GONE);
            school0.setVisibility(View.GONE);
            hometown.setVisibility(View.GONE);
            hometown0.setVisibility(View.GONE);
            bio.setVisibility(View.GONE);
            bio0.setVisibility(View.GONE);
        }
        else{
            name.setText(names[counter]);
            major.setText(majors[counter]);
            school.setText(schools[counter]);
            hometown.setText(hometowns[counter]);
            bio.setText(bios[counter]);

            if (counter == 0){
                pic.setImageResource(R.drawable.selena);
                counter ++;
            }
            else if (counter == 1){
                pic.setImageResource(R.drawable.miranda);
                counter ++;
            }
            else if (counter == 2){
                pic.setImageResource(R.drawable.freddie);
                counter ++;
            }
            else if (counter == 3){
                pic.setImageResource(R.drawable.drake);
                counter ++;
            }
            else if (counter == 4){
                pic.setImageResource(R.drawable.josh);
                counter ++;
            }
        }

    }

    public void goToProfile (View v){
        finish();
    }

    public void goToMessages (View v){
        Intent intent = new Intent(this, Connections.class);
        finish();
        startActivity(intent);
    }
}

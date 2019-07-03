package com.example.a200393894midterm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    DatabaseReference db;
    List<Game> game;

    EditText editTextFirstName , editTextLastName;
    Spinner spinnerUserChoice;
    TextView textViewAndroidChoice;
    Button play, reset;
    String userChoice,androidChoice;
    private static final Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        spinnerUserChoice = (Spinner)findViewById(R.id.spinnerUserChoice);
        textViewAndroidChoice = (TextView) findViewById(R.id.textViewAndroidChoice);
        play = (Button) findViewById(R.id.buttonPlay);
        reset = (Button) findViewById(R.id.buttonReset);

        spinnerUserChoice.getItemAtPosition(spinnerUserChoice.getSelectedItemPosition()).toString();



        userChoice = spinnerUserChoice.getSelectedItem().toString();

        //userChoice = spinnerUserChoice.getSelectedItem().toString().trim();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int randInt = rand.nextInt(100)+1;
                if(randInt<34){
                    androidChoice = "Rock";
                    textViewAndroidChoice.setText(androidChoice);
                }
                else if(33<randInt&&randInt<67){
                    androidChoice = "Paper";
                    textViewAndroidChoice.setText(androidChoice);

                }
                else if (randInt>66){
                    androidChoice = "Scissor";
                    textViewAndroidChoice.setText(androidChoice);
                }

                if(androidChoice.equals("Rock") && userChoice.equals("Paper")){

                    Toast.makeText(MainActivity.this, "You Won", Toast.LENGTH_SHORT).show();

                }
                else if(androidChoice.equals("Rock")&& userChoice.equals("Scissor")){

                    Toast.makeText(MainActivity.this, "Android Won", Toast.LENGTH_SHORT).show();

                }
                else if(androidChoice.equals("Rock")&& userChoice.equals("Rock")){

                    Toast.makeText(MainActivity.this, "Tied", Toast.LENGTH_SHORT).show();

                }
                else if(androidChoice.equals("Paper")&& userChoice.equals("Paper")){

                    Toast.makeText(MainActivity.this, "Tied", Toast.LENGTH_SHORT).show();

                }
                else if(androidChoice.equals("Paper")&& userChoice.equals("Scissor")){

                    Toast.makeText(MainActivity.this, "You Won", Toast.LENGTH_SHORT).show();

                }
                else if(androidChoice.equals("Paper")&& userChoice.equals("Rock")){

                    Toast.makeText(MainActivity.this, "Android Won", Toast.LENGTH_SHORT).show();

                }
                else if(androidChoice.equals("Scissor")&& userChoice.equals("Scissor")){

                    Toast.makeText(MainActivity.this, "Tied", Toast.LENGTH_SHORT).show();

                }
                else if(androidChoice.equals("Scissor")&& userChoice.equals("Paper")){

                    Toast.makeText(MainActivity.this, "Android Won", Toast.LENGTH_SHORT).show();

                }
                else if(androidChoice.equals("Scissor")&& userChoice.equals("Rock")){

                    Toast.makeText(MainActivity.this, "You Won", Toast.LENGTH_SHORT).show();

                }



            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textViewAndroidChoice.setText("Rock");
                spinnerUserChoice.setSelection(0);


            }
        });


    }
}
    protected void onStart(){
        super.onStart();


        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //results.clear();

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    Game game = postSnapshot.getValue(Game.class);
                    game.add(game);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void addRes(){
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String userChoice = spinnerUserChoice.getText().toString().trim();




        if(!userInput.equals(" ")){
            String s = db.push().getKey();

            Game r = new Game(frstName, lastName, userChoice,Null,Null);
            db.child(s).setValue(r);

            Toast.makeText(this, "stored results", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show();

        }
    }

}


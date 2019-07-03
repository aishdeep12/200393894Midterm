package com.example.a200393894midterm;

import com.google.firebase.database.IgnoreExtraProperties;


public class Game {



        private String gameId;
        private String firstName;
        private String lastName;
        private String choice;
        private String winner;

        public Game(){

        }
        public Game(String gameId, String firstName, String lastName, String choice, String winner){
            this.gameId = gameId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.choice = choice;
            this.winner = winner;

        }
        public String getGameId(){
            return gameId;

        }
        public String getFirstName(){
            return  firstName;

        }
        public  String getLastName(){
            return lastName;
        }
        public  String getChoice(){
        return choice;
        }
        public  String getWinner(){
        return winner;
         }

    }



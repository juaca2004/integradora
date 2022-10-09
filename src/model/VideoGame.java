package model;

import model.Player;

import java.util.Random;


import model.Level;
//* */
public class  VideoGame{


//attribute

private int x;
private int y;


//relations
private Player [] player;
private Level [] level;

//constructor
    /**
    *constructor
    *method that is called to create the object
    *<b>pre:</b> data had to be entered to create the constructor.<br>
    *<b>post:</b> create videogame and also create the size of players and levels and create the level objects.
    *@param x  basis of the resolution
    *@param y resolution height
    *@return void
   */
public VideoGame(int x, int y) {
    this.x = x;
    this.y = y;
    
    player= new Player[20];
    level = new Level[10];

    level[0]= new Level(1,50);
    level[1]= new Level(2,100);
    level[2]= new Level(3,200);
    level[3]= new Level(4,300);
    level[4]= new Level(5,400);
    level[5]= new Level(6,500);
    level[6]= new Level(7,600);
    level[7]= new Level(8,700);
    level[8]= new Level(9,800);
    level[9]= new Level(10,1000);

}
    /**
    *createPlayer
    *the register player method
    *<b>pre:</b> a name and a nickname had to be entered and nickname not repeated.<br>
    *<b>post:</b> a name and a nickname had to be entered
    *@param  namePlayer name of player
    *@param nickname nickname of player
    *@return returns if the player was created or not
   */
public String createPlayer(String namePlayer, String nickname ){
    String massage="the player was created successfully";
     Player obj= searchPlayer(nickname);
     
     if(obj!=null){
        massage="the nickname already exists";
     }
     else{
        boolean vali=AvailablePlayer();
        if(vali==true){
          obj = new Player(nickname, namePlayer,level[0]);
          vali=false;
          for(int i=0;i<20 && !vali ;i++){
            if(player[i]==null){
                player[i]=obj;
                vali=true;
            }
            
          }

        }
     }      
    return massage;
    
} 
    /**
    *addEnemy
    *subroutine add enemy
    *<b>pre:</b> the values had to be entered to register enemies, and that the name is not repeated.<br>
    *<b>post:pass the parameters to the addEnemy method in level</b> 
    *@param name name of enemy  
    *@param option type of enemy
    *@param damage damage of enemy
    *@param score score of enemy
    *@param levelEnemy level of enemy go
    *@param positionX position of enemy in x
    *@param positionY position of enemy in y
    *@return returns if enemy is created, or not
   */
public String addEnemy(String name, int option, int damage, int score,int levelEnemy, int positionX, int positionY){
  String massage="enemy was successfully created";
  boolean validation=true;
  int h=0;
  for(int i=1; i<=10;i++){
    if(i==levelEnemy){
     validation=level[h].addEnemy(name,option,damage,score, positionX,positionY);
    if(validation==false){
     massage="that enemy already exists, you can not repeat";
     }
   }
   h++;
  }
    
  return massage;
}
    /**
    *addTresuare
    *subroutine add treasure
    *<b>pre:</b>the values had to be entered to register treasure.<br>
    *<b>post:</b> pass the parameters to addTreasure which is in level
    *@param name name of treasure  
    *@param url url of trasure's image
    *@param score score of treasure
    *@param levelTreasure the level to which treasure is redirected
    *@param positionX position of treasure in x
    *@param positionY position of treasure in y
    *@param numberTreasure number of times in which this treasure is repeated
    *@return returns if treasure was created or not
   */

public String addTresuare(String name, String url,int score ,int levelTreasure,int positionX, int positionY,int numberTreasure){
String massage="Treasure was successfully created";
boolean validation=true;
int h=0;
for(int i=1; i<=10 ;i++){

  if(i==levelTreasure){
   validation=level[h].addTreasure(name, url, score, positionX, positionY, numberTreasure);
     if(validation==false){
     massage="there is no more space to create more treasures according to the number you chose";
     }
 }
 h++;
}
 return massage;
}
    /**
    *searchPlayer
    *the method looks for a player with the nickname passed by parameter
    *<b>pre:</b> a string data must be entered.<br>
    *<b>post:</b> The method returns whether or not there is a user with that nicknmae
    *@param nickname nickname of player
    *@return Returns a player type data 
   */
public Player searchPlayer(String nickname){
    Player obj=null;
    boolean vali= false;
     for(int i=0;i<20 && !vali ;i++){
        if(player[i]!=null && player[i].getNickname().equals(nickname)){
            obj=player[i];
            vali= true;
        }
     }

    return obj;
    

}
    /**
    *AvailablePlayer
    *see if there is room in the players array
    *<b>pre:</b> that there is the arrangements players.<br>
    *<b>post:</b> returns whether or not there is space
    *@return returns a boolean that says if there is space or not
   */
public boolean AvailablePlayer(){
    boolean validation= true;
    if(player[19]!=null){
        validation=false;
    }
 
    return validation;
}
    /**
    * generatePosition
    *generate a random position
    *<b>pre:</b> that player has been created and that it has a value x that will be the limit.<br>
    *<b>post:</b> returns a random value with a maximum range of 0 to x
    *@param x random method x limiter
    *@return returns a random value with a maximum range of 0 to x
   */
public int generatePosition(int x){
 int position=0;
  Random r= new Random();

  position= (int) (r.nextInt()* x); 

 return position;

}
    /**
    *changeScorePlayer
    *the method changes the score of the entering player
    *<b>pre:</b> that the data has been entered correctly.<br>
    *<b>post:</b> returns whether or not the score change could be made
    *@param scoreNew the score new of player 
    *@param nickname nickname of player
    *@return returns whether or not I can make the change
   */
public String changeScorePlayer(int scoreNew, String  nickname){
   String massage="score change was done successfully";
   Player obj= searchPlayer(nickname);
   
     
     if (obj ==null){
        massage="the character you entered does not exist";
     }
     else if(scoreNew<obj.getScore()){
      massage="the new record must be greater than the new";
     }
     else{
      obj.setScore(scoreNew);
     }
   return massage;
}

    /**
    *increaseLevelPlayer
    *increases a player's level according to their score
    *<b>pre:</b> there must be a player, and have entered his nickname.<br>
    *<b>post:</b> change the player's level with a set
    *@param nickname  nickname of player
    *@return returns if the player changed the level or not, and if not, how much does he need to go to the next one
   */
public String increaseLevelPlayer(String nickname){
  
  Player obj= searchPlayer(nickname);
  String massage="level change was done successfully";
  if (obj ==null){
    massage="the character you entered does not exist";
  }
   else{
    int scorePlayer=obj.getScore();
    Level levelPlayer= obj.getLevelPlayer();
    if(scorePlayer<levelPlayer.getPoints_level()){
       if(scorePlayer==999){
        massage="you are already at the maximum level";
       }
       else{
        int amount=levelPlayer.getPoints_level()-scorePlayer;
        massage="still missing to go up to the next level, you need"+amount;
       }
    }
    else{
      for(int i=0;i<10;i++){
        if(levelPlayer.getId()==level[i].getId()){
          for(int h=i; h<10;h++){
            if(h==9){
              if(scorePlayer>=800 &&scorePlayer<1000){
                obj.setLevelPlayer(level[h]);
              } 
            }
             if((scorePlayer==level[h].getPoints_level())|| (scorePlayer > level[h].getPoints_level() && scorePlayer < level[h+1].getPoints_level())){
                obj.setLevelPlayer(level[h+1]);
             }
          }
        }

      }
    }
   }
  return massage;
  
}
    /**
    *allEnemy
    *Store all enemies in a message
    *<b>pre:</b>the video game object must have been created.<br>
    *<b>post:</b> return all enemies
    *@param levelEnemy  the level to redirect the method
    *@return returns a string with all the enemies of the level
   */
public String allEnemy(int levelEnemy){
  String massage=" ";
  String [] enemies= level[levelEnemy].getEnemy();
for(int i=0;i<level[levelEnemy].getEnemy().length; i++){
    massage += enemies[i]+" ,";
}

return massage;
}
    /**
    *allTreasures
    *Store all treasures in a message
    *<b>pre:</b>the object has been created.<br>
    *<b>post:</b> return all treasures
    *@param levelTreasure the level to redirect the method
    *@return returns a string with all the treasures of the level
   */
public String allTreasures(int levelTreasure){
  String massage=" ";
  String [] treasures= level[levelTreasure].getTreasure();
for(int i=0;i<level[levelTreasure].getTreasure().length; i++){
  if(treasures[i]!=null){
    massage += treasures[i]+" ,";
  }
}

return massage;
}
    /**
    *amountTreasure
    *this method goes through each level looking for the treasure entered
    *<b>pre:</b>the user has entered the treasure.<br>
    *<b>post:</b> returns the amount of that treasure
    *@param nameTreasure treasure name
    *@return returns a string with  the amount of that treasure
   */
public String amountTreasure(String nameTreasure){
int amount=0;
for(int i=0;i<10;i++){
  amount=level[i].countTreasure(nameTreasure)+ amount;
}
String massage="the amount found of that treasure is "+amount;

return massage;

}
    /**
    *amountTypeEnemy
    *this method goes through each level looking for the type of enemy
    *<b>pre:</b>the type of enemy should have been entered.<br>
    *<b>post:</b> returns the amount of that type of enemy in the game
    *@param enemyType type Enemy
    *@return returns a string with the amount of that type of enemy in the game
   */
public String amountTypeEnemy(int enemyType){
  int amount=0;
  for(int i=0;i<10;i++){
    amount=level[i].countEnemy(enemyType)+ amount;
  }
  String massage="the amount found of that type enemy is "+amount;
  
  return massage;
  
  }

      /**
    *mostTreasure
    *this method shows the most repeated treasure in the levels
    *<b>pre:</b>game should have been created.<br>
    *<b>post:</b> return the most repeated treasure
    *@return returns a string with the most repeated treasure
   */

  public String mostTreasure(){
    String massage=" ";
    String [] name;
    int [] repetitions;
 
    int amount=0;
    for(int i=0;i<10;i++){
     amount+=level[i].mostTresurePoint().length;
    }

    name= new String[amount];
    repetitions =new int[amount];
     
    for(int h=0;h<10;h++){

      for(int k=0;k<level[h].mostTresurePoint().length;k++){
        for(int p=0; p<amount;p++){
          if(name[p]!=null&&name[p].equalsIgnoreCase(level[h].getTreasure()[k])){
            repetitions[p]= repetitions[p]+level[h].mostTresurePoint()[k];
          }
          else if(p==amount-1){
            boolean validation=false;
            for(int t=0;t<amount && !validation ;t++){
               if(name[t]==null){
                name[t]=level[h].getTreasure()[k];
                repetitions[t]=level[h].mostTresurePoint()[k];
                  validation=true;
               }
           }

          }
        }
      }
    }
   int points=0;
   int position=0;
   for(int o=0;o<amount;o++){
    if(points>repetitions[o]){
     position=o;
     points=repetitions[o];
    }
   }

   if(name[position].equals("there are no treasures in this level")){
    massage="(there is no treasure in the whole game)";
   }
   else{
    massage="the most repeated treasure in the levels is "+name[position];
   }
   
    return massage;
  }

      /**
    *enemyMostScore
    *shows the enemy with the highest score in all levels
    *<b>pre:</b>game should have been created<br>
    *<b>post:</b> returns the name of the enemy with the highest score
    *@return returns a string with the name of the enemy with the highest score
   */
  public String enemyMostScore(){
   String massage=" ";
   int point=0;
   int position=0;

   for(int i=0; i<10;i++){
    if(level[i].enemyNameScore(level[i].enemyscore())>point){
      point=level[i].enemyNameScore(level[i].enemyscore());
      position=i;
    }
    }
    if(level[position].enemyscore().equals("none")){
      massage="there are no enemies registered in any level";
    }
    else{
    massage="the enemy with the highest score is" +level[position].enemyscore()+ " in the level "+level[position].getId();
    }
    return massage;
   }
      /**
    *amountConsonants
    *this method displays the number of consonants in enemy names throughout the game
    *<b>pre:</b>game should have been created<br>
    *<b>post:</b> returns number of consonants in enemy names throughout the game
    *@return returns a string with number of consonants in enemy names throughout the game
   */

   public String amountConsonants(){
    String massage="";
    int amount=0;
     for (int i=0;i<10;i++){
      amount+=level[i].consonantsEnemy();
     }
     if(amount==0){
      massage="there are no enemies registered in the game, or it does not have these names they do not have consonants";
     }
     else{
      massage="the number of consonants in enemy names throughout the game is "+amount;
     }
    return massage;
   }
      /**
    *amountConsonants
    *this method displays the top 5 of players
    *<b>pre:</b>game should have been created<br>
    *<b>post:</b> returns the top 5 of players
    *@return returns a string with the top 5 of players
   */
   public String topPlayer(){
    String massage="";
    int top1 = 0;
		int top2 = 0;
		int top3 = 0;
		int top4 = 0;
		int top5 = 0;
		String name1 = " ";
		String name2 = " ";
		String name3 = " ";
		String name4 = " ";
		String name5 = " "; 

		for(int i = 0; i<20; i++){

			if(player[i] != null && player[i].getScore() > top1){
				
				top5 = top4;
				top4= top3;
				top3= top2;
				top2 = top1;
				top1 = player[i].getScore();
				name5 = name4;
				name4 = name3;
				name3 = name2;
				name2= name1; 
				name1 =player[i].getNickname(); 
				
			} else if(player[i] != null && player[i].getScore() > top2){
				
				top5 = top4;
				top4= top3;
				top3= top2;
				top2 = player[i].getScore(); 
				name5 = name4;
				name4 = name3;
				name3 = name2;
				name2= player[i].getNickname();

			}else if( player[i] != null && player[i].getScore() > top3){

				top5 = top4;
				top4= top3;
				top3= player[i].getScore(); 
				name5 = name4;
				name4 = name3;
				name3 = player[i].getNickname();

			} else if(player[i] != null && player[i].getScore() > top4){

				top5 = top4;
				top4= player[i].getScore(); 
				name5 = name4;
				name4 = player[i].getNickname();

			}else if(player[i] != null && player[i].getScore() > top5){

				top5 = player[i].getScore();
				name5 = player[i].getNickname(); 
		
			}

			massage = "top 5 player \n" +
					"1."+ name1 + ": " + top1 + "\n"+
					"2."+ name2 + ": " + top2 + "\n"+
					"3."+ name3 + ": " + top3 + "\n"+
					"4."+ name4 + ": " + top4 + "\n"+
					"5."+ name5 + ": " + top5 + "\n"; 

		}
    return massage;
   }

    /**
    *getX
    *get the value x
    *<b>pre:</b>the object has been created.<br>
    *<b>post:</b> return the variable
    *@return return the variable
   */
public int getX() {
    return x;
}
    /**
    *setX
    *the method changes the value of x
    *<b>pre:</b> that the object exists.<br>
    *<b>post:</b> change the x to the new one
    *@param x  the parameter to replace in the current object to the current parameter
    *@return void
   */
public void setX(int x) {
    this.x = x;
}
    /**
    *getY
    *get the value y
    *<b>pre:</b>the object has been created.<br>
    *<b>post:</b> return the variable
    *@return return the variable
   */
public int getY() {
    return y;
}
    /**
    *setY
    *the method changes the value of y
    *<b>pre:</b> that the object exists.<br>
    *<b>post:</b> change the y to the new one
    *@param y  the parameter to replace in the current object to the current parameter
    *@return void
   */
public void setY(int y) {
    this.y = y;
}

 /** 
public String prueba(){
  int[] x=level[0].mostTresurePoint();
  String massage=" ";
  for(int i=0;i<x.length;i++){
    massage = massage+" "+x[i];
  }
  return massage;
}
*/



}

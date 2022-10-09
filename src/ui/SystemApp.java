package ui;
import model.VideoGame;
import java.util.Scanner;
//* */
public class SystemApp{

    public static Scanner lector=new Scanner(System.in);
    // relations
    private VideoGame videoGame;

    //methots
    public SystemApp() {
      askResolution();
    }
        /**
     * asks the user to type the desired option from those available and then ask for the value x and give the result
     * @p
     */
    public static void main(String[] args){
       SystemApp objMain=new SystemApp();
        
        boolean out = false;
        while(!out){
            System.out.println("1.create player");
            System.out.println("2.Register enemy to a level");
            System.out.println("3.Register treasure to a level");
            System.out.println("4.change player score");
            System.out.println("5.increase player level");
            System.out.println("6.Report treasures and enemies one level");
            System.out.println("7.found amount of a treasure in all levels");
            System.out.println("8.number of enemies of one type in all levels");
            System.out.println("9.report the most repeated treasure in all levels.");
            System.out.println("10.Inform the enemy that gives the highest score and the level where it is located.");
            System.out.println("11.Report the number of consonants found in the names of enemies in the game.");
            System.out.println("12.Inform the top 5 of the players according to the score.");
            System.out.println("13.out");
            int option;
            option= lector.nextInt();
            lector.nextLine();
            if (option==1){
                objMain.createPlayer();
            }
            if(option==2){
              objMain.registerEnemy();
            }
            if (option==3){
              objMain.registerTreasure();
            }
            if(option==4){
              objMain.changePointPlayer();
            }

            if(option==5){
              objMain.increaseLevelPlayer();
            }
            if(option==6){
              objMain.amountTreasureAndEnemy();
            }
            if(option==7){
              objMain.countTreasure();
            }
            if(option==8){
              objMain.countTypeEnemy();
            }
            if(option==9){
              objMain.mostTreasure();
            }
            if(option==10){
              objMain.enemymostscore();
            }
            if(option==11){
              objMain.consonantsEnemy();
            }
            if(option==12){
              objMain.topPlayer();
            }
            if(option==13){
              out = true;
            }
        }
        
        
        

    }

      /**
    * askResolution
    *the game is created
    *<b>pre:</b> the program has been started.<br>
    *<b>post:</b> game is created

   */

    public  void askResolution(){
       System.out.println("Welcome to the game");
       System.out.println("Enter the resolution you want");
       System.out.println("1.SD  2.QHD  3.HD  4.FHD  5.QHDD  6.UHD  7.UHD8");       
       int resolution_option= lector.nextInt();

       int x=640;
       int y=480;
       switch(resolution_option){
       case 2: 
          x=960;
          y=540;
               break;
       case 3: 
         x=1280;
         y=720;
               break;
       case 4: 
         x=1920;
         y=1080;
               break;
       case 5: ;
         x=2560;
         y=1440;

               break;
       case 6: ;
         x=3840;
         y=2160;
              break;
       case 7: ;
         x=7680;
         y=4320;
              break;
    }
        videoGame= new VideoGame(x,y);
        System.out.println("the game was created successfully");
    
  }
        /**
    * createPlayer
    *the method asks for the player data, to send them to create in videogame
    *<b>pre:</b> the option to create player has been chosen.<br>
    *<b>post:</b>player is created 

   */

  public  void createPlayer(){
    System.out.println("type the player's name");
    String name=lector.nextLine();
    System.out.println("type the player's nickname");
    String nickname=lector.nextLine();

    System.out.println(videoGame.createPlayer(name, nickname));

  }
      /**
    * registerEnemy
    *asks the user for enemy data
    *<b>pre:</b>the option to register enemy has been chosen.<br>
    *<b>post:</b> enemy is created
   */
  public void registerEnemy(){
    System.out.println("record the name of the enemy");
    String name=lector.nextLine();
    System.out.println("choose the type of enemy 1. ogre 2. abstract 3. boss 4. magic");
    int option=lector.nextInt();
    if(option<1 && option>4){
      System.out.println("you must enter one of the available options");
    }
    else{
      System.out.println("type the damage it produces");
      int damage=lector.nextInt();
      System.out.println("type the score you drop,this must be greater than 0");
      int score=lector.nextInt();
      if(score<=0){
        System.out.println("the score must be greater than 0");
      }
      else{
      int positionX= videoGame.generatePosition(videoGame.getX());
      int positionY= videoGame.generatePosition(videoGame.getY());
  
      System.out.println("type the level you want it must be between level 1 and level 10");
      int level=lector.nextInt();
      if(level>10 || level<1){
        System.out.println("you must type an existing option");
      }
      else{
        System.out.println(videoGame.addEnemy(name, option, damage, score, level, positionX, positionY));
      }
    }
   }
  }

      /**
    * registerTreasure
    *asks the user for treasure data
    *<b>pre:</b>the option to register treasure has been chosen.<br>
    *<b>post:</b> treasure is created
   */
  public  void registerTreasure(){
    System.out.println("record the name of the treasure");
    String name=lector.nextLine();
    System.out.println("type the url of the treasure image");
    String url=lector.nextLine();
    System.out.println("type the treasure score");
    int score=lector.nextInt();
    System.out.println("type the level you want it must be between level 1 and level 10");
    int level=lector.nextInt();
    if(level>10 || level<1){
      System.out.println("you must type an existing option");
    }
    else{
      int positionX= videoGame.generatePosition(videoGame.getX());
      int positionY= videoGame.generatePosition(videoGame.getY());
      System.out.println("enter the number of times that the treasure will repeat in the level, it must be greater than 0");
      int numberTreasure=lector.nextInt();
      if(numberTreasure>0){
        System.out.println(videoGame.addTresuare(name, url, score, level, positionX, positionY, numberTreasure));
      }
      else{
        System.out.println("you must enter a number of treasures greater than 0");
      }
    }    

  }

      /**
    * changePointPlayer
    *change the score of a player to only a data greater than 10 and less than 999 as it is the maximum score, which I put so that it would not pass the level
    *<b>pre:</b> the user has chosen to change player score.<br>
    *<b>post:</b> player score is changed
   */
  public  void changePointPlayer () {
    System.out.println("Enter the nickname of the player you want to change the score");
     String nickname=lector.nextLine();
    System.out.println("Enter the new score of the player remember that it must be greater than 10 and older than current and maximum 999");
     int scoreNew=lector.nextInt();
     if(scoreNew<10){
      System.out.println("must give a score greater than 10");
     }
     else if(scoreNew>999){
      System.out.println("the score must be less than or equal to 999");
     }
     else{
      System.out.println(videoGame.changeScorePlayer(scoreNew, nickname));
     }

    
  }
      /**
    * increaseLevelPlayer
    *Increase player level
    *<b>pre:</b> the user has chosen the option to increase player level.<br>
    *<b>post:</b> increase player level or not 
   */
  public  void increaseLevelPlayer () {
    System.out.println("Enter the nickname of the player you want to change the score");
    String nickname=lector.nextLine();
    System.out.println(videoGame.increaseLevelPlayer(nickname));
  }
      /**
    * amountTreasureAndEnemy
    *report the enemies and treasures of a level
    *<b>pre:</b> this option should have been chosen.<br>
    *<b>post:</b> shows all enemies and treasures in a level
   */
  public  void amountTreasureAndEnemy(){
    System.out.println("type the level you want it must be between level 1 and level 10");
    int level=lector.nextInt();
    if(level>10 || level<1){
      System.out.println("you must type an existing option");
    }
    else{
      level--;
      System.out.println(videoGame.allEnemy(level));
      System.out.println(videoGame.allTreasures(level));
    }
  }
      /**
    *countTreasure
    *asks the user for a treasure and looks for it how many treasures of that type are there in the game
    *<b>pre:</b> this option should have been chosen.<br>
    *<b>post:</b> shows the amount found of that treasure
   */

  public void countTreasure(){
    System.out.println("Enter the name of treasure");
    String name=lector.nextLine();
    System.out.println(videoGame.amountTreasure(name));
  }

      /**
    *countTypeEnemy
    *asks the user for the type of enemy, and looks up the amount of that enemy in the game
    *<b>pre:</b> this option should have been chosen.<br>
    *<b>post:</b> shows the amount found of that enemy
   */
  public void countTypeEnemy(){
    System.out.println("enter enemy type,1. ogre 2. abstract 3. boss 4. magic"); System.out.println("enter enemy type,1. ogre 2. abstract 3. boss 4. magic");
    int type=lector.nextInt();
    if(type<1 && type>4){
      System.out.println("you must enter one of the available options");
    }
    else{
      System.out.println(videoGame.amountTypeEnemy(type));
    }
    
    
  }
       /**
    *mostTreasure
    *shows the most repeated treasure in the entire game
    *<b>pre:</b> this option should have been chosen.<br>
    *<b>post:</b> shows the treasure name most repeated in the entire game
   */
  public void mostTreasure(){
    System.out.println(videoGame. mostTreasure());
  }

        /**
    *enemymostscore
    *shows the enemy with the highest score in the entire game
    *<b>pre:</b> this option should have been chosen.<br>
    *<b>post:</b> shows the name and the level the enemy with the highest score in the entire game
   */

   public void enemymostscore(){
    System.out.println(videoGame. enemyMostScore());
   }
        /**
    *consonantsEnemy
    *this method displays the number of consonants in enemy names throughout the game
    *<b>pre:</b> this option should have been chosen.<br>
    *<b>post:</b> shows the number of consonants in enemy names throughout the game
   */
   public void consonantsEnemy(){
    System.out.println(videoGame.amountConsonants());
   }
          /**
    * topPlayer
    *this method displays the top 5 players
    *<b>pre:</b> this option should have been chosen.<br>
    *<b>post:</b> shows the top 5 players
   */
   public void topPlayer(){
    System.out.println(videoGame.topPlayer());
   }
}
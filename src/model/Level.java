package model;
import model.TypeLevel;
import model.Enemy;
import model.Treasure;
//* */
public class Level{

   //relations

   private Enemy [] enemy;
   private Treasure [] treasure;
   private TypeLevel typeDifficult;

   //attribute
   private int id;
   private int points_level;
   
   

   //constructor
    /**
    *constructor
    *method that is called to create the object
    *<b>pre:</b> data had to be entered to create the constructor.<br>
    *<b>post:</b> create level
    *@param name  name of level
    *@param points_level score number to go to the next level
    *@return void
   */
   public Level(int id, int points_level) 
   {
    this.enemy= new Enemy[25];
    this.treasure= new Treasure[50]; 
    this.id = id;
    this.points_level = points_level;
    typeDifficult=null;

}

//methots
/**
 * @return name
 */
 public int getId() {
    return id;
 }


/**
 * 
 * @param name 
 */
  public void setId(int id) {
    this.id = id;
 }


/**
 * @return points_level
 */
 public int getPoints_level() {
    return points_level;
 }

/**
 * 
 * @param points_level
 */

  public void setPoints_level(int points_level) {
    this.points_level = points_level;
 }

/**
 * @return typeDifficult
 */
   public TypeLevel getTypeDifficult() {
   return typeDifficult;
}
/**
 * 
 * @param typeDifficult
 */
public void setTypeDifficult(TypeLevel typeDifficult) {
   this.typeDifficult = typeDifficult;
}

   /**
    *addTreasure
    *the method receives the treasure parameters to then create the object, a number of times that the user entered
    *<b>pre:</b> that the parameters have been entered and sent correctly.<br>
    *<b>post:</b> the method creates the treasure object
    *@param name name of treasure  
    *@param url url of trasure's image
    *@param score score of treasure
    *@param positionX position of treasure in x
    *@param positionY position of treasure in y
    *@param numberTreasure number of times in which this treasure is repeated
    *@return returns a boolean if the treasure was created or not
   */
public boolean addTreasure(String name, String url, int score, int positionX, int positionY, int numberTreasure ){
   boolean validation= true;
   
   int amount=availableTreasure();
 if(amount<numberTreasure){
    validation=false;
  }
  else if(amount>=numberTreasure){
   Treasure obj = new Treasure(name, url, score, positionX, positionY, numberTreasure);
   for(int h=0;h<numberTreasure;h++){
      validation=false;
      for(int i=0;i<50 && !validation ;i++){
         if(treasure[i]==null){
             treasure[i]=obj;
             validation=true;
         }
         
       }
   }
  }
  setTypeDifficult(difeneDificult());
  return validation;
 }
   /**
    *availableTreasure
    *the method how many stories spaces are there in the treasure array
    *<b>pre:</b> that there is a treasure arrangement<br>
    *<b>post:</b> drop how many spaces are there in treasures
    *@return number of spaces available in the treasures array
   */
public int availableTreasure(){
   int amount= 0;
  
   for(int i=0;i<50;i++){
     if(treasure[i]==null){
        amount++;
    }
   }


   return amount;
}

    /**
    *addEnemy
    *the method receives the parameters and creates the treasure object
    *<b>pre:</b> the parameters had to be received correctly.<br>
    *<b>post:</b> create the enemy object
    *@param name name of enemy  
    *@param option type of enemy
    *@param damage damage of enemy
    *@param score score of enemy
    *@param positionX position of enemy in x
    *@param positionY position of enemy in y
    *@return returns a boolean if the object was created or not
   */
public boolean addEnemy(String name, int option, int damage, int score, int positionX, int positionY ){
   boolean validation= true;
   Enemy obj= searchEnemy(name);
     
   if(obj!=null){
      validation=false;
   }
   else{
      boolean vali=availableEnemy();
      if(vali==true){
        obj = new Enemy(name, option, damage, score, positionX, positionY);
        vali=false;
        for(int i=0;i<20 && !vali ;i++){
          if(enemy[i]==null){
              enemy[i]=obj;
              vali=true;
              setTypeDifficult(difeneDificult());
          }
          
        }

      }
   }   
   return validation;
}
    /**
    *AvailableEnemy
    *see if there is room in the enemy array
    *<b>pre:</b> that there is the arrangements enemy.<br>
    *<b>post:</b> returns whether or not there is space
    *@return returns a boolean that says if there is space or not
   */
 public boolean availableEnemy(){
    boolean validation= true;
    if(enemy[24]!=null){
        validation=false;
    }
 
    return validation;
 }
    /**
    *searchEnemy
    *the method looks for a enemy with the name passed by parameter
    *<b>pre:</b> a string data must be entered.<br>
    *<b>post:</b> The method returns whether or not there is a user with that name
    *@param name name of enemy
    *@return Returns a enemy type data 
   */
 public Enemy searchEnemy(String name){
    Enemy obj=null;
    boolean vali= false;
     for(int i=0;i<25 && !vali ;i++){
        if(enemy[i]!=null && enemy[i].getName().equalsIgnoreCase(name)){
            obj=enemy[i];
            vali= true;
        }
     }

    return obj;
}


    /**
    *difeneDificult
    *the method defines the difficulty of the level according to the registered treasures and enemies
    *<b>pre:</b> the level object has been created.<br>
    *<b>post:</b> returns the difficulty of the level
    *@return returns the difficulty of the level
   */

 public TypeLevel difeneDificult(){
    TypeLevel dificult=null;
    int pointEnemy=0;
    int pointTreasure=0;
    
     if(treasure[0]==null){
         pointEnemy=0;
     }
     else{
        for(int i=0; i<25; i++){
         if(enemy[i]!=null){
            pointEnemy+= enemy[i].getScore();
         }
        }
    }
    
    if(enemy[0]==null){
        pointTreasure=0;
    }
    else{
       for(int i=0; i<25; i++){
         if(treasure[i]!=null){
            pointTreasure+= treasure[i].getScore();
         }
       }
   }
   
   if(pointTreasure+pointEnemy==0){
    dificult=null;
   }
   if(pointTreasure>pointEnemy){
    dificult= TypeLevel.EASY;
   }
   if(pointTreasure<pointEnemy){
    dificult=TypeLevel.HARD;
   }
   if(pointTreasure==pointEnemy){
    dificult=TypeLevel.MEDIUM;
   }

    return dificult;
 }
    /**
    *getEnemy
    *this method returns all enemies of this level
    *<b>pre:</b> game should have been created.<br>
    *<b>post:</b> returns enemies separated by commas
    *@return returns an array of strings with the enemies
   */
public String[] getEnemy() {
   int amount= 0;
   String [] enemyReport;
   for(int i=0;i<25;i++){
     if(enemy[i]!=null){
        amount++;
    }
   }
   if(amount==0){
      enemyReport=new String[1];
      enemyReport[0]="there are no enemies in this level";
   }
   else{
      enemyReport=new String[amount];
      for(int h=0;h<amount;h++){
         enemyReport[h]=enemy[h].getName();
     }
   

   }
 return enemyReport;
  }

    /**
    *getTreasure
    *this method returns all treasures of this level
    *<b>pre:</b> game should have been created.<br>
    *<b>post:</b> returns treasures separated by commas
    *@return returns an array of strings with the treasures
   */
  public String[] getTreasure(){
   String [] treasureReport;
   int amount=countTreasureRepit();
   

   if(amount==0){
      treasureReport=new String[1];
      treasureReport[0]="there are no treasures in this level";
   }
   else {
      treasureReport=new String[amount];
      for (int i=0; i < 50; i++) {
         if (treasure[i]!=null){
             int name = 0;
             for(int h = 0; h < amount; h++) {
                 if (treasure[i].getName().equalsIgnoreCase(treasureReport[h])){
                     name++;
                 }
                 if (name==0 && h==amount-1) {
                  boolean validation=false;
                  for(int t=0;t<amount && !validation ;t++){
                     if(treasureReport[t]==null){
                         treasureReport[t] = treasure[i].getName();
                         validation=true;
                     }
                 }
             }
         }
     }
   }
  }
  return treasureReport;
}
        /**
    *countTreasureRepit
    *this method releases the amount of treasures of a level
    *<b>pre:</b> the was created<br>
    *<b>post:</b> returns the amount of treasures in a level, without counting repetitions
    *@return returns a int with the amount of treasures in a level, without counting repetitions
   */
  public int countTreasureRepit(){
   int amount=0;
   for(int i =0; i<50 ;i++){
      if(treasure[i]!=null){
        i+=treasure[i].getNumberTreasure()-1;
        amount++;
      }
    }

   return amount;
  }
      /**
    *countTreasure
    *this method gets the amount of a treasure
    *<b>pre:</b> the name of the treasure must be entered.<br>
    *<b>post:</b> the amount of that treasure will be displayed
    *@param nameTreasure name of treasure
    *@return returns the amount of that treasure
   */
  public int countTreasure(String nameTreasure){
  int amount=0;
  boolean validation= false;
  for(int i=0; i<50 && !validation ;i++){
   if (treasure[i]!=null && treasure[i].getName().equalsIgnoreCase(nameTreasure) ){
      amount=treasure[i].getNumberTreasure()+amount;
      validation=true;
   }
  }

  return amount;
  }
      /**
    *countEnemy
    *this method gets the amount of a type enemy in the level
    *<b>pre:</b> the type of enemy should have been entered<br>
    *<b>post:</b> the number of enemies of that type on that level
    *@param enemyType type of enemy
    *@return returns the number of enemies of that type on that level
   */
  public int countEnemy(int enemyType ){
  int amount =0;
   
  for(int i=0; i<25;i++){
   if (enemy[i]!=null && enemy[i].typeEnemy()==enemyType ){
      amount++;
    }
  }
  return amount;
}


      /**
    *mostTresurePoint
    *this method, enter the repetitions of all the treasures
    *<b>pre:</b> videogame should have been created<br>
    *<b>post:</b> returns all repetitions of a level
    *@return returns ll repetitions of a level
   */
public int[] mostTresurePoint(){
 int [] treasurePoint;
 String [] treasureName;
 int amount =countTreasureRepit();

 if(amount==0){
   treasurePoint=new int[1];
   treasurePoint[0]=0;
}
else {
   treasurePoint=new int[amount];
   treasureName=new String[amount];

   for (int i=0; i < 50; i++) {
      if (treasure[i]!=null){
          int name = 0;
          for(int h = 0; h < amount; h++) {
              if (treasure[i].getName().equalsIgnoreCase(treasureName[h])){
                  name++;
              }
              if (name==0 && h==amount-1) {
               boolean validation=false;
               for(int t=0;t<amount && !validation ;t++){
                  if(treasureName[t]==null){
                     treasureName[t] = treasure[i].getName();
                     treasurePoint[t]= treasure[i].getNumberTreasure();
                     validation=true;
                  }
              }
              }
          }
      }
  }
}

 return treasurePoint;

}

   /**
    *enemyscore
    *get the name of the enemy with the highest score
    *<b>pre:</b> the video game must have been created<br>
    *<b>post:</b> returns the name of the enemy with the highest score
    *@return returns a string with the name of the enemy with the highest score
   */
public String enemyscore(){
   String enemyScore;
   int point=0;
   int position=0;
   if (enemy[0]==null){
      enemyScore="none";
   }
   else{
      for(int i=0;i<25;i++){
         if(enemy[i]!=null&& point>enemy[i].getScore()){
            point=enemy[i].getScore();
            position=i;
         }
      }
      enemyScore=enemy[position].getName();

   }
 



   return enemyScore;
}

   /**
    *enemyNameScore
    *this method looks for the score of the entered enemy
    *<b>pre:</b> a name must have been entered<br>
    *<b>post:</b> returns the point of this enemy
    *@param name name of enemy
    *@return returns a int with  the point of this enemy
   */
public int enemyNameScore(String name){
 int point=0;
 
  Enemy obj=searchEnemy(name);
  if(obj!=null){
   point= obj.getScore();
  }

 return point;
}
   /**
    *consonantsEnemy
    *this method gets the amount of consonants of the names of the enemies in the whole level
    *<b>pre:</b> the video game must have been created<br>
    *<b>post:</b> returns the amount of consonants of name of enemy
    *@return returns a int with  the amount of consonants of name of enemy
   */

public int consonantsEnemy(){
   int amount=0;
   char [] consonants={'q','w','r','t','y','p','s','d','f','g','h','j','k','l','z','x',
                       'c','v','b','n','m'};

   for(int i=0; i<25;i++){
      if(enemy[i]!=null){
         for(int h=0; h<enemy[i].getName().length();h++){
            for(int j=0;j<consonants.length;j++){
               if(enemy[i].getName().charAt(h)==consonants[j]){
                  amount++;
               }
            }
         }
      }
   }
   return amount;
}


}

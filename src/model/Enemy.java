package model;
import model.TypeEnemy;
//* */
public class Enemy{

    //relation
    private TypeEnemy typeEnemy;
    //attribute
    private String name;

    private int damage;
    private int score;
    private int positionX;
    private int positionY;


    //constructor 
    /**
    *constructor
    *method that is called to create the object
    *<b>pre:</b> data had to be entered to create the constructor.<br>
    *<b>post:</b> create enemy
    *@param name name of enemy  
    *@param typeEnemynumber type of enemy
    *@param damage damage of enemy
    *@param score score of enemy
    *@param positionX position of enemy in x
    *@param positionY position of enemy in y
    *@return void
   */
    public Enemy(String name, int typeEnemynumber, int damage, int score, int positionX, int positionY) {
        this.name = name;
        switch(typeEnemynumber){
            case 1:
            typeEnemy=TypeEnemy.OGRES;
            break;
            case 2:
            typeEnemy=TypeEnemy.ABSTRACT;
            break;
            case 3:
            typeEnemy=TypeEnemy.BOSS;
            break;
            case 4:
            typeEnemy=TypeEnemy.MAGIC;
            break;
        }
        this.damage = damage;
        this.score = score;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    //methots

      /**
    * typeEnemy
    *match the type of enemy with a number
    *<b>pre:</b> the enemy must have been created.<br>
    *<b>post:</b> returns relates the type of enemy to a number
    *@return return a int 
   */
 public int typeEnemy(){
    switch (typeEnemy) {
        case OGRES:
            return 1;
        case ABSTRACT:
            return 2;
        case BOSS:
            return 3;
        case MAGIC:
            return 4;
    }
    return 0;
 }   
    /**
 * @return name
 */
    public String getName() {
        return name;
    }

/**
 * 
 * @param name
 */
    public void setName(String name) {
        this.name = name;
    }


/**
 * @return damage
 */

    public int getDamage() {
        return damage;
    }

/**
 * 
 * @param damage
 */
    public void setDamage(int damage) {
        this.damage = damage;
    }

/**
 * @return score
 */
    public int getScore() {
        return score;
    }

/**
 * 
 * @param score
 */
    public void setScore(int score) {
        this.score = score;
    }
/**
 * @return positionX
 */

    public int getPositionX() {
        return positionX;
    }
/**
 * 
 * @param positionX
 */

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
/**
 * @return positionY
 */

    public int getPositionY() {
        return positionY;
    }

/**
 * 
 * @param positionY
 */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
/**
 * @return typeEnemy
 */
    public TypeEnemy getTypeEnemy() {
        return typeEnemy;
    }
/**
 * 
 * @param typeEnemy
 */
    public void setTypeEnemy(TypeEnemy typeEnemy) {
        this.typeEnemy = typeEnemy;
    }



    
    
}
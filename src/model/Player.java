package model;

import model.Level;
//* */
public class Player{


//attribute
private String nickname;
private String name;
private int score;
private int numberLifes;


//relat
private Level levelPlayer;

//constructor
        /**
    *constructor
    *method that is called to create the object
    *<b>pre:</b> data had to be entered to create the constructor.<br>
    *<b>post:</b> create player
    *@param nickname nickname of player
    *@param name name of player
    *@param levelPlayer level of Player
    *@return void
   */
public Player(String nickname, String name, Level levelPlayer) {
    this.nickname = nickname;
    this.name = name;
    score=10;
    numberLifes=5;
    this.levelPlayer=levelPlayer;
}



//methots
    /**
 * @return nickname
 */
public String getNickname() {
    return nickname;
}
/**
 * 
 * @param nickname
 */
public void setNickname(String nickname) {
    this.nickname = nickname;
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
 * @return numberLifes
 */
public int getNumberLifes() {
    return numberLifes;
}
/**
 * 
 * @param numberLifes
 */
public void setNumberLifes(int numberLifes) {
    this.numberLifes = numberLifes;
}

    /**
 * @return levelPlayer
 */

public Level getLevelPlayer() {
    return levelPlayer;
}

/**
 * 
 * @param levelPlayer
 */

public void setLevelPlayer(Level levelPlayer) {
    this.levelPlayer = levelPlayer;
}






















}
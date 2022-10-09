package model;
//* */
public class Treasure{


    //atributs 
    private String name;
    private String url;
    private int score;
    private int positionX;
    private int positionY;
    private int numberTreasure;

    // constructor
        /**
    *constructor
    *method that is called to create the object
    *<b>pre:</b> data had to be entered to create the constructor.<br>
    *<b>post:</b> create Treasure
    *@param name name of treasure  
    *@param url url of trasure's image
    *@param score score of treasure
    *@param positionX position of treasure in x
    *@param positionY position of treasure in y
    *@param numberTreasure number of times in which this treasure is repeated
    *@return void
   */
    public Treasure(String name, String url, int score, int positionX, int positionY, int numberTreasure) {
        this.name = name;
        this.url = url;
        this.score = score;
        this.positionX = positionX;
        this.positionY = positionY;
        this.numberTreasure = numberTreasure;
    }

    //methots
    
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
 * @return  url
 */
    public String getUrl() {
        return url;
    }
/**
 * 
 * @param url
 */
    public void setUrl(String url) {
        this.url = url;
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
 * @return numberTreasure
 */
    public int getNumberTreasure() {
        return numberTreasure;
    }
/**
 * 
 * @param  numberTreasure
 */
    public void setNumberTreasure(int numberTreasure) {
        this.numberTreasure = numberTreasure;
    }

/**
 * @return name+url+score+positionX+positionY+numbertreasure
 */
public String toString() {
    return "Treasure [name=" + name + ", url=" + url + ", score=" + score + ", positionX=" + positionX + ", positionY="
            + positionY + ", numberTreasure=" + numberTreasure + "]";
}
    
    

    
    
}
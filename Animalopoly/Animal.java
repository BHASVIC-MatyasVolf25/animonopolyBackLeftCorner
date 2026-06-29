import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animal extends Actor
{
    String name;
    int owner;
    int cost;
    int level;
    int visit;
    int baseVisit;
    int set;
    boolean free;
    /**
     * Act - do whatever the Animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Animal(String animalName, int animalCost, GreenfootImage icon,int set){
        setImage(icon);
        if(icon != null){ //the images are null currentlly becuase i didnt want to dowload 100 pngs of animals ; when they all have pngs we can remove this 
            GreenfootImage myImage = getImage();
            getImage().scale(myImage.getHeight()*1, myImage.getWidth()*1); //can be changed if image is too big or small
            //1 can be changed with a variable and passed into constructor so size can be controlled when adding animals
        }
            this.name = animalName;
        this.cost = animalCost;
        this.level = 0;
        this.visit = (int)this.cost/4;
        this.baseVisit = (int)this.cost/4;
        this.free = true;
        this.set = set;
        //when animal is added, it is added to a specific square using coords and given these characteristics through parameters
    }
    
    public int getCost(){
        return this.cost;
    }
    public int getVisit(){
        return this.visit;
    }
    public int getBaseVisit(){
        return baseVisit;
    }
    public String getName(){
        return this.name;
    }
    public boolean getFree(){
        return this.free;
    }
    public void setFree(boolean input){
        free = input;
    }
    public int getOwner(){
        return owner;
    }
    public int getLevel(){
        return level;
    }
    public void setOwner(int value){
        owner = value;
    }
    public void upgrade()
    {
        if(level != 3){
            level++;
            visit+= (int)this.cost/4;
    }
        //increases level of animal and increases visit by inital visit, cost is constant
        //this doesnt involve taking money from the players
    }
    public int getUpgradeCost(){
        return 0;
    }
    public int getSet(){
        return set;
    }
    public void isBought(){
        this.free = false;
        //if bought, call this so the animal is no longer free to buy
    }
    // on space on the board, info must be displayed and allow the player to buy animal if landed
    // new window must be displayed? instructions to press keys to buy animals
}

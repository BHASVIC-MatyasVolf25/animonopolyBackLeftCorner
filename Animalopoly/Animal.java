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
    int cost;
    int level;
    int visit;
    boolean free;
    /**
     * Act - do whatever the Animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Animal(String animalName, int animalCost, GreenfootImage icon){
        setImage(icon);
        GreenfootImage myImage = getImage();
        getImage().scale(myImage.getHeight()*1, myImage.getWidth()*1); //can be changed if image is too big or small
        //1 can be changed with a variable and passed into constructor so size can be controlled when adding animals
        this.name = animalName;
        this.cost = animalCost;
        this.level = 1;
        this.visit = (int)this.cost/4;
        this.free = true;
        //when animal is added, it is added to a specific square using coords and given these characteristics through parameters
    }
    
    public int getCost(){
        return this.cost;
    }
    public int getVisit(){
        return this.visit;
    }
    public String getName(){
        return this.name;
    }
    public boolean getFree(){
        return this.free;
    }
    
    public void upgrade()
    {
        level++;
        visit+= (int)this.cost/4;
        //increases level of animal and increases visit by inital visit, cost is constant
        //this doesnt involve taking money from the players
    }
    public void isBought(){
        this.free = false;
        //if bought, call this so the animal is no longer free to buy
    }
    // on space on the board, info must be displayed and allow the player to buy animal if landed
    // new window must be displayed? instructions to press keys to buy animals
}

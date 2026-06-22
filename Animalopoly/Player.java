import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String name;
    public Player(GreenfootImage Icon,String Name){
        this.name = Name;
        setImage(Icon);
        
        
    }
    public void act()
    {
        // Add your action code here.
    }
}

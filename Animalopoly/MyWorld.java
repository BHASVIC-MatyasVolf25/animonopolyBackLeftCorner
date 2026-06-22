import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    Player[] players; //array containing all the players
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        Player[] players;
        GreenfootImage image = new GreenfootImage("images\\thimble.jpg");
        image.scale(image.getWidth()/2,image.getHeight()/2);
        Actor player = new Player(image,"",0);
        addObject(player,100,100);
        GreenfootImage image2 = new GreenfootImage("images\\thimble.jpg");
        image2.scale(image2.getWidth()/2,image.getHeight()/2);
        Actor player2 = new Player(image2,"",1);
        addObject(player2,100,100);
        
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{

    /**
     * Constructor for objects of class World2.
     * 
     */
    PlayersButton p2,p3,p4;
    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        p2 = new PlayersButton("2 player");
        addObject(p2,200,450);
        p3 = new PlayersButton("3 player");
        addObject(p3,400,450);
        p4 = new PlayersButton("4 player");
        addObject(p4,600,450);
    }
    public void act(){
        if(Greenfoot.mouseClicked(p2)){
            Greenfoot.setWorld(new MyWorld(2));
        }
        if(Greenfoot.mouseClicked(p3)){
            Greenfoot.setWorld(new MyWorld(3));
        }
        if(Greenfoot.mouseClicked(p4)){
            Greenfoot.setWorld(new MyWorld(4));
        }
    }
}

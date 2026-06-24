import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimalMoreInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Display extends Actor
{
    /**
     * Act - do whatever the AnimalMoreInfo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //I stole this code from the cannon game, I hope jack doesnt slime me out
    //now i am writing this class it could porbably be used for differnt things
    //you could probably change the name and use it to display money or something
    GreenfootImage background;
    public Display(String text,int Width,int Height){
        background = new GreenfootImage(Width,Height);
        background.setColor(Color.BLACK);
        background.fillRect(0,0,Width,Height);
        setImage(background);
        GreenfootImage img = new GreenfootImage (background);
        img.setColor(Color.WHITE);
        img.drawString(text,0,30);
        setImage (img);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            World world = getWorld();
            world.removeObject(this);
        }
    }
}

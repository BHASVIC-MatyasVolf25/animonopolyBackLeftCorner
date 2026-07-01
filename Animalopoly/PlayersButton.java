import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayersButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayersButton extends Actor
{
    /**
     * Act - do whatever the PlayersButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage background = null;
    public PlayersButton(String text){
        background = new GreenfootImage(100,100);
        background.setColor(Color.BLACK);
        background.fillRect(0,0,75,75);
        setImage(background);
        GreenfootImage img = new GreenfootImage (background);
        img.setColor(Color.WHITE);
        img.drawString(text,0,30);
        img.scale(200,100);
        setImage (img);
    }
    public void act()
    {
            
    }
}

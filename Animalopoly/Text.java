import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Test wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage background = null;
    public Text(String text,int color){
        background = new GreenfootImage(105,100); //changed from 100 to 105 so full upgrade cost is shown
        //background.setColor(Color.BLACK);
        //background.fillRect(0,0,75,75);
        setImage(background);
        GreenfootImage img = new GreenfootImage (background);
        if(color == 1){
            img.setColor(Color.WHITE);
        }
        else{
            img.setColor(Color.BLACK);
        }
        img.drawString(text,0,30);
        img.scale(200,100);
        setImage (img);
    }
    public void act()
    {
        // Add your action code here.
    }
}

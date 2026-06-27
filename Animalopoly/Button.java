import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Button(String Image){
        GreenfootImage Img = new GreenfootImage(Image);
        setImage(Img);
        GreenfootImage myImage = getImage();
        getImage().scale(myImage.getWidth()*2, myImage.getHeight()*2);
    }
    public void act()
    {
        // Add your action code here.
    }
    public int roll(){
        int die1 = Greenfoot.getRandomNumber(6)+1;
        int die2 = Greenfoot.getRandomNumber(6)+1;
        Image dice1 = new Image("images//dice//" + die1 + ".png",true);
        Image dice2 = new Image("images//dice//" + die2 + ".png",true);
        World world = getWorld();
        world.addObject(dice1,300,300);
        world.addObject(dice2,400,300);
        return die1+die2;
    }
}

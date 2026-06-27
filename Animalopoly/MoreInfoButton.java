import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoreInfoButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoreInfoButton extends Actor
{
    /**
     * Act - do whatever the MoreInfoButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //this actor will be placed on every sqaure of the board and may be clicked
    //to create an actor "animal more info" which will show more info
    //these buttons will be invisible
    private int square;
    GreenfootImage Hitbox;
    private Animal LinkedAnimal;
    public MoreInfoButton(int square){
        this.square = square;
        Hitbox = new GreenfootImage(75,75);
        //Hitbox.setColor(Color.BLACK);
        //Hitbox.fillRect(0,0,75,75);
        //uncomment the 2 above in order to see hitboxe
        setImage(Hitbox);
    }
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        LinkedAnimal = world.getAnimal(square);
        if(Greenfoot.mouseClicked(this)){
            if (LinkedAnimal != null){
            Actor display = new AnimalCard(LinkedAnimal);
            world.addObject(display,572,245);
        }
    }
    }
}

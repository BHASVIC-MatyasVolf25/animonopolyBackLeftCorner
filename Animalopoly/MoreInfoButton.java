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
        //uncomment the 2 above in order to see hitboxes
        setImage(Hitbox);
    }
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        LinkedAnimal = world.getAnimal(square);
        String text = "             ";
        if(Greenfoot.mouseClicked(this)){
            if (LinkedAnimal != null){
            text = text + LinkedAnimal.getName() + "\n";
            text = text + "Buy Cost =     " + LinkedAnimal.getCost() + "\n";
            text = text + "Visit Cost =     " + LinkedAnimal.getVisit() + "\n";
            if(!LinkedAnimal.getFree()){
                text = text + "Owned by : " + LinkedAnimal.getOwner() + "\n";
            }
            else{
                text = text + "Nobody owns this";
            }
           } 
           Actor display = new Display(text,200,150);
            world.addObject(display,528,358);
    }
    }
}

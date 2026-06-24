import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimalMoreInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimalCard extends Actor
{
    /**
     * Act - do whatever the AnimalMoreInfo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Animal animal;
    boolean created = false;
    public AnimalCard(Animal animal){
        this.animal = animal;
        String Link = "images//Cards//Card" + animal.getSet() +".png";
        GreenfootImage image = new GreenfootImage(Link);
        image.scale(250,300);
        setImage(image);
        
    }
    public void createCard(){
        World world = getWorld();
        
        Text text1 = new Text(animal.getName(),1);
        world.addObject(text1,570,200);
        Text text2 = new Text("Cost:   "+animal.getCost(),0);
        world.addObject(text2,550,250);
        Text text3 = new Text("Visit :   "+animal.getVisit(),0);
        world.addObject(text3,550,300);
        if(animal.getFree()){
            Text text4 = new Text("Nobody Owns this animal",0);
            world.addObject(text4,550,350);
        }
        else{
            Text text4 = new Text(animal.getOwner() + "owns this animal",0);
            world.addObject(text4,550,350);
        }
        created = true;
    }
    public void act()
    {
        if (!created){
            createCard();
        }
        if(Greenfoot.mouseClicked(this)){
            World world = getWorld();
            world.removeObject(this);
        }
        
    }
}

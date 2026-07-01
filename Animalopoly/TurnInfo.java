import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TurnInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurnInfo extends Actor
{
    /**
     * Act - do whatever the TurnInfo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean Drawn=false;
    public TurnInfo(){
        GreenfootImage myImage = getImage();
        getImage().scale(myImage.getWidth()+ 55, myImage.getHeight());
        
        
        
    }
    public void DrawInfo(){
        MyWorld world = (MyWorld) getWorld();
        Player player =  world.getPlayer(world.getTurn());
        Text text = new Text(player.getName(),0);
        world.addObject(text,getX()+60,getY()-15);
        Text text2 = new Text("Money:  "+player.getMoney(),0);
        world.addObject(text2,getX()+35,getY());
        
        
    }
    public void act()
    {
        if(!Drawn){ //doing this means the procedure runs once when the actor enters the world
            DrawInfo();
            Drawn = true;
        }
    }
}

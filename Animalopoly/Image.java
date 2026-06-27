import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Image here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Image extends Actor
{
    /**
     * Act - do whatever the Image wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean timer;
    int delay=50;
    //I dont really know what i am doing with this one
    //You can make images that disapear after a while by putting true after the image
    public Image(String link,int size){
        GreenfootImage image = new GreenfootImage(link);
        getImage().scale(image.getWidth()*size, image.getHeight()*size);
        setImage(image);
    }
    public Image(String link){
        GreenfootImage image = new GreenfootImage(link);
        setImage(image);
    }
    public Image(String link,boolean timer){
        GreenfootImage image = new GreenfootImage(link);
        setImage(image);
        this.timer = timer;
    }
    public void act()
    {
        if(timer){
            if (delay < 0){ //this is not neciccary i just really wanted a fade out
                if (getImage().getTransparency() > 10){
                getImage().setTransparency(getImage().getTransparency()-10);
            }
            else{
                World world = getWorld();
                world.removeObject(this);
            }
        }
        else{
            delay--;
        }
        }
    }
}

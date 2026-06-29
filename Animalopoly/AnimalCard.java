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
        image.scale(235,290);
        setImage(image);
        
    }
    Text texts[];
    public void createCard(){
        //539 , 300
        World world = getWorld();
        texts = new Text[6];
        if(animal.getSet() == 8 || animal.getSet() == 5){
            Text text1 = new Text(animal.getName(),1);
            world.addObject(text1,getX()+35,getY()-100);
            texts[1]= text1;
            Text text5 = new Text("Level :  "+animal.getLevel(),1);
            world.addObject(text5,getX()+35,getY() -80);
        }
        else{
            Text text1 = new Text(animal.getName(),0);
            world.addObject(text1,getX()+35,getY()-100);
            texts[1]= text1;
            Text text5 = new Text("Level :  "+animal.getLevel(),0);
            world.addObject(text5,getX()+35,getY() -80);
        }
        Text text2 = new Text("Cost:   "+animal.getCost(),0);
        world.addObject(text2,getX()+35,getY()-50);
        texts[2]= text2;
        Text text3;
        int price = animal.getBaseVisit();
        for(int i = 0;i < 4;i++){
            text3 = new Text("Visit Level " + i + ":   "+price,0);
            world.addObject(text3,getX()+15,getY()+(i*20));
            price += animal.getCost()/4;
        }
        world.addObject(new Text("Upgrade cost:   "+0,0),getX()+15,getY()+100);
        if(animal.getFree()){
            Text text4 = new Text("Nobody Owns this animal",0);
            world.addObject(text4,getX(),getY()+120);
            texts[4]= text4;
        }
        else{
            int owner = animal.getOwner()+1;
            Text text4 = new Text("player " + owner + " owns this animal",0);
            texts[4]= text4;
            world.addObject(text4,getX(),getY()+120);
        }
        created = true;
    }
    public void act()
    {
        if (!created){
            createCard();
        }
        if(Greenfoot.mouseClicked(this)){
            Delete();
        }
        
    }
    public void Delete(){
            World world = getWorld();
            Actor text = getOneIntersectingObject(Text.class);
            while(text != null){
                text = getOneIntersectingObject(Text.class);
                if(text != null){
                    world.removeObject(text);
                }
            }
            world.removeObject(this);
            
    }
}

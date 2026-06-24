import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String name;
    int money;
    int square=0;
    int delay = 25;
    public Player(GreenfootImage Icon,String Name,int ID){
        this.name = Name;
        setImage(Icon);
        
        
    }
    public void act()
    {
        int boardX[] = {47,147,247,347,447,547,647,747,747,747,747,747,747,747,647,547,447,347,247,147,47,47,47,47,47,47,47};
        int boardY[] = {47,47,47,47,47,47,47,47,128,220,306,391,482,559,559,559,559,559,559,559,559,482,391,306,220,128,47};
        setLocation(boardX[square],boardY[square]);
    }
    public int getMoney(){
        return money;
    }
    public void addMoney(int Value){
        money = money + Value;
    }
     public void subMoney(int Value){
        money = money - Value;
    }
    public String getName(){
        return name;
    }
    public void MovePlayer(int Value){
        square += Value;
        if (square>25){ //change this value if the grid is larger than 25
            square = square - 26;
        }
        
    }
}

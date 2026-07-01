import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Player[] players = {}; //array containing all the players
    private Animal[] animals;
    private Button rollButton;
    private Button buyButton;
    private Button endButton;
    private Button upgradeButton;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        buyButton = new Button("images//Buttons//Buy.png");
        addObject(buyButton,175,437);
        
        rollButton = new Button("images//Buttons//Roll.png");
        addObject(rollButton,325,437);
        
        upgradeButton = new Button("images//Buttons//Upgrade.png");
        addObject(upgradeButton,475,437);
        endButton = new Button("images//Buttons//End.png");
        addObject(endButton,625,437);
        
        MakePlayers();
        MakeAnimals();
    }
    //did you guys know you could use act() in the worlds aswell?
    //anyways this will be the game loop
    boolean charged = false;
    int turn = 0; // variable stores 0,1 or 2 to show the players turn
    boolean rolled = false; //stores wether the player has rolled in their turn
    public void act(){
        AnimalCard display;
        if (!rolled && Greenfoot.mouseClicked(rollButton)){
            int roll = rollButton.roll();
            players[turn].MovePlayer(roll);
            rolled = true;
        }
        if(rolled && Greenfoot.mouseClicked(endButton)){ //just for testing remove this when the player needs to do things after their turn
            rolled = false;
            charged = false;
            turn++;
            if (turn == 3){
                turn = 0;
            }
            addObject(new TurnInfo(),253,241);
        }
        if(animals[players[turn].getSquare()] != null){
        if(rolled && Greenfoot.mouseClicked(buyButton)){
            Animal animal = animals[players[turn].getSquare()];
            if (animal.getFree() && players[turn].getMoney() > animal.getCost() ){
                animal.setOwner(turn);
                animal.setFree(false);
                players[turn].subMoney(animal.getCost());
                display = new AnimalCard(animal);
                addObject(display,572,245);
                addObject(new TurnInfo(),253,241);
            }
            
        }
           if(!charged &&rolled && !animals[players[turn].getSquare()].getFree()){
            Animal animal = animals[players[turn].getSquare()];
            players[turn].subMoney(animal.getVisit());
            players[animal.getOwner()].addMoney(animal.getVisit());
            addObject(new TurnInfo(),253,241);
            charged = true;
            //this will charge the player if they land on their own square
            //but it does not matter because the money will go back to them
        }
    
    Animal animal = animals[players[turn].getSquare()];
    if(rolled && animal.getOwner()==turn && Greenfoot.mouseClicked(upgradeButton)){
            if (animal.getLevel() != 3 && animal.getCost() < players[turn].getMoney()){
                players[turn].subMoney(animal.getCost());
                animals[players[turn].getSquare()].upgrade(); //levels up the animal
                addObject(new TurnInfo(),253,241);
                charged = true;
                display = new AnimalCard(animal);
                addObject(display,572,245);
            }
            //upgrades the animal, subtracts the cost from the player and then increasing the visit fee of the animal
            //not fully correct
        }
    }
    }
    private void MakeAnimals(){
        //I decided to make the color sets like monopoly but with biomes instead...
        //These animals can be changed later if you guys do not like them
        // and the prices must be changed becuase they are not very balanced
        animals = new Animal[26];
        animals[1] = new Animal("Meerkat",250,null,1); //savannah biome
        animals[2] = new Animal("Pangolin",275,null,1);
        animals[3] = new Animal("Elephant",300,null,1);
        animals[5] = new Animal("Sloth",300,null,2); // rainforest biome
        animals[6] = new Animal("Toucan",315,null,2);
        animals[7] = new Animal("Chimpanzee",350,null,2);
        animals[9] = new Animal("Sea Lion",365,null,3); //marine Biome
        animals[10] = new Animal("Giant Clam",380,null,3);
        animals[11] = new Animal("Yak",415,null,4); //like mongolia biome idk
        animals[12] = new Animal("Horse",430,null,4);
        animals[14] = new Animal("Pidgeon",445,null,5); // city
        animals[15] = new Animal("Fox",460,null,5); 
        animals[16] = new Animal("Eagle",485,null,6); //desert
        animals[17] = new Animal("Camel",500,null,6);
        animals[19] = new Animal("Deer",515,null,7); //england animals
        animals[20] = new Animal("Squirrel",560,null,7);
        animals[21] = new Animal("HedgeHog",590,null,7);
        animals[23] = new Animal("Giant squid",650,null,8); //deep sea
        animals[24] = new Animal("Anglerfish",675,null,8);
        animals[25] = new Animal("Blue whale",715,null,8);
        //squares 4 and 21 will be where the cards are placed , sqaure 13 is a skip a turn
    }
    public void MakePlayers(){
        GreenfootImage image = new GreenfootImage("images\\Batman.png");
        image.scale(120,120);
        Player player1 = new Player(image,"player 1",0);
        GreenfootImage image2 = new GreenfootImage("images\\Superman.png");
        image2.scale(120,120);
        Player player2 = new Player(image2,"player 2",1);
        GreenfootImage image3 = new GreenfootImage("images\\Cowboy.png");
        image3.scale(120,120);
        Player player3 = new Player(image3,"player 3",1);
        players = new Player[3];
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        addObject(player1,100,100);
        addObject(player2,100,100);
        addObject(player3,100,100);
    }
    public int getTurn(){
        return turn;
    }
    public Player getPlayer(int id){
        return players[id];
    }
    public Animal getAnimal(int square){
        return animals[square];
    }
}

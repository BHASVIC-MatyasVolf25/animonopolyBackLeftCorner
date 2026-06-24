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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        Player[] players;
        GreenfootImage image = new GreenfootImage("images\\thimble.jpg");
        image.scale(image.getWidth()/2,image.getHeight()/2);
        Player player = new Player(image,"",0);
        GreenfootImage image2 = new GreenfootImage("images\\hat.jpg");
        image2.scale(image2.getWidth()/2,image2.getHeight()/2);
        Player player2 = new Player(image2,"",1);
        players = new Player[2];
        players[0] = player;
        players[1] = player2;
        addObject(player,100,100);
        addObject(player2,100,100);
        MakeAnimals();
        PlaceButtons();
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
    public void PlaceButtons(){
        //arrays that contain the location of the squares
        int boardX[] = {47,147,247,347,447,547,647,747,747,747,747,747,747,747,647,547,447,347,247,147,47,47,47,47,47,47,47};
        int boardY[] = {47,47,47,47,47,47,47,47,128,220,306,391,482,559,559,559,559,559,559,559,559,482,391,306,220,128,47};
        for(int i=1;i<26;i++){
            if(animals[i] != null){
                Actor button = new MoreInfoButton(i);
                addObject(button,boardX[i],boardY[i]);
            }
            }
    }
    public Animal getAnimal(int square){
        return animals[square];
    }
}

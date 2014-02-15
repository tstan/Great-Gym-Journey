import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends Street
{
    /**
     * Constructor for objects of class Level1.
     * The addObject guarantees that the player will see the new enemy when they scroll right.
     * CODED BY JARED
     */
    public LevelOne(boolean haungs, int score, int level){
        super.haungs = haungs;          //Carry over boolean haungs
        super.level = level;            //Make sure the boss knows what level it is.
        super.endLoc = 105;             //The end of the level is "Distance: 105"
        prepare();
        addObject(new BurgerShack(), 1060, Greenfoot.getRandomNumber(250)); //Add BurgerShack so player knows what's coming
        //Places the scoreboards in the world
        scoreboard = new ScoreBoard(200,35,200,score,"Score: ");        //Add scoreboard
        addObject(scoreboard, 900, 17);
        distance = new ScoreBoard(200,35,200,moved,"Distance: ");       //Add distance counter
        addObject(distance, 870, 52);
    }

    /**
     * called when restarting onto this level
     * CODED BY JARED
     */
    public LevelOne(int score, int level){
        super.score = score;
        super.level = level;
        super.endLoc = 105;
        prepare();
        addObject(new BurgerShack(), 1060, Greenfoot.getRandomNumber(250));
        //Places the scoreboards in the world
        scoreboard = new ScoreBoard(200,35,200,score,"Score: ");
        addObject(scoreboard, 900, 17);
        distance = new ScoreBoard(200,35,200,moved,"Distance: ");
        addObject(distance, 870, 52);
    }

    /**
     * Spawns a wall as written in Street super class.
     */
    public void prepare(){
        super.spawnWall(level);  //Calls the superclass method 'spawnWall' which separates the player from the newest enemy.
    }

    /**
     * Act() will check for the scrolling of the player from Street.scrolling and set canScroll = true:
     * The distance is checked so the level will end at the proper distance:
     * Once the level ends, it will go to a boss.
     * CODED BY SPENCEr, JaReD
     */
    public void act()
    {   
        super.speedCheck();     //Sets scroll speed.
        super.score = score;    //Makes sure that the score is reset in Street.
        fightboss = false;      //We're not fighting a boss, are we?
        scrolling();            //Check if we're scrolling to the right.
        if(distance.getScore() <= endLoc){      //If distance is less than or equal to the end of level...
            if(distance.getScore() <= endLoc - 25){
                super.obstacleWall();       //Periodically spawn walls
                spawnIceCream();            //All levels have ice cream cannons.
            }
            if(canScroll == true){          //Add distance
                addDistance();
            }
            if(Greenfoot.getRandomNumber(10000) < 125 && canScroll == true && distance.getScore() <= endLoc - 25){
                EnemySpawn();               //Spawn enemies (method below)
            }
            RoadStripe();                   //Spawn street background stuff.
            Sidewalks();
        }
        if(distance.getScore() > endLoc){   //Short 'cutscene' till boss.
            Sidewalks();
            RoadStripe();
            super.lbCut(0);
        }
        if(super.isCentered() == true){     //Once the runner is set in the right spot...
            super.bkgMusic.stop();
            super.lbCut(1);
            BossBattle b1 = new BossBattle(haungs, super.scoreboard.getScore(), 1);  //Carry over haungs, score, level.
            Greenfoot.setWorld(b1); 
        }
    }

    /**
     * This level only spawns burgershacks.
     * CODED BY SPENCER
     */
    public void EnemySpawn(){
        addObject(new BurgerShack(), 960, Greenfoot.getRandomNumber(400));
    }
}

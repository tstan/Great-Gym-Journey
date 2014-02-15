import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwo extends Street
{
    /**
     * Constructor for objects of class Level2;
     * The addObject guarantees that the player will see the new enemy when they scroll right;
     * COMMENTS VERY SIMILAR TO LEVELONE CLASS.
     * CODED BY SPENCEr & JaRED
     */
    public LevelTwo(boolean haungs, int score, int level)
    {   
        super.haungs = haungs;          //Carry over boolean haungs
        super.score = score;            //Carry over score from level one.
        super.level = level;            //Make sure the boss knows what level it is.
        super.endLoc = 125;             //The end of the level is "Distance: 105"
        prepare();
        addObject(new PizzaParlor(), 1060, Greenfoot.getRandomNumber(250));
        //Places the scoreboards in the world
        scoreboard = new ScoreBoard(200,35,200,score,"Score: ");
        addObject(scoreboard, 900, 17);
        distance = new ScoreBoard(200,35,200,moved,"Distance: ");
        addObject(distance, 870, 52);
    }

    public LevelTwo(int score, int level){
        super.score = score;
        super.level = level;
        super.endLoc = 125;
        prepare();
        addObject(new PizzaParlor(), 1060, Greenfoot.getRandomNumber(250));
        //Places the scoreboards in the world
        scoreboard = new ScoreBoard(200,35,200,score,"Score: ");
        addObject(scoreboard, 900, 17);
        distance = new ScoreBoard(200,35,200,moved,"Distance: ");
        addObject(distance, 870, 52);
    }

    public void prepare(){
        super.spawnWall(level);  //Calls the superclass method 'spawnWall' which separates the player from the newest enemy.
    }

    /**
     * Act() will check for the scrolling of the player from Street.scrolling and set canScroll = true:
     * The distance is checked so the level will end at the proper distance:
     * Once the level ends, it will go to the 2nd boss battle.
     * CODED BY SPENCER & JARED
     */
    public void act()
    {
        super.speedCheck();     //Sets scroll speed.
        super.score = score;    //Makes sure that the score is reset in Street.
        fightboss = false;      //We're not fighting a boss, are we?
        creamSpawn = 9;         //Change chance to spawn ice cream cannons.
        scrolling();
        if(canScroll == true && distance.getScore() < endLoc){
            if(distance.getScore() <= endLoc - 25){
                super.obstacleWall();       //Periodically spawn walls
                spawnIceCream();            //All levels have ice cream cannons.
            }
            if(canScroll == true){          //Add distance
                addDistance();
            }
            if(Greenfoot.getRandomNumber(10000) < 110 && distance.getScore() <= endLoc - 25){
                EnemySpawn();           //Spawns Pizza Parlors
            }
            if(Greenfoot.getRandomNumber(10000) < 55 && distance.getScore() <= endLoc - 25){
                EnemySpawnTwo();        //Spawns Burger shacks
            }
            RoadStripe();
            Sidewalks();
        }
        if(distance.getScore() > endLoc){   //Short 'cutscene' till boss.
            Sidewalks();
            RoadStripe();
            super.lbCut(0);
        }
        if(super.isCentered() == true){     //Once the runner is set in the right spot...
            addDistance();
            super.bkgMusic.stop();
            super.lbCut(1);
            BossBattle b2 = new BossBattle(haungs, super.scoreboard.getScore(), 2);  //Carry over haungs, score, level.
            Greenfoot.setWorld(b2); 
        }
    }

    /**
     * This level only spawns PizzaParlors and BurgerShacks.
     * CODED BY SPENCER
     */
    public void EnemySpawn(){
        addObject(new PizzaParlor(), 960, Greenfoot.getRandomNumber(400));
    }

    public void EnemySpawnTwo(){
        addObject(new BurgerShack(), 960, Greenfoot.getRandomNumber(400));
    }
}
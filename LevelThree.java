import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelThree extends Street
{
    /**
     * Constructor for objects of class Level3.
     * The addObject guarantees that the player will see the new enemy when they scroll right.
     * COMMENTS VERY SIMILAR TO LEVELTWO CLASS.
     * CODED BY JARED
     */

    //Called when advancing to this level
    public LevelThree(boolean haungs, int score, int level)
    {
        super.haungs = haungs;      //Carry over boolean haungs
        super.score = score;        //Carry over score from level one.
        super.level = level;        //Make sure the boss knows what level it is.
        super.endLoc = 140;         //The end of the level is "Distance: 140"
        prepare();
        addObject(new TacoShop(), 1060, Greenfoot.getRandomNumber(250));
        //Places the scoreboards in the world
        scoreboard = new ScoreBoard(200,35,200,score,"Score: ");
        addObject(scoreboard, 900, 17);
        distance = new ScoreBoard(200,35,200,moved,"Distance: ");
        addObject(distance, 870, 52);
    }

    //Called when restarting on to this level
    /**
     * CODED BY JARED
     */
    public LevelThree(int score, int level){
        super.score = score;
        super.level = level;
        super.endLoc = 140;
        prepare();
        addObject(new BurgerShack(), 1060, Greenfoot.getRandomNumber(250));
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
     * Every act, Act() will check for the scrolling of the player from Street.scrolling and set canScroll = true,
     * if scrolling, the distance will begin to increase,
     * The distance is checked so the level will end at the proper distance,
     * Once the level ends, it will go to the final boss.
     * CODED BY SPENCER & JARED
     */
    public void act()
    {
        super.speedCheck();         //Sets Scroll speed.
        super.score = score;        //Makes sure that the score is reset in Street.
        fightboss = false;          //We're not fighting a boss, are we?
        creamSpawn = 10;            //Change chance to spawn ice cream cannons.
        scrolling();
        if(distance.getScore() < endLoc){
            if(distance.getScore() <= endLoc - 25){
                super.obstacleWall();       //Periodically spawn walls
                spawnIceCream();            //All levels have ice cream cannons.
            }
            if(canScroll == true){          //add distance
                addDistance();
                if(Greenfoot.getRandomNumber(10000) < 110 && canScroll == true && distance.getScore() <= endLoc - 25){
                    EnemySpawn();           //Spawn taco shops
                }
                if(Greenfoot.getRandomNumber(10000) < 27 && canScroll == true && distance.getScore() <= endLoc - 25){
                    EnemySpawnTwo();        //spawn burger shacks
                }
                if(Greenfoot.getRandomNumber(10000) < 55 && canScroll == true && distance.getScore() <= endLoc - 25){
                    EnemySpawnThree();      //spawn pizza parlors
                }
            }
            RoadStripe();
            Sidewalks();
        }
        if(distance.getScore() >= endLoc){  //Short 'cutscene' till boss.
            Sidewalks();
            RoadStripe();
            super.lbCut(0);
        }
        if(super.isCentered() == true){     //Once the runner is set in the right place...
            bkgMusic.stop();
            super.lbCut(1);
            BossBattle b3 = new BossBattle(haungs, super.scoreboard.getScore(), 3); //Carry over haungs, score, level.
            Greenfoot.setWorld(b3);
        }
    }

    /**
     * This level spawns TacoShops, BurgerShacks, and PizzaParlor.
     * CODED BY SPENCER
     */
    public void EnemySpawn(){
        addObject(new TacoShop(), 960, Greenfoot.getRandomNumber(400));
    }

    public void EnemySpawnTwo(){
        addObject(new BurgerShack(), 960, Greenfoot.getRandomNumber(400));
    }

    public void EnemySpawnThree(){
        addObject(new PizzaParlor(), 960, Greenfoot.getRandomNumber(400));
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CutScene1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CutScene2 extends World
{
    boolean haungs;
    public CSCar cscar;
    public CSRunner csrunner;
    public boolean timeToAddRunner = true;
    public CSRock csrock;
    public boolean timeToAddRock = true;
    /**
     * Constructor for objects of class CutScene1.
     * 
     */
    public CutScene2(boolean haungs) {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 500, 1, false);
        this.haungs = haungs;
        start();
        enemySpawn();
        gymSpawn();

        Text t = new Text();
        addObject(t, 480, 20);
    }

    public void act() {
        skipCutScene();
        csrunner = addRunner();
        throwingRock();
        startGame();
    }

    public void start() {
        CSIC csic = new CSIC();
        addObject(csic, 300, 290);
        cscar = new CSCar();
        addObject(cscar, 0, 290);
    }

    public CSRunner addRunner() {
        if (timeToAddRunner == true && cscar.getY() == 500) {
            csrunner = new CSRunner();
            addObject(csrunner, cscar.getX(), cscar.getY());
            timeToAddRunner = false;
        }
        return csrunner;
    }

    public void throwingRock() {
        if (timeToAddRock == true && csrunner != null && csrunner.getY() == 250) {
            csrock = new CSRock();
            addObject(csrock, csrunner.getX(), csrunner.getY());
            RockDust rdust = new RockDust();
            addObject(rdust, csrock.getX(), csrock.getY());
            timeToAddRock = false;
        }
    }

    public void enemySpawn() {
        CSPizzaParlor cspp = new CSPizzaParlor();
        addObject(cspp, 700, 85);
        CSBurgerShack csbs = new CSBurgerShack();
        addObject(csbs, 700, 250);
        CSTacoShop csts = new CSTacoShop();
        addObject(csts, 700, 415);
    }

    public void gymSpawn() {
        CSGym csg = new CSGym();
        addObject(csg, 960, 250);
    }

    public void skipCutScene() {
        if(Greenfoot.isKeyDown("space")) {
            //             haungs = false;
            LevelOne one = new LevelOne(haungs,0,1);
            Greenfoot.setWorld(one);
        }
    }

    public void startGame() {
        if (csrock != null && csrock.getX() >= 698) {
            //             haungs = true;
            LevelOne one = new LevelOne(haungs,0,1);
            Greenfoot.setWorld(one);
        }
    }
}

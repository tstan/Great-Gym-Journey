import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ALL CODE DONE BY JOSEPH KIMMMMMM
 */
public class CutScene1 extends World
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
    public CutScene1(boolean haungs) {
        super(960, 500, 1, false);
        this.haungs = haungs;
        start();
        enemySpawn();
        gymSpawn();
        Text t = new Text();        //Text displays for player.
        addObject(t, 480, 20);
    }

    /**
     * The cutscene is acted out.
     */
    public void act() {
        skipCutScene();
        csrunner = addRunner();
        throwingRock();
        startGame();
    }

    /**
     * Car is made at edge of screen.
     */
    public void start() {
        CSIC csic = new CSIC();
        addObject(csic, 300, 290);
        cscar = new CSCar();
        addObject(cscar, 0, 290);
    }

    /**
     * When the car crashes, the player comes out.
     */
    public CSRunner addRunner() {
        if (timeToAddRunner == true && cscar.getY() == 500) {
            csrunner = new CSRunner();
            addObject(csrunner, cscar.getX(), cscar.getY());
            timeToAddRunner = false;
        }
        return csrunner;
    }

    /**
     * Rock in cutscene is thrown to show player it can throw rocks.
     */
    public void throwingRock() {
        if (timeToAddRock == true && csrunner != null && csrunner.getY() == 250) {
            csrock = new CSRock();
            addObject(csrock, csrunner.getX(), csrunner.getY());
            RockDust rdust = new RockDust();
            addObject(rdust, csrock.getX(), csrock.getY());
            timeToAddRock = false;
        }
    }

    /**
     * Spawns enemy buildings that don't shoot.
     * CODED BY JOSEPH
     */
    public void enemySpawn() {
        CSPizzaParlor cspp = new CSPizzaParlor();
        addObject(cspp, 700, 85);
        CSBurgerShack csbs = new CSBurgerShack();
        addObject(csbs, 700, 250);
        CSTacoShop csts = new CSTacoShop();
        addObject(csts, 700, 415);
    }

    /**
     * Gym is seen at end of screen to also show player their goal.
     * CODED BY JOSEPH
     */
    public void gymSpawn() {
        CSGym csg = new CSGym();
        addObject(csg, 960, 250);
    }

    /**
     * The game lets the player skip the cutscene if they so desire.
     * CODED BY JOSEPH
     */
    public void skipCutScene() {
        if(Greenfoot.isKeyDown("space")) {
            Introductions1 one = new Introductions1(haungs);
            Greenfoot.setWorld(one);
        }
    }

    /**
     * After the rock hits a certain X-position, the world changes.
     * CODED BY JOSEPH
     */
    public void startGame() {
        if (csrock != null &&csrock.getX() >= 698) {
            Introductions1 one = new Introductions1(haungs);
            Greenfoot.setWorld(one);
        }
    }
}

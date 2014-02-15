import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ORIGINALLY CODED BY JACOB
 * Edits By: JARED, SPENCER
 */
public class BossBattle extends Street
{
    int tHits = 0;                  //Counts total hits on the boss.
    TacoHitBox tacohb;              //Three hitboxes are referenced for the world
    PizzaHitBox pizzahb;            //Pizza hitbox
    IceCreamHitBox icecreamhb;      //Ice cream hitbox
    BossTotalHP totalHP;            //Total boss Health points, refers to HP bar
    int i;                          //Used to time the shot of burgers
    int lvl;                        //Used for what level it is.
    private int delay;              //Used to spawn explosions.
    public int hBoxes;              //Used for checking how many hitboxes remain.
    public int botHits;             //Changes what tHits ends up equaling below.
    HitPoints health;               //HitPoints Bar introduced
    Explosion explosion;            //Explosion object introduced
    Boss boss;                      //Boss introduced
    int exp;                        //Tells the game when to spawn explosions.
    private GreenfootSound bkgMusic;
    BossHP bosshp;                  //Spawns for hit boxes, but remains transparent.
    /**
     * Constructor for objects of class BossBattle.
     * CODED BY JARED
     */
    public BossBattle()
    {
        super.haungs = false;
        removeObject(distance);
        //removeObject(scoreboard);
        //removeObject(runner);
        lvl = 3;
        prepare(3);
    }

    /**
     * CODED BY JARED
     */
    public BossBattle(boolean haungs, int score, int lvl)
    {
        super.haungs = haungs;
        super.score = score;
        super.level = lvl;
        this.lvl = lvl;
        removeObject(distance);
        prepare(lvl);
    }

    /**
     * CODED BY JACOB, SPENCER, & JARED
     */
    public void prepare(int lvl){
        super.bkgMusic.stop();  //Music below changes depending on the level that the player came from.
        if(lvl == 1){
            super.bkgMusic = new GreenfootSound("8-Bit Boss Battle 2.mp3"); //Music credited to EliteFerrex, http://www.newgrounds.com/audio/listen/269606
        }
        else if(lvl == 2){
            super.bkgMusic = new GreenfootSound("8-Bit Boss Battle 4.mp3"); //Music credited to EliteFerrex, http://www.newgrounds.com/audio/listen/367084
        }
        else if(lvl == 3){
            super.bkgMusic = new GreenfootSound("8-Bit Boss Battle 3.mp3"); //Music credited to EliteFerrex, http://www.newgrounds.com/audio/listen/295385
        }
        super.bkgMusic.playLoop();
        boss = new Boss(lvl);
        addObject(boss, 478, 111);
        //Following if statements occur depending on the level that the players come from.
        if(lvl >= 1){
            icecreamhb = new IceCreamHitBox();
            addObject(icecreamhb, 574, 144);
            hBoxes = 1;
            botHits = 1;
        }
        if(lvl >= 2){
            pizzahb = new PizzaHitBox();
            addObject(pizzahb, 473, 141);
            hBoxes = 2;
            botHits = 2;
        }
        if(lvl >= 3){
            tacohb = new TacoHitBox();
            addObject(tacohb, 383, 144);
            hBoxes = 3;         //hBoxes is a check to see if the boss still has any hit boxes left.
            botHits = 3;        //Second check for defeat of boss
        }
        totalHP = new BossTotalHP();    //Spawn image for boss's hp
        addObject(totalHP, 782, 31);
        removeObject(distance);         //Remove the Distance board
        scoreboard = new ScoreBoard(200,35,200,score,"Score: ");    //Spawn new scoreboard
        addObject(scoreboard,95,60);                                //Spawn board below player's HP.
        runner.setLocation(480, 375);
        runner.setImage("Guy Walking 1.png");
        setPaintOrder(Pointer.class, Explosion.class,Runner.class,Rock.class,Burger.class,IceCream.class, Pizza.class, Taco.class, Enemies.class, Boss.class);
    }

    /**
     * ...
     */
    public void act()
    {
        fightboss = true;               //The player is now fighting the boss/mini-boss.
        totalHP.decHealth(tHits);       //The boss decreases its health points bar depending on the total hits done to it.
        explosionsEverywhere(lvl);      //After the boss dies, explosions occur near the boss.
        removeObject(bosshp);           //removes the HP bars under hitboxes, not needed
    }

    /**
     * CODED BY JACOB, SPENCER
     */
    public int overallHits()
    {
        if(botHits == 1){           //In level 1, tHits equals the ice cream hitbox's hit points.
            tHits = icecreamhb.getHits();
        }
        else if(botHits == 2){      //In level 2, tHits equals the ice cream hitbox's and pizza hitbox's points.
            tHits = icecreamhb.getHits() + pizzahb.getHits();
        }
        else if(botHits >= 3){      //In level 3, tHits equals the ice cream, pizza, and taco hitbox's hit points.
            tHits = tacohb.getHits() + pizzahb.getHits() + icecreamhb.getHits();
        }
        return tHits;
    }

    /**
     * Spawns explosions on boss upon death.
     * CODED BY JACOB
     */
    public void spawnBossExplosion( Explosion explode, int x, int y)
    {
        addObject(explode, x, y);
    }

    /**
     * Spawn speed up power up.
     * CODED BY JACOB
     */
    public void spawnSpeedUp(SpeedUp su, int x, int y)
    {
        addObject(su, x, y+50);
    }

    /**
     * Spawn Attack speed power up.
     * CODED BY JACOB
     */
    public void spawnAttackUp(AttackUp attack, int x, int y)
    {
        addObject(attack, x, y+50);
    }

    /**
     * Spawn Health Sustenance.
     * CODED BY JACOB
     */
    public void spawnHealthUp(HealthUp healthy, int x, int y)
    {
        addObject(healthy, x, y+50);
    }

    /**
     * Ending of the boss fight depends on the level the player originally came from.
     * CODED BY SPENCER
     */
    public void bossEndGame(/**int explosions,**/ int lvl)
    {
        Greenfoot.playSound("bExplosion.wav");
        removeObject(totalHP);
        super.bkgMusic.stop();
        if(lvl <= 1){
            LevelTwo two = new LevelTwo(haungs, score, 2);
            Greenfoot.setWorld(two);        //Go to level 2.
        }
        else if(lvl == 2){
            LevelThree three = new LevelThree(haungs, score, 3);
            Greenfoot.setWorld(three);      //Go to level 3.
        }
        else if(lvl >= 3){
            explosionsEverywhere(lvl);      //Explosions occur from death of boss.
            exp = 1;
        }
    }

    /**
     * Explosions occur on the death of the boss;
     * Then the gym spawns where the boss was.
     * CODED BY JACOB, FRANKLIN, SPENCER
     */
    public void explosionsEverywhere(int lvl)
    {
        if ( exp == 1)
        {
            exp = 0;
            for(int i=0; i<1500; i++){
                delay++;
                if(delay%15 ==0){
                    Explosion bexp = new Explosion();
                    spawnBossExplosion( bexp , boss.getX()+Greenfoot.getRandomNumber(250)-125, boss.getY()+Greenfoot.getRandomNumber(250)-125);
                }
            }
            if(lvl >=3){
                Gym gym = new Gym(score);
                addObject(gym, boss.getX(), boss.getY());
                removeObject(boss);
            }
        }
    }

    /**
     * CODED BY JACOB
     */
    public void removeBossHP()
    {
        removeObject(bosshp);
    }

    /**
     * References Boss's X-position.
     * CODED BY SPENCER
     */
    public int bossX(){
        return boss.getX();
    }

    /**
     * References Boss's Y-position.
     * CODED BY SPENCER
     */
    public int bossY(){
        return boss.getY();
    }

    /**
     * Spawns a speech bubble for boss.
     * CODED BY SPENCER
     */
    public void spawnSpeech(SpeechBubble speech, int x, int y){
        addObject(speech, x, y);
    }
}

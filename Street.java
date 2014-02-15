import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * NOTE: CODED BY SPENCER, JARED, THEO, JACOB, FRANKLIN
 */
public class Street extends World
{
    //variable initialization
    public boolean haungs;                  //For haungs mode.
    public boolean fightboss;               //To test if player is fighting the boss.
    public boolean halfScore;               //Used for when player dies to half the score. *Removed, but may implement some other time*
    public boolean canScroll = false;       //used to check if the enemies and street objects should scroll.
    public boolean gymSpawn;                //Used for spawning the Gym once and no more than once.
    public boolean isEndless;               //Checks for the player selecting Arcade/Endless Mode.
    public boolean wall;                    //Spawns starting wall ONCE.
    public boolean cutscene = false;        //When true, causes a cutscene to occur.
    public boolean isCentered;              //Checks to see if the player is at the center (according to X) of the screen.
    private int wallTimer = 0;              //Timer that spawns a wall periodically.
    private int spawnRate;                  //Dictates the spawn rate of buildings when the player scrolls across the screen.
    public int i=0;                         //Multi-Purpose: Mainly for street objects
    public int r=125;                       //Used to make the street look like it still scrolls during a cutscene.
    public int moved;                       //Used to add to distance scoreboard
    public int moveDelay;                   //Delay used to show more accurate counting of distance.
    public int creamSpawn;                  //dictates spawn rate of ice cream cannons.
    public int endLoc;                      //Used in levels to mark the end of that level.
    public int scrollLoc;                   //Used to mark where the scrolling would begin/end for cutscene to boss.
    public int scrollSpeed;                 //Checks how fast the runner is and sets the scrolling in relation to that speed.
    public int score;                       //Carried through worlds, keeps track of player's score
    public int feet;                        //Was used to set player back at exact distance after death. *Removed*
    public int level;                       //Checks what level it is in subclass.
    public Runner runner;                   //Introduces Actor Runner as runner
    public GreenfootSound bkgMusic;         //Introduces a new sound, bkgMusic
    public ScoreBoard scoreboard;           //introduces picture ScoreBoard for scoreboard
    public ScoreBoard distance;             //Introduces ScoreBoard for distance
    /**
     * Constructor for objects of class Title.
     * SPENCER & JARED
     */
    public Street(){
        super(960, 500, 1, false);
        // Places the runner in the world
        runner = new Runner();
        addObject(runner, 473, 206);
        //Places the scoreboards in the world(used only for references, not actually seen)
        scoreboard = new ScoreBoard(200,35,0,score,"Score: ");
        addObject(scoreboard, 900, 17);
        distance = new ScoreBoard(200,35,0,moved,"Distance: ");
        addObject(distance, 870, 52);
        //Other stuff
        moveDelay = 1;
        scrollLoc = 480;
        scrollSpeed = runner.runnerSpeed();
        bkgMusic = new GreenfootSound("VideoDungeonBoss.mp3");
        bkgMusic.playLoop();
        setPaintOrder(ScoreBoard.class, Gym.class, Runner.class, Explosion.class, Food.class, Rock.class, HitPoints.class, Enemies.class, PowerUps.class,  Road.class);
    }

    /**
     * Called when advancing a level;
     * Carries over haungs mode, score, what level it is;
     * SPENCER & JARED
     */
    public Street(boolean haungs, int score, int level)
    {    
        // Create a new, unbounded world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 500, 1, false);
        // Places the runner in the world
        runner = new Runner();
        addObject(runner, 473, 206);
        //Places the scoreboards in the world(used only for references, not actually seen)
        scoreboard = new ScoreBoard(200,35,0,score,"Score: ");
        addObject(scoreboard, 900, 17);
        distance = new ScoreBoard(200,35,0,moved,"Distance: ");
        addObject(distance, 870, 52);
        //Other stuff
        moveDelay = 1;
        scrollLoc = 480;
        scrollSpeed = runner.runnerSpeed();
        bkgMusic = new GreenfootSound("VideoDungeonBoss.mp3");
        bkgMusic.playLoop();
        setPaintOrder(ScoreBoard.class, Gym.class, Runner.class, Explosion.class, Food.class, Rock.class, HitPoints.class, Enemies.class, PowerUps.class,  Road.class);
    }

    /**
     * Called when restarting from game over
     * SPENCER & JARED
     */
    public Street(int score, int level)
    {
        super(960, 500, 1, false);
        // Places the runner in the world
        runner = new Runner();
        addObject(runner, 473, 206);
        //Places the scoreboards in the world(used only for references, not actually seen)
        scoreboard = new ScoreBoard(120,35,200,0,"Score: ");
        addObject(scoreboard, 900, 17);
        distance = new ScoreBoard(200,35,200,moved,"Distance: ");
        addObject(distance, 870, 52);
        //Other Stuff
        moveDelay = 1;
        scrollLoc = 480;
        scrollSpeed = runner.runnerSpeed();
        bkgMusic = new GreenfootSound("VideoDungeonBoss.mp3");
        bkgMusic.playLoop();
        setPaintOrder(ScoreBoard.class, Gym.class, Runner.class, Explosion.class, Food.class, Rock.class, HitPoints.class, Enemies.class, PowerUps.class,  Road.class);
    }

    /**
     * Called for endless mode;
     * Note that isEndless is used in these parameters.
     * SPENCER & JARED
     */
    public Street(boolean haungs, int score, boolean isEndless)
    {
        super(960, 500, 1, false);
        //Places the runner in the world
        runner = new Runner();
        addObject(runner, 473, 206);
        this.isEndless = isEndless;
        spawnRate = 75;
        //Places the scoreboards in the world(used only for references, not actually seen)
        scoreboard = new ScoreBoard(120,35,200,score,"Score: ");
        addObject(scoreboard, 900, 17);
        distance = new ScoreBoard(200,35,200,moved,"Distance: ");
        addObject(distance, 870, 52);
        //Other Stuff
        moveDelay = 1;
        scrollLoc = 480;
        scrollSpeed = runner.runnerSpeed();
        bkgMusic = new GreenfootSound("VideoDungeonBoss.mp3");
        bkgMusic.playLoop();
    }

    /**
     * Spawns a Wall at beginning of level
     * SPENCER
     */
    public void spawnWall(int level){
        fightboss = false;
        for(int i=0;i<8;i++){
            addObject(new IntroWall(level, true), getWidth()-50, 25 + (i*65));
        }
        spawnRate = 75;
        creamSpawn = 8;
    }

    /**
     * Spawns a wall at periodic times in a level.
     * JARED
     */
    public void obstacleWall(){
        if((wallTimer >= 400 + (Greenfoot.getRandomNumber(40)-20))&& canScroll == true){
            for(int i=0;i<7;i++){
                addObject(new IntroWall(level, false), getWidth()+50, Greenfoot.getRandomNumber(100)+Greenfoot.getRandomNumber(100) + (i*65));
            }
            wallTimer = 0;
        }
        else if(canScroll == true){
            wallTimer++;
        }
        wall = false;
    }

    public void act(){
        if(canScroll == true /**&& distance.getScore() >= 30**/){
            obstacleWall();
        }
        haungsMode();
        scrolling();
        Sidewalks();
        RoadStripe();
        if(isEndless==true){
            EnemySpawn();
            spawnIceCream();
        }
        else{
            spawnIceCream();
        }
        speedCheck();
    }

    /**
     * method for getting the X-location of the runner for use in other classes
     * JARED
     */
    public int XLocation(){
        return runner.getX();
    }

    /**
     * method for getting the Y-location of the runner for use in other classes
     * JARED
     */
    public int YLocation(){
        return runner.getY();
    }

    /**
     * JARED
     */
    public boolean isCentered(){
        return runner.isCentered;
    }

    /**
     * Returns how many hits the runner has taken.
     * JARED
     */
    public int getHits()
    {
        return runner.getHits();
    }

    /**
     * Used to spawn ice Cream cannons randomly
     * SPENCER
     */
    public void spawnIceCream()
    {
        if(distance.getScore() > 14)
        {
            if (Greenfoot.getRandomNumber(1000) <= creamSpawn)
            {
                int random = Greenfoot.getRandomNumber(100);
                addObject(new IceCreamCannon(), -5, (Greenfoot.getRandomNumber(250) + 125 ));
            }
        }
    }

    /**
     * Main method for spawning enemies into the subclasses of Street and Street class
     * SPENCER
     */
    public void EnemySpawn()
    {
        spawnIceCream();
        if(canScroll == true){
            addDistance();
            if (Greenfoot.getRandomNumber(10000)<=spawnRate)
            {
                addObject(new BurgerShack(), 960, Greenfoot.getRandomNumber(getHeight()-50));
            }
            if (Greenfoot.getRandomNumber(10000)<=spawnRate)
            {
                addObject(new PizzaParlor(), 960, Greenfoot.getRandomNumber(getHeight()-50));
            }
            if(distance.getScore() > 100){
                if(Greenfoot.getRandomNumber(10000)<=spawnRate){
                    addObject(new TacoShop(), 960, Greenfoot.getRandomNumber(getHeight()-50));
                }
            }
            if(distance.getScore() >= 200)
            {
                spawnRate = 100;
                creamSpawn = 10;
            }
        }
    }

    /**
     * Used in non-endless modes to add distance to display how far the player has gone.
     * SPENCER & JARED
     */
    public void addDistance()
    {
        if(canScroll == true)
        {
            if((Greenfoot.isKeyDown("left") != true || Greenfoot.isKeyDown("a") != true))
            {
                if(moveDelay%20 == 0)
                {
                    moved = 1;
                    moveDelay = 1;
                }
                else
                {
                    moveDelay += 1;
                    distance.addScore(moved);
                    moved = 0;
                }
            }
        }
    }

    /**
     *Method for spawning sidewalks.
     *JARED
     */
    public void Sidewalks(){
        //if the runner is in the left 2/3 of the screen, 
        if(canScroll == true || cutscene == true){
            if(i%100==0){
                //adds a new upper sidewalk line on the right side of the screen
                Sidewalk sidewalk = new Sidewalk();
                addObject(sidewalk, getWidth()-5, 144);
                setPaintOrder(ScoreBoard.class, Gym.class, Runner.class, Explosion.class, Food.class, Rock.class, HitPoints.class, Enemies.class, PowerUps.class,  Road.class);
                i+= 1;
            }
            else if((i+50)%100==0){
                //adds a new lower sidewalk line on the right side of the screen
                Sidewalk sidewalk2 = new Sidewalk();
                addObject(sidewalk2, getWidth()-5, 353);
                setPaintOrder(ScoreBoard.class, Gym.class, Runner.class, Explosion.class, Food.class, Rock.class, HitPoints.class, Enemies.class, PowerUps.class,  Road.class);
                i+=1;
            }else{
                i++;
            }
        }
    }

    /**
     * Method for spawning road stripes
     * JARED
     */
    public void RoadStripe(){
        if(canScroll == true || cutscene == true){
            if(r%150==0){
                //adds a new road stripe on the right side of the screen
                RoadStripe roadstripe = new RoadStripe();
                addObject(roadstripe, getWidth()-5, 250);
                setPaintOrder(ScoreBoard.class, Gym.class, Runner.class, Explosion.class, Food.class, Rock.class, HitPoints.class, Enemies.class, PowerUps.class,  Road.class);
                r = 0;
                r++;
            }
            else{
                r++;
            }
        }
    }

    /**
     * Sets canScroll to true when the player's avatar is in the correct region of the screen and moving forward.
     * JARED
     */
    public void scrolling(){
        if(XLocation() > getWidth() - scrollLoc && (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))){
            canScroll = true;
        }
        else{
            canScroll = false;
        }
    }

    /**
     * Takes away player control when the player is done with a level.
     * JARED
     */
    public void lbCut(int done){
        if(done == 0){
            runner.canControl = false;
            cutscene = true;
        }
        else if(done == 1){
            runner.canControl = true;
            cutscene = false;
        }
    }

    /**
     * Method for going to game over screen.
     * JARED
     */
    public void endGame()
    {
        bkgMusic.stop();
        GameOverScreen go = new GameOverScreen(scoreboard.getScore(), level);
        Greenfoot.setWorld(go);   
    }

    /**
     * Used to make scrolling speed of the background match that of the player;
     * Useful with the player has a speed power up.
     * JARED
     */
    public void speedCheck(){
        int checkSpeed = runner.speed;
        if(scrollSpeed != checkSpeed){
            scrollSpeed = checkSpeed;
        }
    }

    /**
     * Adds score to the scoreboard.
     * SPENCER
     */
    public void addScore(int pts)
    {
        scoreboard.addScore(pts);
    }

    /**
     * Used to spawn the HitPoint bars.
     * SPENCER
     */
    public void spawnHitPoints(int x, int y, HitPoints health)
    {
        addObject(health, x, y+60);
    }

    /**
     * Used to spawn the explosions of enemies.
     * SPENCER
     */
    public void spawnExplosion(Explosion explode, int x, int y)
    {
        addObject(explode, x, y+5);
    }

    /**
     * Used to spawn an animation for getting hit by food.
     * SPENCER
     */
    public void spawnFoodHit(FoodHit hit, int x, int y)
    {
        addObject(hit, x, y);
    }

    /**
     * Used to spawn rock dust behind rocks.
     * SPENCER
     */
    public void spawnRockDust(RockDust dust, int x, int y)
    {
        addObject(dust, x, y);
    }

    /**
     * Used to spawn Speedy Energy Drinks.
     * SPENCER
     */
    public void spawnSpeedUp(SpeedUp su, int x, int y)
    {
        addObject(su, x, y);
    }

    /**
     * Used to spawn Attack Speed Spinach.
     * SPENCER
     */
    public void spawnAttackUp(AttackUp attack, int x, int y)
    {
        addObject(attack, x, y);
    }

    /**
     * Used to spawn Healthy Diet Pills.
     * SPENCER
     */
    public void spawnHealthUp(HealthUp healthy, int x, int y)
    {
        addObject(healthy, x, y);
    }

    /**
     * Used to spawn a Pointer Arrow.
     * SPENCER
     */
    public void spawnPointer(Pointer point, int x, int y){
        addObject(point, x, y);
    }

    /**
     * Implements haungs mode if player decides they want to.
     * SPENCER
     */
    public void haungsMode()
    {
        if(Greenfoot.isKeyDown("h") && Greenfoot.isKeyDown("g")){
            haungs = true;
        }
    }

    /**
     * Used to return score of scoreboard.
     * SPENCER
     */
    public int getScore(){
        return scoreboard.getScore();
    }
}   


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Runner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Runner extends SmoothMover
{
    int hPoints;
    int nHits;
    int atkdelay = 30;
    int speed;
    int normSpeed;
    int p = 0;
    int sdelay = 30;
    int sdelay1 = 30;
    private int i;
    boolean spawned;
    boolean facingRight;
    public boolean canControl = true;
    public boolean isCentered = false;
    Street street;
    HitPoints health;
    int aUpDecay;
    int sUpDecay;
    int attspeed = 30;
    int timer = 66;
    boolean justHit;
    GreenfootImage flash;
    /**
     * CODED BY SPENCER, JARED, JACOB, THEO,...
     */
    public Runner(){
        spawned = true;
        street = (Street) getWorld();
        i = 0;
        normSpeed = 2;
        speed = normSpeed;
    }

    public void act() 
    {
        spawnHP();
        bindPlayer();
        speedUp();
        attack();
        collision();
        wallblock();
        healthUp();
        attackUp();
        superUp();
        atkdelay++;
        if(!(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("s")||Greenfoot.isKeyDown("w"))){
            gotHit();
        }
    }    

    /**
     * CODED BY SPENCER
     */
    public void wallblock(){
        Actor enemies = getOneIntersectingObject(Enemies.class);
        Actor wall = getOneObjectAtOffset(15, 0, IntroWall.class);
        if(canControl != true){
            center();
        }
        else{
            if ((enemies == null || wall == null)){
                move();
            }
            if (enemies != null || wall != null){
                move(-6);
            }
        }
    }

    /**
     * CODED BY JARED
     */
    public void center(){
        int xpos = getX();
        int ypos = getY();
        if(getX() < 480){
            xpos += 1;
        }
        else if(getX() > 480){
            xpos -= 1;
        }
        else if(getY() < 375){
            ypos += 1;
        }
        else if(getY() > 375){
            ypos -= 1;
        }
        else if(getY() == 375 && getX() == 480){
            isCentered = true;
        }
        setLocation(xpos, ypos);
        animate();
    }

    /**
     * CODED BY SPENCER
     */
    private void collision() {
        Food food = (Food) getOneIntersectingObject(Food.class);
        Pizza pizza = (Pizza) getOneIntersectingObject(Pizza.class);
        Burger burger = (Burger) getOneIntersectingObject(Burger.class);
        if( food != null ) {
            Greenfoot.playSound("grunt.wav");
            Street s = (Street) getWorld();
            s.spawnFoodHit(new FoodHit(), food.getX(), food.getY());
            if((pizza != null || burger != null) && s.haungs != true){
                health();
            }
            s.removeObject(food);
            if(s.haungs != true){
                health();
            }
        }
    }

    /**
     * CODED BY SPENCER
     */
    public void gotHit(){
        flash = new GreenfootImage("FlashHit.png");
        if(justHit == true){
            timer -= 1;
            if((4+timer)%8 == 0){
                setImage(flash);
            }
            else if(timer < 1){
                timer = 66;
                justHit = false;
            }
        }
    }

    /**
     * CODED OVERWHELMINGLY BY JACOB
     */
    public void animate(){
        GreenfootImage walk1 = new GreenfootImage("Guy Walking 1.png");
        GreenfootImage walk2 = new GreenfootImage("Guy Walking 2.png");
        GreenfootImage walk3 = new GreenfootImage("Guy Walking 3.png");
        GreenfootImage bwalk1 = new GreenfootImage("Guy Walking -1.png");
        GreenfootImage bwalk2 = new GreenfootImage("Guy Walking -2.png");
        GreenfootImage bwalk3 = new GreenfootImage("Guy Walking -3.png");
        GreenfootImage mj1 = new GreenfootImage("MJ1.png");
        GreenfootImage mj2 = new GreenfootImage("MJ2.png");
        GreenfootImage mj3 = new GreenfootImage("MJ3.png");
        GreenfootImage fwalk1 = new GreenfootImage("Guy Fat 1.png");
        GreenfootImage fwalk2 = new GreenfootImage("Guy Fat 2.png");
        GreenfootImage fwalk3 = new GreenfootImage("Guy Fat 3.png");
        GreenfootImage bfwalk1 = new GreenfootImage("Guy Fat -1.png");
        GreenfootImage bfwalk2 = new GreenfootImage("Guy Fat -2.png");
        GreenfootImage bfwalk3 = new GreenfootImage("Guy Fat -3.png");
        GreenfootImage vfwalk1 = new GreenfootImage("Guy VFat 1.png");
        GreenfootImage vfwalk2 = new GreenfootImage("Guy VFat 2.png");
        GreenfootImage vfwalk3 = new GreenfootImage("Guy VFat 3.png");
        GreenfootImage bvfwalk1 = new GreenfootImage("Guy VFat -1.png");
        GreenfootImage bvfwalk2 = new GreenfootImage("Guy VFat -2.png");
        GreenfootImage bvfwalk3 = new GreenfootImage("Guy VFat -3.png");
        walk1.scale(35,40);
        walk2.scale(33,39);
        walk3.scale(33,39);
        bwalk1.scale(35,40);
        bwalk2.scale(35,40);
        bwalk3.scale(35,40);
        fwalk1.scale(35,40);
        fwalk2.scale(33,39);
        fwalk3.scale(33,39);
        bfwalk1.scale(35,40);
        bfwalk2.scale(35,40);
        bfwalk3.scale(35,40);
        vfwalk1.scale(35,40);
        vfwalk2.scale(33,39);
        vfwalk3.scale(33,39);
        bvfwalk1.scale(35,40);
        bvfwalk2.scale(35,40);
        bvfwalk3.scale(35,40);
        mj1.scale(25,40);
        mj2.scale(25,39);
        mj3.scale(25,39);

        if( getHits() == 0 || getHits() == 1 || getHits() == 2 || getHits() == 3)
        {
            if((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")))
            {
                p++;
                facingRight = true;
                if(p == 1){
                    setImage(mj1);
                }
                else if(p == 8){
                    setImage(mj2);
                    stepSound();
                }
                else if(p == 16){
                    setImage(mj1);
                }
                else if(p == 24){
                    setImage(mj3);
                    stepSound();
                }
                else if(p == 32){
                    p=0;
                }
            }
            else if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) || canControl != true){
                p++;
                facingRight = true;
                if(p == 1){
                    setImage(walk1);
                }
                else if(p == 8){
                    setImage(walk2);
                    stepSound();
                }
                else if(p == 16){
                    setImage(walk1);
                }
                else if(p == 24){
                    setImage(walk3);
                    stepSound();
                }
                else if(p == 32){
                    p=0;
                }
            }

            else if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
                p++;
                facingRight = false;
                if(p == 1){
                    setImage(bwalk1);
                }
                else if( p == 8 ){
                    setImage(bwalk2);
                    stepSound();
                }
                else if( p == 16 ){
                    setImage(bwalk1);
                }
                else if( p == 24 ){
                    setImage(bwalk3);
                    stepSound();
                }                
                else if(p == 32){
                    p=0;
                }
            }
            else if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s")){
                p++;
                if(facingRight == false){
                    if(p == 1){
                        setImage(bwalk1);
                    }
                    else if( p == 8 ){
                        setImage(bwalk2);
                        stepSound();
                    }
                    else if( p == 16 ){
                        setImage(bwalk1);
                    }
                    else if( p == 24 ){
                        setImage(bwalk3);
                        stepSound();
                    }                
                    else if(p == 32){
                        p=0;
                    }
                }
                else if(facingRight == true){
                    if(p == 1){
                        setImage(walk1);
                    }
                    else if( p == 8 ){
                        setImage(walk2);
                        stepSound();
                    }
                    else if( p == 16 ){
                        setImage(walk1);
                    }
                    else if( p == 24 ){
                        setImage(walk3);
                        stepSound();
                    }                
                    else if(p == 32){
                        p=0;
                    }
                }
            }

            else{
                if(facingRight == true){
                    setImage(walk1);
                }
                else if(facingRight == false){
                    setImage(bwalk1);
                }
            }
            gotHit();
        }
        else if( getHits() == 4 || getHits() == 5 || getHits() == 6 || getHits() == 7)
        {
            if((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")))
            {
                p++;
                facingRight = true;
                if(p == 1){
                    setImage(mj1);
                }
                else if(p == 8){
                    setImage(mj2);
                    stepSound();
                }
                else if(p == 16){
                    setImage(mj1);
                }
                else if(p == 24){
                    setImage(mj3);
                    stepSound();
                }
                else if(p == 32){
                    p=0;
                }
            }
            else if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) || canControl != true){
                p++;
                facingRight = true;
                if(p == 1){
                    setImage(fwalk1);
                }
                else if(p == 8){
                    setImage(fwalk2);
                    stepSound();
                }
                else if(p == 16){
                    setImage(fwalk1);
                }
                else if(p == 24){
                    setImage(fwalk3);
                    stepSound();
                }
                else if(p == 32){
                    p=0;
                }
            }

            else if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
                p++;
                facingRight = false;
                if(p == 1){
                    setImage(bfwalk1);
                }
                else if( p == 8 ){
                    setImage(bfwalk2);
                    stepSound();
                }
                else if( p == 16 ){
                    setImage(bfwalk1);
                }
                else if( p == 24 ){
                    setImage(bfwalk3);
                    stepSound();
                }                
                else if(p == 32){
                    p=0;
                }
            }
            else if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s")){
                p++;
                if(facingRight == false){
                    if(p == 1){
                        setImage(bfwalk1);
                    }
                    else if( p == 8 ){
                        setImage(bfwalk2);
                        stepSound();
                    }
                    else if( p == 16 ){
                        setImage(bfwalk1);
                    }
                    else if( p == 24 ){
                        setImage(bfwalk3);
                        stepSound();
                    }                
                    else if(p == 32){
                        p=0;
                    }
                }
                else if(facingRight == true){
                    if(p == 1){
                        setImage(fwalk1);
                    }
                    else if( p == 8 ){
                        setImage(fwalk2);
                        stepSound();
                    }
                    else if( p == 16 ){
                        setImage(fwalk1);
                    }
                    else if( p == 24 ){
                        setImage(fwalk3);
                        stepSound();
                    }                
                    else if(p == 32){
                        p=0;
                    }
                }
            }

            else{
                if(facingRight == true){
                    setImage(fwalk1);
                }
                else if(facingRight == false){
                    setImage(bfwalk1);
                }
            }
            gotHit();
        }
        else if( getHits() == 8 || getHits() == 9 || getHits() == 10)
        {
            if((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")))
            {
                p++;
                facingRight = true;
                if(p == 1){
                    setImage(mj1);
                }
                else if(p == 8){
                    setImage(mj2);
                    stepSound();
                }
                else if(p == 16){
                    setImage(mj1);
                }
                else if(p == 24){
                    setImage(mj3);
                    stepSound();
                }
                else if(p == 32){
                    p=0;
                }
            }
            else if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) || canControl != true){
                p++;
                facingRight = true;
                if(p == 1){
                    setImage(vfwalk1);
                }
                else if(p == 8){
                    setImage(vfwalk2);
                    stepSound();
                }
                else if(p == 16){
                    setImage(vfwalk1);
                }
                else if(p == 24){
                    setImage(vfwalk3);
                    stepSound();
                }
                else if(p == 32){
                    p=0;
                }
            }

            else if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
                p++;
                facingRight = false;
                if(p == 1){
                    setImage(bvfwalk1);
                }
                else if( p == 8 ){
                    setImage(bvfwalk2);
                    stepSound();
                }
                else if( p == 16 ){
                    setImage(bvfwalk1);
                }
                else if( p == 24 ){
                    setImage(bvfwalk3);
                    stepSound();
                }                
                else if(p == 32){
                    p=0;
                }
            }
            else if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s")){
                p++;
                if(facingRight == false){
                    if(p == 1){
                        setImage(bvfwalk1);
                    }
                    else if( p == 8 ){
                        setImage(bvfwalk2);
                        stepSound();
                    }
                    else if( p == 16 ){
                        setImage(bvfwalk1);
                    }
                    else if( p == 24 ){
                        setImage(bvfwalk3);
                        stepSound();
                    }                
                    else if(p == 32){
                        p=0;
                    }
                }
                else if(facingRight == true){
                    if(p == 1){
                        setImage(vfwalk1);
                    }
                    else if( p == 8 ){
                        setImage(vfwalk2);
                        stepSound();
                    }
                    else if( p == 16 ){
                        setImage(vfwalk1);
                    }
                    else if( p == 24 ){
                        setImage(vfwalk3);
                        stepSound();
                    }                
                    else if(p == 32){
                        p=0;
                    }
                }
            }

            else{
                if(facingRight == true){
                    setImage(vfwalk1);
                }
                else if(facingRight == false){
                    setImage(bvfwalk1);
                }
            }
            gotHit();
        }
    }

    /**
     * Will decrease health and call health function from street.
     * CODED BY SPENCER
     */
    public void health()
    {
        Street s = (Street) getWorld();
        hPoints -= 1;
        nHits += 1;
        health.decHealth(nHits);
        justHit = true;
        if(hPoints <= 0 && nHits > 9)
        {
            getWorld().removeObject(health);
            s.endGame();
        }
    }

    /**
     * spawnHP() will spawn a health bar in the top left of the screen,
     * Mess with parameters below in spawnHitPoints to change spawn point,
     * This function also automatically associates the spawned HP bar with the Runner.
     * CODED BY SPENCER
     */
    public void spawnHP()
    {
        if(spawned == true)
        {
            street = (Street) getWorld();
            health = new HitPoints();
            street.spawnHitPoints(82,-39,health);
            spawned = false;
        }
    }

    /**
     * CODED BY JACOB & SPENCER
     */
    public void attack(){
        if( Greenfoot.isKeyDown("space") ) {
            if( atkdelay > attspeed && street.haungs != true) {
                rockThrow();
                atkdelay = 0;
            }
            if(atkdelay > 10 && street.haungs == true)
            {
                rockThrow();
                atkdelay = 0;
            }
        }
        if( attspeed != 30 )
        {
            aUpDecay--;
            if( aUpDecay < 0 )
            {
                attspeed = 30;
                aUpDecay = 300;
            }
        }
    }

    /**
     * CODED BY SPENCER
     */
    private void rockThrow() {
        if(street.fightboss != true){
            Rock r = new Rock(getRotation());
            getWorld().addObject(r, getX(), getY());
        }
        else if(street.fightboss == true){
            Rock r = new Rock(getRotation()-90);
            getWorld().addObject(r, getX(), getY());
        }
    }

    /**
     * CODED BY JARED & JACOB
     */
    public void move(){
        int xpos = getX();
        int ypos = getY();
        animate();
        Street s = (Street) getWorld();
        //If the runner is in the left 3/4 of the screen, he can move normally with arrow keys
        if((getX()< getWorld().getWidth()-(street.scrollLoc-120))|| s.fightboss == true){
            if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")){
                ypos = ypos - speed;
                if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
                    xpos = xpos - speed;
                }
                else if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
                    xpos = xpos + speed;
                }
                setLocation(xpos, ypos);
            }
            else if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")){
                ypos = ypos + speed;
                if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
                    xpos = xpos - speed;
                }
                else if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
                    xpos = xpos + speed;
                }
                setLocation(xpos, ypos);
            }
            else if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
                xpos = xpos-speed;
                setLocation(xpos, getY());
            }
            else if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
                xpos = xpos+speed;
                setLocation(xpos, getY());
            }
        }
        //If the runner is in the right 1/4 of the screen, He can only move left, right or up
        else{
            if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")){
                ypos = ypos-speed;
                if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
                    xpos = xpos - speed;
                }
                setLocation(xpos, ypos);
            }
            else if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")){
                ypos = ypos+speed;
                if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
                    xpos = xpos - speed;
                }
                setLocation(xpos, ypos);
            }
            else if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
                xpos = xpos-speed;
                setLocation(xpos, getY());
            }
        }
        if( speed != normSpeed)
        {
            sUpDecay--;
            if( sUpDecay < 0 )
            {
                speed = normSpeed;
            }
        }
    }

    /**
     * CODED BY THEO
     * PROFESSOR HAUNGS IS THE BEST PROFESSOR AT CAL POLY.
     */
    private void stepSound()
    {
        Greenfoot.playSound("step1.wav");
    }

    /**
     * CODED BY SPENCER
     */
    private void bindPlayer()
    {
        int maxX = getWorld().getWidth();
        int maxY = getWorld().getHeight();
        if(getX() <= 5 && getY() <= 5)
        {
            setLocation(5,5);
        }
        else if(getX() <= 5)
        {
            setLocation(5,getY());
        }
        else if(getY() <= 5)
        {
            setLocation(getX(),5);
        }
        if(getX()>=maxX && getY()>=maxY){
            setLocation(maxX, maxY);
        }
        else if(getY() >= maxY)
        {
            setLocation(getX(),maxY);
        }
        else if(getX() >= maxX){
            setLocation(maxX, getY());
        }

    }

    /**
     * CODED BY JACOB
     */
    public void speedUp(){
        SpeedUp sUp = (SpeedUp) getOneIntersectingObject(SpeedUp.class);
        if(sUp != null){
            sdelay = sdelay1-10;
            Greenfoot.playSound("drink.wav");
            speed += 1;
            sUpDecay = 300;
            street.removeObject(sUp);
            i = 0;
        }
    }

    /**
     * CODED BY JACOB
     */
    public void attackUp(){
        //changes attspeed to 15 so the rocks are thrown twice as fast
        AttackUp aUp = (AttackUp) getOneIntersectingObject(AttackUp.class);
        if(aUp != null){
            aUpDecay = 300;
            attspeed = 15;
            street.removeObject(aUp);
            //             sdelay = sdelay1-10;
            Greenfoot.playSound("drink.wav");
        }
    }

    /**
     * CODED BY JACOB
     */
    public void healthUp()
    {
        HealthUp hUp = (HealthUp) getOneIntersectingObject(HealthUp.class);
        if( hUp != null)
        {            
            if( nHits > 0)
            {
                nHits -= 1;
                health.decHealth(nHits);
            }
            //health.decHealth(nHits);
            street.removeObject(hUp);
            sdelay = sdelay1-10;
            Greenfoot.playSound("drink.wav");          
        }
    }

    /**
     * CODED BY FRANKLIN
     */
    public void superUp()
    {
        SuperUp sUp = (SuperUp) getOneIntersectingObject(SuperUp.class);
        if( sUp != null)
        {
            street.removeObject(sUp);
            sdelay = sdelay1-10;
            Greenfoot.playSound("drink.wav");  
        }
    }

    public int runnerSpeed()
    {
        return speed;
    }

    public int getHits()
    {
        return nHits;
    }
}
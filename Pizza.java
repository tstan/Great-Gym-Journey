import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**CODED BY: Theodore Tan & Jared Speck
 * 
 */
public class Pizza extends Food
{
    Street s;
    int z = 0;
    /**
     * Act - do whatever the Pizza wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Pizza(int rotation) {
        // Scale Image
        GreenfootImage pizza = getImage();
        pizza.scale(30,30);
        setImage(pizza);
        setRotation(rotation);
    }

    public void act() 
    {
        super.aim();
        super.move(); //should set to player x, y
        if (!selfDestruct()){
            decay();
        }
        //Fun Snapple Fact: Did you know slugs have four noses?
        
        //Just really wanted you to know that...
    }

    /**
     * Coded by Theodore Tan.
     */
    private boolean selfDestruct() {
        int cX = getX();
        int cY = getY();

        if( cX <= 0 || cX >= getWorld().getWidth()) {
            getWorld().removeObject(this);
            return true;
        } else if( cY <= 0 || cY >= getWorld().getHeight()) {
            getWorld().removeObject(this);
            return true;
        } 

        return false;
    }

    /**
     * Pizza explodes into slices
     */
    public void decay(){
        s = (Street) getWorld();
        if(z >= 100){
            int ri = this.getRotation();
            Slice s1 = new Slice();
            Slice s2 = new Slice();
            Slice s3 = new Slice();
            Slice s4= new Slice();
            s.addObject(s1, this.getX(), this.getY());
            s.addObject(s2, this.getX(), this.getY());
            s.addObject(s3, this.getX(), this.getY());
            s.addObject(s4, this.getX(), this.getY());
            s1.setRotation(ri);
            s2.setRotation(90+ri);
            s3.setRotation(180+ri);
            s4.setRotation(270+ri);

            s.removeObject(this);
            z = 0;
        }
        else{
            z++;
        }
    }
}    


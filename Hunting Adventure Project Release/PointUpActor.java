import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PointUpActor is used to keep the Animal actors upright while they are running around.
 * 
 * @Trisha S. 
 * @Project Release, 5/1/2015
 */
public abstract class PointUpActor extends Actor
{
    private int rotation = 0;
    /**
     * Act - do whatever the PointUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public abstract void act();    
    /**
     * setRotation - sets the rotation to the inputed parameter
     */
    @Override 
    public void setRotation(int rotation)
    {
        this.rotation = rotation;
    }
    /**
     * getRotation - gets the rotation of Animal actors
     */
    @Override
    public int getRotation()
    {
        return this.rotation;
    }
    /**
     * move - moves the Animal actor the inputed distance
     */
    @Override
    public void move(int distance)
    {
        super.setRotation(this.rotation);
        super.move(distance);
        super.setRotation(0);
    }
    /**
     * turnTowards - turns the actor towards the inputed coordinates
     */
    @Override
    public void turnTowards(int x,int y)
    {
        double deltaX = x - getX();
        double deltaY = y - getY();
        double degrees = Math.atan2(deltaY,deltaX) * 180.0 / Math.PI; 
        this.rotation = (int)degrees;
        
        while(this.rotation < 0)
        {
            this.rotation+=360;
        }
        
        this.rotation = this.rotation % 360;
        System.out.println("Degrees " + this.rotation);
        super.setRotation(0);
    }
    /**
     * turn - turns the actor a specified distance from it's original position
     */
    @Override
    public void turn(int amount)
    {
        rotation += amount;
        
        while(rotation < 0)
        {
            rotation += 360;
        }
        
        if (rotation >= 360)
        {
            rotation = rotation % 360;
        }
    }
}

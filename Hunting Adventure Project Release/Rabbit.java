import greenfoot.*;

/**
 * The Rabbit class is used as one of the three characters the player can shoot in order
 * to receive points to add to their score. The Rabbit moves at the fastest pace and remains
 * on the screen longest compared to the other animals.
 * 
 * @Trisha S.
 * @Project Release, 5/1/2015
 */
public class Rabbit extends PointUpActor
{
    private int rabbitTimer = 300;
    /**
     * Act - do whatever the Rabbit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveAround();
        checkTimer();
    }   
    /**
     * moveAround - allows the Rabbit to move across the world in a random pattern 
     * and makes sure the actor faces the right direction when moving.
     */
    public void moveAround()
    {
         move(4);
         if (Greenfoot.getRandomNumber (100) < 10)
         {
            turn (Greenfoot.getRandomNumber(180) - 90);
        }
        if (getRotation() > 90 && getRotation() < 270){
            setImage("rabbit2.png");
        } else {
            setImage ("rabbit1.png");
        }
    }
      /**
    * checkTimer - when a Rabbit appears in the world, the timer starts counting down. 
    * If the Rabbit is not clicked on (shot) in a certain amount of time, actor will 
    * disappear from the world.
    */
    public void checkTimer () {
        if (rabbitTimer > 0) {
            rabbitTimer--;
        }
        if (rabbitTimer == 0) {
            getWorld().removeObject(this);
        }
    }
}
import greenfoot.*;

/**
 * The Bird class is used as one of the three characters the player can shoot in order 
 * to receive points to add to their score. The Bird moves at a medium pace and remains on screen
 * longer the bear but shorter than the rabbit.
 * 
 * @Trisha S.
 * @Project Release, 5/1/2015
 */
public class Bird extends PointUpActor
{
     private int birdTimer = 200;
   /**
     * Act - do whatever the Bird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveAround();
        checkTimer();
    } 
    /**
     * moveAround - allows the Bird to move across the world in a random pattern 
     * and makes sure the actor faces the right direction when moving.
     */
    public void moveAround()
    {
        move(3);
        if (Greenfoot.getRandomNumber (100) < 10)
        {
           turn (Greenfoot.getRandomNumber(180) - 90);
        }
        if (getRotation() > 90 && getRotation() < 270){
            setImage("turkey-2.png");
        } else {
            setImage ("turkey-1.png");
        }
   }
   /**
    * checkTimer - when a Bird appears in the world, the timer starts counting down. 
    * If the Bird is not clicked on (shot) in a certain amount of time, actor will 
    * disappear from the world.
    */
    public void checkTimer () {
        if (birdTimer > 0) {
            birdTimer--;
        }
        if (birdTimer == 0) {
            getWorld().removeObject(this);
        }
    }
}

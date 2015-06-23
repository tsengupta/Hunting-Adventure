import greenfoot.*;

/**
 * The Bear class is used as one of the three characters the player can shoot in order 
 * to receive points to add to their score. The Bear moves at a slowest pace and remains on screen
 * for the least amount of time.
 * @Trisha S. 
 * @Project Release, 5/1/2015
 */
public class Bear extends PointUpActor
{
private int bearTimer = 62;
/**
* Act - do whatever the Bear wants to do. This method is called whenever
* the 'Act' or 'Run' button gets pressed in the environment.
*/
public void act() 
{
    moveAround();
    checkTimer();
}
/**
* moveAround - allows the Bear to move across the world in a random pattern 
* and makes sure the actor faces the right direction when moving.
*/
public void moveAround()
{
    move(2);
    if (Greenfoot.getRandomNumber (100) < 10)
        {
            turn (Greenfoot.getRandomNumber(180) - 90);
        }
    if (getRotation() > 90 && getRotation() < 270){
        setImage("bear2.png");
        } else {
        setImage ("bear1.png");
        }
}
/**
* checkTimer - when a Bear appears in the world, the timer starts counting down. 
* If the Bear is not clicked on (shot) in a certain amount of time, actor will 
* disappear from the world.
*/
public void checkTimer() {
    if (bearTimer > 0) {
        bearTimer--;
    }     
    if (bearTimer == 0) {
         getWorld().removeObject(this);
    }   
}
}

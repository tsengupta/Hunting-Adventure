import greenfoot.*;
/**
 * The Crosshairs are used to aim your mouse, shoot the the animals, remove them from the world, add the appropriate score amount, and make the animals untargetable when behind
 * the trees and brush.
 * 
 * @Antonio (Crosshairs), Mir (canSeeTree, canSeeBrush, gunshot sound)
 * @Project Release, 5/1/2015
 */
public class Crosshair extends Actor
{
    private int points = 0;
    private Counter counter;
    
    public Crosshair (Counter pointCounter){
        counter = pointCounter;
    }
    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {  
        if (Greenfoot.mouseMoved(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation (mouse.getX(), mouse.getY());
        }
        if (Greenfoot.mouseClicked(null)){
            Greenfoot.playSound("gun-gunshot-01.wav");
        }
        if (!canSee(Tree.class) && !canSee(Brush.class)){
            if (Greenfoot.mouseClicked(null)){
                Bear b = (Bear) getOneIntersectingObject(Bear.class);
                if (b != null){
                getWorld().removeObject(b);
                counter.add(3);
               }
            }
            if (Greenfoot.mouseClicked(null)){
                Bird c = (Bird) getOneIntersectingObject(Bird.class);
                if (c != null){
                getWorld().removeObject(c);
                counter.add(2);
               }
            }
            if (Greenfoot.mouseClicked(null)){
                Rabbit d = (Rabbit) getOneIntersectingObject(Rabbit.class);
                    if (d != null){
                getWorld().removeObject(d);
                counter.add(1);
               } 
            }
        }
    }    
    public boolean canSee (Class clss){
        return getOneObjectAtOffset (0,0,clss) !=null;
    }
}

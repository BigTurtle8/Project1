import mayflower.*;


public class MyWorld extends World {
    private Cat cat;
    
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        
        cat = new Cat();
        addObject(cat, 400, 100);
        
        //addObject(new DogAnimatedActor(), 200, 100);
        //addObject(new JackAnimatedActor(), 300, 100);
        //addObject(new NinjaAnimatedActor(), 200, 200);
        
        addObject(new Block(), 400, 500);
        addObject(new Block(), 528, 372);
        
        Mayflower.showBounds(false);
    }
    
    public void act()
    {
    }
    
}
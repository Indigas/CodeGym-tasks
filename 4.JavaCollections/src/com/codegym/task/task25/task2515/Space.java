package com.codegym.task.task25.task2515;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The game's main class is Space
 */
public class Space {
    // Width and height of the game field
    private int width;
    private int height;

    // Spaceship
    private Spaceship ship;
    // List of UFOs
    private List<Ufo> ufos = new ArrayList<Ufo>();
    // List of bombs
    private List<Bomb> bombs = new ArrayList<Bomb>();
    // List of rockets
    private List<Rocket> rockets = new ArrayList<Rocket>();

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * The program's main loop.
     * This is where all the important actions happen
     */
    public void run() {
        // Create a drawing canvas.
        Canvas canvas = new Canvas(width, height);

        // Create a KeyboardObserver object and start it.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        // The game continues as long as the ship is alive
        while (ship.isAlive()) {
            // Does the observer have any key events?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                // If "left arrow", then move the game piece to the left
                System.out.print(event.getKeyCode());
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    ship.moveLeft();
                    // If "right arrow", then move the game piece to the right
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    ship.moveRight();
                    // If "space", then launch a ball
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ship.fire();
            }

            // Move all of the objects in the game
            moveAllItems();

            // Detect collisions
            checkBombs();
            checkRockets();
            // Remove dead objects from the list
            removeDead();

            // Create a UFO (once in every 10 calls)
            createUfo();

            // Draw all the objects on the canvas and display the canvas on the screen
            canvas.clear();
            draw(canvas);
            canvas.print();

            // Pause 300 milliseconds
            Space.sleep(300);
        }

        // Display "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Move all of the objects in the game
     */
    public void moveAllItems() {
        // Get a list of all objects in the game and call the move() method on each of them.
        for(BaseObject bo : getAllItems()){
            bo.move();
        }
    }

    /**
     * The method returns a single list that contains all objects in the game
     */
    public List<BaseObject> getAllItems() {
        // You need to create a new list and put all the game objects into it.
        List<BaseObject> allOfItems = new ArrayList<>();
        allOfItems.add(ship);
        allOfItems.addAll(ufos);
        allOfItems.addAll(bombs);
        allOfItems.addAll(rockets);


        return allOfItems;
    }

    /**
     * Create a new UFO. Once in every 10 calls.
     */
    public void createUfo() {
        // You need to create a new UFO.
        // Once in every 10 calls.
        if(ufos.isEmpty())
            ufos.add(new Ufo(width/2d, height/2d));
    }

    /**
     * Check the bombs.
     * a) collision with a ship (the bomb and the ship die)
     * b) movement beyond the bottom of the game field (the bomb dies)
     */
    public void checkBombs() {
        // Here you need to check all possible collisions for each bomb.
        for(Bomb bo : bombs) {
            if (ship.intersects(bo)) {
                ship.die();
                bo.die();
            }

            if(bo.getY() > height)
                bo.die();
        }
    }

    /**
     * Check the rockets.
     * a) collision with a UFO (the rocket and the UFO die)
     * b) movement beyond the top of the playing field (the rocket dies)
     */
    public void checkRockets() {
        // Here you need to check all possible collisions for each rocket.
        for(Rocket ro : rockets){
            for(Ufo ufo : ufos){
                if(ufo.intersects(ro)){
                    ufo.die();
                    ro.die();
                }
            }

            if(ro.getY() < 0)
                ro.die();
        }
    }

    /**
     * Remove dead objects (bombs, rockets, ufos) from the lists
     */
    public List<BaseObject> listOf = new ArrayList<>();
    public void removeDead() {
        // Here you need to remove all dead objects from the lists.
        // Except the spaceship — we use it to determine whether the game is still going.
        ufos = ufos.stream().filter(BaseObject::isAlive).collect(Collectors.toList());
        rockets = rockets.stream().filter(BaseObject::isAlive).collect(Collectors.toList());
        bombs = bombs.stream().filter(BaseObject::isAlive).collect(Collectors.toList());
    }

    /**
     * Draw all game objects:
     * a) fill the entire canvas with periods.
     * b) draw all the objects on the canvas.
     */
    public void draw(Canvas canvas) {
        // Here you need to draw all game objects
    }


    public Spaceship getShip() {
        return ship;
    }

    public void setShip(Spaceship ship) {
        this.ship = ship;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public static Space game;

    public static void main(String[] args) throws Exception {
        game = new Space(20, 20);
        game.setShip(new Spaceship(10, 18));
        game.run();
    }

    /**
     * The method pauses for delay seconds.
     */
    public static void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}
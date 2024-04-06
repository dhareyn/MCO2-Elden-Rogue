import java.util.ArrayList;
import java.util.Random;

/**
 * The EnemyList class represents a list of available Enemies and Bosses in the game.
 */

public class EnemyList {
    private ArrayList<Enemy> enemyList = new ArrayList<>();

    /**
     * Constructs a EnemyList object and initializes it with a predefined list of Enemies and Bosses.
     */
    public EnemyList()
    {
        // List of Area1 Enemies
        enemyList.add (new Enemy(1, "Godrick Soldier","Stormviel Castle", 1, 20, 30, 70, 80, 0.20, 0.15, 0.10, false));
        enemyList.add (new Enemy(2, "Godrick Archer", "Stormviel Castle", 1, 25, 35, 110, 120, 0.50, 0.15, 0.20, false));
        enemyList.add (new Enemy(3, "Godrick Knight", "Stormviel Castle", 1, 70, 80, 120, 130, 0.25, 0.25, 0.20, false));
       

        //List of Area2 Enemies
        enemyList.add (new Enemy(1, "Living Jar", "Raya Lucaria Academy", 2, 20, 30, 70, 80, 0.20, 0.15, 0.10, false));
        enemyList.add (new Enemy(2, "Glintstone Sorcerer", "Raya Lucaria Academy", 2, 5, 35, 110, 120, 0.50, 0.15, 0.20, false));
        enemyList.add (new Enemy(3, "Battle Mage", "Raya Lucaria Academy", 2,70, 80, 120, 130, 0.25, 0.25, 0.20, false));



        //List of Boss Enemies per Area
        
        enemyList.add (new Enemy(4, "Godrick, the Grafted","Stormviel Castle", 1, 200, 200, 150, 300, 0.35, 0.20, 0.15, true));
        enemyList.add (new Enemy(4, "Rennala, Queen of the Full Moon","Raya Lucaria Academy", 2, 400, 400, 200, 300, 0.15, 0.35, 0.25, true));
        enemyList.add (new Enemy(4, "The Elden Beast","The Elden Throne", 3, 800, 800, 250, 500, 0.25, 0.50, 0.40, true));


    }

    /**
     * Gets a enemy from the list that is within the area.
     *
     * @param index The type of index to allow selection of enemies.
     * @return A random enemy within the index.
     */

    public Enemy getEnemy(int index)
    {
        return enemyList.get(index);
    }

    /**
     * Gets a random number within the area.
     *
     * @param area The type of area to allow to pick which enemy should it be.
     * @return A random int within the int area.
     */
    public int enemyNumber(int area, boolean boss)
    {
        int upperbound = 0;
        int lowerbound = 0;
        int i = 0;
        Random random = new Random();

        if (boss == false)
        {
            if (area == 1)
            {
                upperbound = 2;
                lowerbound = 0;
                i = random.nextInt(upperbound);
            }
            else if(area == 2)
            {
                upperbound = 5;
                lowerbound = 3;
                i = random.nextInt(upperbound-lowerbound) + lowerbound;
            }
            else if(area == 3)
            {
                i = 5;
            }
            // none for area 3 since area 3 only holds the boss
            
        }
        else 
        {
            if (area == 1)
            {
                i = 6;
            }
            else if(area == 2)
            {
                i = 7;
            }
            else if(area == 3)
            {
                i = 8;
            }
        }
        return i;
    }

    
}

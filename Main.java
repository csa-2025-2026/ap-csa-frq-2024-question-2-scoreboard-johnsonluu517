public class Scoreboard {

private int turn = 1;
private String name1;
private String name2;
private int team1points = 0;
private int team2points = 0;

public Scoreboard (String iname1, String iname2)
 {
    name1 = iname1;
    name2 = iname2;
 }
public void recordPlay(int points)
{
    if (turn == 1)
    {
        if (points >= 1)
        {
            team1points = team1points + points;
        }

        else 
        {
            turn++;
        }
    }

    if (turn == 2)
    {
        if (points >= 1)
        {
            team2points = team2points + points;
        }

        else 
        {
            turn++;
        }
    }

}

public String getScore ()
{
    if (turn == 1)
    {
    return (team1points + "-" + team2points + "-" + name1);
    }

    if (turn == 2)
    {
    return (team1points + "-" + team2points + "-" + name2);
    }
    else 
    {
    return ("error");
    }
}

}








public class Main {
    public static void main(String[] args) {
        
        // 1. Initialize the first game
        Scoreboard game = new Scoreboard("Red", "Blue"); // 
        
        // 2. Check initial state
        // Expected: "0-0-Red"
        System.out.println(game.getScore()); // 

        // 3. Red scores 1 point
        game.recordPlay(1); // 
        
        // Expected: "1-0-Red"
        System.out.println(game.getScore()); // 

        // 4. Red fails (0 points), turn switches to Blue
        game.recordPlay(0); // 
        
        // Expected: "1-0-Blue"
        System.out.println(game.getScore()); // 

        // 5. Check state again (should remain unchanged)
        // Expected: "1-0-Blue"
        System.out.println(game.getScore()); // 

        // 6. Blue scores 3 points
        game.recordPlay(3); // 
        
        // Expected: "1-3-Blue"
        System.out.println(game.getScore()); // 

        // 7. Blue scores 1 point, then fails. Turn switches to Red.
        game.recordPlay(1); // 
        game.recordPlay(0); // 
        
        // Expected: "1-4-Red" (Blue had 3, added 1 = 4. Red is now active)
        System.out.println(game.getScore()); // 

        // 8. Red fails immediately. Turn switches to Blue.
        game.recordPlay(0); // 
        
        // 9. Blue scores 4 points.
        game.recordPlay(4); // 
        
        // 10. Blue fails. Turn switches to Red.
        game.recordPlay(0); // 
        
        // Expected: "1-8-Red" (Blue had 4, added 4 = 8. Red is now active)
        System.out.println(game.getScore()); // 

        // 11. Create a distinct, new match
        Scoreboard match = new Scoreboard("Lions", "Tigers"); // 
        
        // Expected: "0-0-Lions"
        System.out.println(match.getScore()); // 

        // 12. Verify the original game is unaffected
        // Expected: "1-8-Red"
        System.out.println(game.getScore()); // 
    }
}
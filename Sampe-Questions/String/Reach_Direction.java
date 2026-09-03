package String;

public class Reach_Direction {

    // [Q- 2] A raute containg 4 direction (E,W,N,S) find shortest path to reach
    // destinstion
    // "WNEENESENNN"

    public static float get_Shortest_path(String path) 
    {
        int x = 0, y = 0;

        // Visit all direction
        for (int i = 0; i < path.length(); i++) 
        {
            char dir = path.charAt(i);
            // South
            if (dir == 'S') 
            {
                y--;
            }
            // North
            else if (dir == 'N') 
            {
                y++;
            } 
            else if (dir == 'W') 
            {
                x--;
            } 
            else if (dir == 'E') 
            {
                x++;
            }
        }

        // Calculate distance between two points
        int x2 = x * x;
        int y2 = y * y;
        return  (float) Math.sqrt(x2 + y2);
    }

    public static void main(String[] args) {

        String path = "WNEENESENNN";
        System.out.println(get_Shortest_path(path));
    }
}

import java.util.HashSet;
import java.util.Set;

public class PathCrossed {
    public static boolean isPathCrossing(String path) {
        char[] directions = path.toCharArray();
        int x = 0, y = 0;
        Set<String> cells = new HashSet<String>();

        cells.add(x + "_" + y);
        for (char d : directions) {
            if(d == 'E') {
                x++;
            }
            else if(d == 'W') {
                x--;
            }

            else if(d == 'N') {
                y++;
            }

            else if(d == 'S') {
                y--;
            }

            String point = x + "_" + y;
            if(cells.contains(point)) return true;

            cells.add(point);
        }

        return false;
    }
}

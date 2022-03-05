import java.util.*;

/*
    https://leetcode.com/problems/destination-city/
*/

public class DestinationCity {

    public static void main(String[] args) {
        List<List<String>> p1 = new ArrayList<>(Arrays.asList(
                Arrays.asList("A", "Z")
        ));

        List<List<String>> p2 = new ArrayList<>(Arrays.asList(
                Arrays.asList("A", "Z"),
                Arrays.asList("Z", "B")
        ));

        System.out.println(destCity(p1));
        System.out.println(destCity(p2));
    }

    public static String destCity(List<List<String>> paths) {
        if (paths == null || paths.size() == 0) return "";

        // Collect all destinations in hashset
        Set<String> destinations = new HashSet();
        for (List<String> route : paths) {
            destinations.add(route.get(1));
        }

        // Check if destination is available as source as well, if so that's not the destination
        for (List<String> route : paths) {
            String source = route.get(0);

            if (destinations.contains(source)) {
                destinations.remove(source);
            }
        }

        return destinations.iterator().next();
    }
}

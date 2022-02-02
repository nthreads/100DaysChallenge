public class CountRouters {

    public static void main(String[] args) {
        System.out.println("Routers " + countRouters(new int[]{1, 2, 1, 2, 2}, new int[]{3, 1}, new int[]{1, 2}));
    }

    public static int countRouters(int[] buildings, int[] routeLoc, int[] routeRange) {
        int[] coverage = new int[buildings.length];

        for (int i = 0; i < routeLoc.length; i++) {
            int buildingLocation = routeLoc[i] - 1;
            int range = routeRange[i];

            int minBuildingRange = Math.max(0, buildingLocation - range);
            coverage[minBuildingRange] += 1;

            if (buildingLocation + range < coverage.length - 1)
                coverage[buildingLocation + range + 1] -= 1;
        }

        for (int i = 1; i < coverage.length; i++) {
            coverage[i] += coverage[i - 1];
        }

        int count = 0;
        for (int i = 0; i < coverage.length; i++) {
            if (coverage[i] >= buildings[i])
                count++;
        }

        return count;
    }
}
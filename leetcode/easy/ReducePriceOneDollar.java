public class ReducePriceOneDollar {

    /*
    Suppose I am in the marketing department and have written a lot of advertisements
    with text that include prices.  A few days before they are sent out, I am
    informed that we are going to discount all the products by $1.

    Implement a function that takes the ad string as input and decreases all costs in
    the string by $1

    Input: "Get our brand-new product for only $10.5"
    Output: "Get our brand-new product for only $9.5"

    Input: "Get our brand-new product for only $10, and an accessory for $5"
    Output: "Get our brand-new product for only $9, and an accessory for $4"
    */

    public static void main(String[] args) {
        String[] inputs = {"Get our brand-new product for only $10.50",
                "Get our brand-new product for only $10, and an accessory for $5",
                "Get our brand-new product for only $$$10, and an accessory for $5$"
        };

        for (String input : inputs) {
            System.out.println(reducePrice(input));
        }
    }

    static String reducePrice(String ad) {
        if (ad == null || ad.length() == 0) return "";

        String[] words = ad.split("\s");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (word.startsWith("$")) {
                double newPrice = extractPriceValue(word) - 1;
                if (newPrice < 0f) newPrice = 0.01f;

                word = "$" + newPrice;
            }

            sb.append(word).append(" "); // Hey our price is
        }


        return sb.toString().trim();
    }

    static double extractPriceValueUsingRegex(String word) {
        return Double.parseDouble(word.replaceAll("[^0-9.]", ""));
    }

    static double extractPriceValue(String word) {
        char[] cArray = word.toCharArray();

        int index = 0;

        // $$$120.50

        StringBuilder sb = new StringBuilder();

        while (index < cArray.length) {
            if (Character.isDigit(cArray[index]) || cArray[index] == '.') {
                sb.append(cArray[index]);
            }

            index++;
        }

        return Double.parseDouble(sb.toString());
    }
}

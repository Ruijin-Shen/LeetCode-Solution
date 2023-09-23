public class IntegerToRoman {
}

class Solution12 {
    private static final int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < values.length && num > 0; i++){
            while(num >= values[i]){
                num -= values[i];
                builder.append(symbols[i]);
            }
        }
        return builder.toString();
    }
}
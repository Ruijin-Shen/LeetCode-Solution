package Solution.C;

import java.util.*;

public class CountGoodMeals {
}

class Solution1711 {
    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> count = new HashMap<>();

        long result = 0;
        for(int deli : deliciousness){
            for(int i = 1; i <= 2097152; i *= 2){
                int diff = i - deli;
                result += count.getOrDefault(diff, 0);
            }
            count.compute(deli, (key, value) -> value == null ? 1 : value + 1);
        }
        return (int)(result % 1000000007);
    }
}
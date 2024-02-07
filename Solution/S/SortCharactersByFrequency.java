package Solution.S;

import java.util.*;

public class SortCharactersByFrequency {
}

class Solution451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for(char ch : s.toCharArray()) count.merge(ch, 1, Integer::sum);
        ArrayList<int[]> pairs = new ArrayList<>();
        for(var entry : count.entrySet()){
            pairs.add(new int[]{entry.getKey(), entry.getValue()});
        }
        pairs.sort(Comparator.comparing((int[] x) -> x[1]).reversed());
        StringBuilder builder = new StringBuilder();
        for(int[] pair : pairs){
            for(int i = 0; i < pair[1]; i++) builder.append((char)pair[0]);
        }
        return builder.toString();
    }
}
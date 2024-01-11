package Solution.T;

import java.util.*;

public class TallestBillboard {
}

class Solution956DynamicProgramming {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);

        for(int r : rods){
            Map<Integer, Integer> newDp = new HashMap<>(dp);
            for(Map.Entry<Integer, Integer> entry : dp.entrySet()){
                int diff = entry.getKey();
                int positive = entry.getValue();;
                int negative = positive - diff;

                newDp.put(diff + r, Math.max(positive + r, newDp.getOrDefault(diff + r, 0)));

                int newDiff = Math.abs(negative + r - positive);
                newDp.put(newDiff,
                        Math.max(Math.max(negative + r, positive), newDp.getOrDefault(newDiff, 0)));
            }
            dp = newDp;
        }

        return dp.get(0);
    }
}

class Solution956 {
    public static int tallestBillboard(int[] rods) {
        int n = rods.length;
        Map<Integer, Integer> leftHalf = helper(rods, 0, (n - 1) >> 1);
        Map<Integer, Integer> rightHalf = helper(rods, ((n - 1) >> 1) + 1, n - 1);

        int answer = 0;
        for(int diff : leftHalf.keySet()){
            if(rightHalf.containsKey(-diff)){
                answer = Math.max(answer, leftHalf.get(diff) + rightHalf.get(-diff));
            }
        }
        return answer;
    }

    private static HashMap<Integer, Integer> helper(int[] rods, int left, int right){
        Set<AbstractMap.SimpleEntry<Integer, Integer>> states = new HashSet<>();
        states.add(new AbstractMap.SimpleEntry<>(0, 0));

        for(int i = left; i <= right; i++){
            int r = rods[i];
            Set<AbstractMap.SimpleEntry<Integer, Integer>> newStates = new HashSet<>();

            for(var pair : states){
                newStates.add(new AbstractMap.SimpleEntry<>(pair.getKey() + r, pair.getValue()));
                newStates.add(new AbstractMap.SimpleEntry<>(pair.getKey(), pair.getValue() + r));
            }
            states.addAll(newStates);
        }

        HashMap<Integer, Integer> result = new HashMap<>();
        for(var pair : states){
            int leftHeight = pair.getKey(), rightHeight = pair.getValue();
            result.put(leftHeight - rightHeight,
                    Math.max(result.getOrDefault(leftHeight - rightHeight, 0), leftHeight));
        }
        return result;
    }
}


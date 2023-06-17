import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeArrayStrictlyIncreasing {
}

class Solution1187DP {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        this.dp = new HashMap<>();
        Arrays.sort(arr2);
        int answer = dfs(0, -1, arr1, arr2);
        return answer < 2001 ? answer : -1;
    }

    private Map<AbstractMap.SimpleEntry<Integer, Integer>, Integer> dp;
    private int dfs(int i, int prev, int[] arr1, int[] arr2) {
        if (i == arr1.length) {
            return 0;
        }
        if (dp.containsKey(new AbstractMap.SimpleEntry<>(i, prev))) {
            return dp.get(new AbstractMap.SimpleEntry<>(i, prev));
        }

        int cost = 2001;

        // If arr1[i] is already greater than prev, we can leave it be.
        if (arr1[i] > prev) {
            cost = dfs(i + 1, arr1[i], arr1, arr2);
        }

        // Find a replacement with the smallest value in arr2.
        int idx = bisectRight(arr2, prev);

        // Replace arr1[i], with a cost of 1 operation.
        if (idx < arr2.length) {
            cost = Math.min(cost, 1 + dfs(i + 1, arr2[idx], arr1, arr2));
        }

        dp.put(new AbstractMap.SimpleEntry<>(i, prev), cost);
        return cost;
    }

    private static int bisectRight(int[] arr, int value) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
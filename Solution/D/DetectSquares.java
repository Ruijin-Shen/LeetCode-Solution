package Solution.D;

import java.util.*;

public class DetectSquares {
    private HashMap<Integer, List<int[]>> positive;
    private HashMap<Integer, List<int[]>> negative;
    private HashMap<String, Integer> points;

    public DetectSquares() {
        positive = new HashMap<>();
        negative = new HashMap<>();
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int bPositive = - point[0] + point[1];
        positive.compute(bPositive, (key, value) -> {
            if(value == null){
                value = new LinkedList<>();
            }
            value.add(new int[]{point[0], point[1]});
            return value;
        });

        int bNegative = point[0] + point[1];
        negative.compute(bNegative, (key, value) -> {
            if(value == null){
                value = new LinkedList<>();
            }
            value.add(new int[]{point[0], point[1]});
            return value;
        });

        points.compute(Arrays.toString(point), (key, value) -> value == null ? 1 : value + 1);
    }

    public int count(int[] point) {
        int count = 0;


        int bPositive = - point[0] + point[1];
        if(positive.containsKey(bPositive)){
            for(int[] p : positive.get(bPositive)){
                if(p[0] == point[0]) continue;
                count += points.getOrDefault(Arrays.toString(new int[]{p[0], point[1]}), 0) *
                        points.getOrDefault(Arrays.toString(new int[]{point[0], p[1]}), 0);
            }
        }

        int bNegative = point[0] + point[1];
        if(negative.containsKey(bNegative)){
            for(int[] p : negative.get(bNegative)){
                if(p[0] == point[0]) continue;
                count += points.getOrDefault(Arrays.toString(new int[]{p[0], point[1]}), 0) *
                        points.getOrDefault(Arrays.toString(new int[]{point[0], p[1]}), 0);
            }
        }

        return count;
    }
}
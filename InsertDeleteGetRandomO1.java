import java.util.*;

public class InsertDeleteGetRandomO1 {
}

class RandomizedSet {
    private final HashMap<Integer, Integer> map;
    private final ArrayList<Integer> list;
    private final Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        else{
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{
            int index = map.get(val);
            int lastVal = list.get(list.size() - 1);
            map.remove(val);
            list.set(index, lastVal);
            list.remove(list.size() - 1);
            if(index < list.size()) map.put(lastVal, index);
            return true;
        }
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
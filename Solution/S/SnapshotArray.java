package Solution.S;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class SnapshotArray {
    private int timeStamp;
    private HashMap<Integer, List<int[]>> array;

    public SnapshotArray(int length) {
        this.timeStamp = 0;
        this.array = new HashMap<>();
    }

    public void set(int index, int val) {
        if(!array.containsKey(index)) array.put(index, new ArrayList<>());
        List<int[]> history = array.get(index);
        history.add(new int[]{val, this.timeStamp});
    }

    public int snap() {
        int snapID = this.timeStamp;
        this.timeStamp++;
        return snapID;
    }

    public int get(int index, int snap_id) {
        if(!array.containsKey(index)) return 0;

        List<int[]> history = array.get(index);
        // Binary Search
        int n = history.size();
        int low = 0, high = n - 1;
        if(snap_id < history.get(low)[1]) return 0;
        if(snap_id >= history.get(n - 1)[1]) return history.get(n - 1)[0];

        while(high - low > 1){
            int mid = low + ((high - low) >> 1);
            if(history.get(mid)[1] > snap_id){
                high = mid;
            }else{
                low = mid;
            }
        }
        return history.get(low)[0];
    }
}

class SnapshotArrayTreeMap {
    private int snapID;
    private TreeMap<Integer, Integer>[] historyRecords;

    public SnapshotArrayTreeMap(int length) {
        this.snapID = 0;
        this.historyRecords = new TreeMap[length];
        for(int i = 0; i < length; i++){
            historyRecords[i] = new TreeMap<>();
            historyRecords[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        historyRecords[index].put(snapID, val);
    }

    public int snap() {
        return snapID++;
    }

    public int get(int index, int snap_id) {
        return historyRecords[index].floorEntry(snap_id).getValue();
    }
}

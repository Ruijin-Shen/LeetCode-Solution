import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
}

class Solution1353PriorityQueue {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Arrays::compare);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int count = 0;
        int result = 0;
        for(int start = events[0][0]; start <= 100000; start++){
            while(count < events.length && events[count][0] <= start){
                queue.add(events[count][1]);
                count++;
            }

            while(!queue.isEmpty()){
                if(queue.element() >= start){
                    result++;
                    queue.remove();
                    break;
                }else{
                    queue.remove();
                }
            }
        }
        return result;
    }
}
import java.util.*;

public class FrogJump {
}

class Solution403DynamicProgramming {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        HashMap<Integer,Integer> mark = new HashMap<Integer,Integer>();
        boolean dp[][] = new boolean[2000][2000];

        for(int i = 0; i < n; i++){
            mark.put(stones[i], i);
        }

        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] state = q.removeFirst();
            int index = state[0], prevJump = state[1];
            for(int curJump = prevJump - 1; curJump <= prevJump + 1; curJump++){
                if(curJump > 0 && mark.containsKey(stones[index] + curJump) && !dp[mark.get(stones[index] + curJump)][curJump]){
                    dp[mark.get(stones[index] + curJump)][curJump] = true;
                    q.addLast(new int[]{mark.get(stones[index] + curJump), curJump});
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(dp[n - 1][i]) return true;
        }
        return false;
    }
}
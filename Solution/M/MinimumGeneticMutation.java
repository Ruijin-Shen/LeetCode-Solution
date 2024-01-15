package Solution.M;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class MinimumGeneticMutation {
}

class Solution433 {
    private static final char[] CH = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashMap<String, Boolean> visited = new HashMap<>();
        for(String valid : bank){
            visited.put(valid, false);
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(startGene);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.remove();
                if(cur.equals(endGene)) return depth;
                StringBuilder builder = new StringBuilder(cur);
                for(int j = 0; j < 8; j++){
                    char backup = builder.charAt(j);
                    for(char ch : CH){
                        builder.setCharAt(j, ch);
                        String next = builder.toString();
                        if(!visited.getOrDefault(next, true)){
                            visited.put(next, true);
                            queue.add(next);
                        }
                    }
                    builder.setCharAt(j, backup);
                }
            }
            depth++;
        }
        return -1;
    }
}
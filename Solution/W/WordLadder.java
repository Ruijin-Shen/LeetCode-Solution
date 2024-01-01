package Solution.W;

import java.util.*;

public class WordLadder {
}

class Solution127 {
    private static final List<String> EMPTY = new ArrayList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        HashSet<String> visited = new HashSet<>();
        if(!wordList.contains(endWord)) return 0;

        HashMap<String, List<String>> dict = new HashMap<>();
        for(String word : wordList){
            addToDict(dict, word);
        }

        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.removeFirst();
                if(word.equals(endWord)) return depth;
                StringBuilder builder = new StringBuilder(word);
                for(int j = 0; j < n; j++){
                    builder.setCharAt(j, '*');
                    for(String nextWord : dict.getOrDefault(builder.toString(), EMPTY)){
                        if(!visited.contains(nextWord)){
                            visited.add(nextWord);
                            queue.addLast(nextWord);
                        }
                    }
                    builder.setCharAt(j, word.charAt(j));
                }
            }
            depth++;
        }
        return 0;
    }

    private void addToDict(HashMap<String, List<String>> dict, String word){
        int n = word.length();
        StringBuilder builder = new StringBuilder(word);
        for(int i = 0; i < n; i++){
            builder.setCharAt(i, '*');
            String symbol = builder.toString();
            if(!dict.containsKey(symbol)) dict.put(symbol, new ArrayList<>());
            dict.get(symbol).add(word);
            builder.setCharAt(i, word.charAt(i));
        }
    }
}
package Solution.W;

import java.util.*;

public class WordLadderII {
}

class Solution126 {
    private Map<String, List<String>> dict;
    private List<String> EMPTY = new ArrayList<>();
    private List<List<String>> result;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        dict = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for(String word : wordList){
            builder.append(word);
            for(int i = 0; i < n; i++){
                builder.setCharAt(i, '*');
                String str = builder.toString();
                if(!dict.containsKey(str)) dict.put(str, new ArrayList<>());
                dict.get(str).add(word);
                builder.setCharAt(i, word.charAt(i));
            }
            builder.delete(0, builder.length());
        }

        // BFS
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> prev = new HashMap<>();
        queue.addLast(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            Set<String> v = new HashSet<>();
            for(int i = 0; i < size; i++){
                String str = queue.removeFirst();
                builder.append(str);
                for(int j = 0; j < n; j++){
                    builder.setCharAt(j, '*');
                    String wildcard = builder.toString();
                    for(String next : dict.getOrDefault(wildcard, EMPTY)){
                        if(!visited.contains(next)){
                            if(!v.contains(next)) queue.add(next);
                            v.add(next);
                            if(!prev.containsKey(next)) prev.put(next, new ArrayList<>());
                            prev.get(next).add(str);
                        }
                    }
                    builder.setCharAt(j, str.charAt(j));
                }
                builder.delete(0, builder.length());
            }
            visited.addAll(v);
        }

        // DFS
        this.result = new ArrayList<>();
        if(!prev.containsKey(endWord)) return result;
        DFS(endWord, prev, new LinkedList<>(){{add(endWord);}});
        return this.result;
    }

    private void DFS(String curWord, Map<String, List<String>> prev, LinkedList<String> seq){
        if(!prev.containsKey(curWord)){
            result.add(new ArrayList<>(seq));
            return;
        }

        for(String prevWord : prev.get(curWord)){
            seq.addFirst(prevWord);
            DFS(prevWord, prev, seq);
            seq.removeFirst();
        }
    }
}
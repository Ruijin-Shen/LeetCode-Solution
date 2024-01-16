package Solution.D;

import java.util.*;

public class DesignAddAndSearchWordsDataStructure {
}

class WordDictionary {
    private static class TrieNode{
        public HashMap<Character, TrieNode> children = new HashMap<>();
        public boolean end = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)) node.children.put(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.end = true;
    }

    public boolean search(String word) {
        Queue<TrieNode> q = new ArrayDeque<>();
        q.add(root);
        for(char ch : word.toCharArray()){
            if(q.isEmpty()) return false;

            int size = q.size();
            for(int i = 0; i < size; i++){
                TrieNode next = q.remove();
                if(ch == '.'){
                    q.addAll(next.children.values());
                }else if(next.children.containsKey(ch)){
                    q.add(next.children.get(ch));
                }
            }
        }
        while(!q.isEmpty()){
            if(q.remove().end) return true;
        }
        return false;
    }
}
package Template;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(node.containsKey(currentChar)){
                node = node.get(currentChar);
            }else{
                return null;
            }
        }
        return node;
    }

    public boolean search(String word){
        TrieNode node = this.searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = this.searchPrefix(prefix);
        return node != null;
    }
}

class TrieNode{
    private TrieNode[] links;
    private static final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        this.links[ch - 'a'] = node;
    }
    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}

class TrieArray{
    private int[][] son;
    private int[] count;
    private int index;

    TrieArray (int n){
        son = new int[n][26];
        count = new int[n];
        index = 0; // 0 denotes root and null.
    }

    public void insert(String str){
        int node = 0;
        for(int i = 0; i < str.length(); i++){
            int ch = str.charAt(i) - 'a';
            if(son[node][ch] == 0) son[node][ch] = ++index;
            node = son[node][ch];
        }
        count[node]++;
    }

    public int query(String str){
        int node = 0;
        for(int i = 0; i < str.length(); i++){
            int ch = str.charAt(i) - 'a';
            if(son[node][ch] == 0) return 0;
            node = son[node][ch];
        }
        return count[node];
    }
}
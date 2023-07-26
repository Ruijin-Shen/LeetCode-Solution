public class LongestCommonPrefix {
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        char[] base = strs[0].toCharArray();
        int count = base.length;

        for(String str : strs){
            int i = 0;
            while(i < str.length() && i < count && str.charAt(i) == base[i]){
                i++;
            }
            count = Math.min(count, i);
        }
        return strs[0].substring(0, count);
    }
}
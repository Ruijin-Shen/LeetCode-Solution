import java.util.*;

public class GroupAnagrams {
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < strs.length; i++){
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);
            String str = String.valueOf(chArr);
            if(map.containsKey(str)){
                result.get(map.get(str)).add(strs[i]);
            }else{
                map.put(str, map.size());
                List<String> l = new LinkedList<>();
                l.add(strs[i]);
                result.add(l);
            }
        }
        return result;
    }
}
package Solution.B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BuddyStrings {
}

class Solution859 {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if(s.equals(goal)){
            var set = new HashSet<Character>();
            for(char c : s.toCharArray()){
                set.add(c);
            }
            return set.size() < s.length();
        }

        int n = s.length();
        List<char[]> swap = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != goal.charAt(i)) swap.add(new char[]{s.charAt(i), goal.charAt(i)});
        }
        if(swap.size() != 2){
            return false;
        }
        else{
            return Arrays.equals(swap.get(0), new char[]{swap.get(1)[1], swap.get(1)[0]});
        }
    }
}
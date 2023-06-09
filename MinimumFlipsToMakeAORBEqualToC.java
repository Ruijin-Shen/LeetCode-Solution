public class MinimumFlipsToMakeAORBEqualToC {
}

class Solution1318 {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while( a != 0 || b != 0 || c != 0){
            int ai = a % 2;
            int bi =  b % 2;
            int ci = c % 2;
            a >>= 1;
            b >>= 1;
            c >>= 1;

            if((ai | bi) != ci){
                if(ai + bi == 2){
                    count += 2;
                }else{
                    count += 1;
                }
            }
        }
        return count;
    }
}
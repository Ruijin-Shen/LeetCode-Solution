public class MinimumOperationsToMakeTheIntegerZero {
}

class Solution2749 {
    public int makeTheIntegerZero(int num1, int num2) {
        if(num2 == 0) return Integer.bitCount(num1);
        else if(num2 > 0) return positiveCase(num1, num2);
        else return negativeCase(num1, num2);

    }

    private int positiveCase(int num1, int num2){
        int result = 0;
        do{
            result++;
            num1 -= num2;
            if(num1 >= result && Integer.bitCount(num1) <= result) return result;
        }while(num1 > 0);
        return -1;
    }

    private int negativeCase(long num1, long num2){
        int result = 0;
        do{
            result++;
            num1 -= num2;
            if(Long.bitCount(num1) <= result) return result;
        }while(result <= 36);

        return -1;
    }
}

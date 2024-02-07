package Solution.U;

public class UTF8Validation {
}

class Solution393 {

    public boolean validUtf8(int[] data) {
        int flag = 0;
        for(int ch : data){
            if(flag != 0){
                if((ch & 0b11000000) == 0b10000000) flag--;
                else return false;
            }else{
                if((ch & 0b11000000) == 0b10000000) return false;
                else{
                    if((ch & 0b10000000) == 0) continue;
                    else if ((ch & 0b11100000) == 0b11000000) flag = 1;
                    else if ((ch & 0b11110000) == 0b11100000) flag = 2;
                    else if ((ch & 0b11111000) == 0b11110000) flag = 3;
                    else return false;
                }
            }
        }
        return flag == 0;
    }
}
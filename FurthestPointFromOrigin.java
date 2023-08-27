public class FurthestPointFromOrigin {
}

class Solution2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int distance = 0, unsure = 0;
        for(char ch : moves.toCharArray()){
            switch (ch){
                case 'L': distance--; break;
                case 'R': distance++; break;
                case '_': unsure++; break;
            }
        }
        return Math.abs(distance) + unsure;
    }
}
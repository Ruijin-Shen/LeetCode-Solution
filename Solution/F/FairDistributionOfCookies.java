package Solution.F;

public class FairDistributionOfCookies {
}

class Solution2305 {
    private static int arrayMax(int[] array){
        int max = Integer.MIN_VALUE;
        for(int ele : array){
            if(ele > max) max = ele;
        }
        return max;
    }

    public int distributeCookies(int[] cookies, int k) {
        return DFS(cookies, 0, new int[k], k, k, arrayMax(cookies));
    }

    private int DFS(int[] cookies, int nextBag, int[] children, int k, int zeroCount, int maxCookie){
        if(cookies.length - nextBag < zeroCount){
            return Integer.MAX_VALUE;
        }
        if(cookies.length - nextBag == zeroCount || nextBag == cookies.length){
            return Math.max(maxCookie, arrayMax(children));
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            int isZero = children[i] == 0 ? 1 : 0;
            children[i] += cookies[nextBag];
            result = Math.min(result, DFS(cookies, nextBag + 1, children, k, zeroCount - isZero, maxCookie));
            children[i] -= cookies[nextBag];
        }
        return result;
    }
}

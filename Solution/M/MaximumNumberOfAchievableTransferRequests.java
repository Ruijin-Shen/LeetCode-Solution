package Solution.M;

public class MaximumNumberOfAchievableTransferRequests {
}

class Solution1601 {

    public int maximumRequests(int n, int[][] requests) {
        int result = 0;
        int numReq = requests.length;
        for(int i = 1; i < (1 << numReq); i++){
            if(valid(i, n, requests)){
                result = Math.max(result, Integer.bitCount(i));
            }
        }
        return result;
    }

    private boolean valid(int i, int n, int[][] request){
        int[] degree = new int[n];
        int pos = request.length - 1;
        for(; i > 0; i >>= 1, pos--){
            if((i & 1) == 1){
                degree[request[pos][0]]--;
                degree[request[pos][1]]++;
            }
        }

        for(int j = 0; j < n; j++){
            if(degree[j] != 0) return false;
        }
        return true;
    }
}

class Solution1601Backtracking {
    private int answer;

    public int maximumRequests(int n, int[][] requests) {
        answer = 0;
        maxRequest(requests, new int[n], n, 0, 0);
        return answer;
    }

    private void maxRequest(int[][] requests, int[] degree, int n, int index, int count){
        if(index == requests.length){
            for(int i = 0; i < n; i++){
                if(degree[i] != 0){
                    return;
                }
            }
            answer = Math.max(answer, count);
            return;
        }
        if(count + requests.length - index < answer) return;

        maxRequest(requests, degree, n, index + 1, count);

        degree[requests[index][0]]--;
        degree[requests[index][1]]++;
        maxRequest(requests, degree, n, index + 1, count + 1);
        degree[requests[index][0]]++;
        degree[requests[index][1]]--;
    }
}
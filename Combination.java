public class Combination {
    private long mod;
    private long[][] table;

    public Combination(long mod, int length){
         this.mod = mod;
         this.table = new long[length][length];
         for(int i = 0; i < length; i++){
             table[i][0] = table[i][i] = 1;
         }
         for(int i = 2; i < length; i++){
             for(int j = 1; j < i; j++){
                 table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod;
             }
         }
    }

    public long compute(int n, int k){
        return table[n][k];
    }

}
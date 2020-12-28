import java.util.ArrayDeque;
class printAllLongestIncreasingSubsequence{

    public static class Pair{
        int l;
        int i;
        int v;
        String psf;

        Pair(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void solution(int[] arr){
        int[] dp = new int[arr.length];

        int omax = 0;

        for(int i=0; i<dp.length; i++){
            int max = 0;

            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }

            dp[i] = max +1;
            if(dp[i] > omax){
                omax = dp[i];
            }
        }

        System.out.println(omax);

        ArrayDeque<Pair> q = new ArrayDeque<>();
        for(int i=0; i<dp.length; i++){
            if(dp[i] == omax){
                q.add(new Pair(omax, i, arr[i], arr[i] + ""));
            }
        }

        while(q.size() > 0){
            Pair rem = q.removeFirst();

            if(rem.l == 1){
                System.out.println(rem.psf);
            }

            for(int j=rem.i-1; j>=0; j--){
                if(arr[j] < rem.v && dp[j] == rem.l-1){
                    q.add(new Pair(rem.l-1, j, arr[j], arr[j] + " -> " + rem.psf));
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        solution(arr);
    }
}

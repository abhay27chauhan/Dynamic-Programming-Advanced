import java.util.ArrayDeque;
class printAllPathsWithMinJumps{

    public static class Pair{
        int i;
        int s;
        int j;
        String psf;

        Pair(int i, int s, int j, String psf){
            this.i = i;
            this.s = s;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void solution(int[] arr){
        Integer[] dp = new Integer[arr.length];
        dp[arr.length-1] = 0;

        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] > 0){
                int min = Integer.MAX_VALUE;

                for(int j = 1; j<=arr[i] && (i+j) < arr.length; j++){
                    if(dp[i+j] != null){
                        min = Math.min(min, dp[i+j]);
                    }
                }

                if(min != Integer.MAX_VALUE){
                    dp[i] = min +1;
                }
            }
        }
        System.out.println(dp[0]);

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, arr[0], dp[0], 0 + ""));

        while(q.size() > 0){
            Pair rem = q.removeFirst();
            
            if(rem.j == 0){
                System.out.println(rem.psf + " .");
            }

            for(int j=1; j<=rem.s && (rem.i + j) < arr.length; j++){
                if(dp[rem.i + j] != null && dp[rem.i + j] == rem.j-1){
                    q.add(new Pair(rem.i+j, arr[rem.i+j], dp[rem.i + j], rem.psf + " -> " + (rem.i+j)));
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {3,3,0,2,1,2,4,2,0,0}; // for (n-1)th steps
        solution(arr);
    }
}

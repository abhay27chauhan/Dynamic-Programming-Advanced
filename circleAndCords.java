// catalan Numbers
class circleAndCords{

    public static int solution(int n){
        int c = n/2;

        int[] dp = new int[c+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<dp.length; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j]*dp[i-1-j];
            }
        }

        return dp[c];
    }

    public static void main(String[] args){
        int n = 6; // total no. of points

        System.out.println(solution(n));
    }
}

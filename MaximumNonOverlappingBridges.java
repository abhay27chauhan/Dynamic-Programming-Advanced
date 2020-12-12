import java.util.Arrays;
class MaximumNonOverlappingBridges{

    public static class Bridge implements Comparable<Bridge>{
        int n;
        int s;

        Bridge(int n, int s){
            this.n = n;
            this.s = s;
        }

        public int compareTo(Bridge o){
            if(o.n != this.n){
                return this.n - o.n;
            }else{
                return this.s - o.s;
            }
        }
    }

    public static int solution(Bridge[] bdgs){
        Arrays.sort(bdgs);

        int[] dp = new int[bdgs.length];
        int omax = 0;

        for(int i=0; i<dp.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(bdgs[j].s < bdgs[i].s){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }

            dp[i] = max+1;
            if(omax < dp[i]){
                omax = dp[i];
            }
        }

        return omax;
    }

    public static void main(String[] args){
        Bridge[] bdgs = new Bridge[10];

        bdgs[0] = new Bridge(10, 20); 
        bdgs[1] = new Bridge(2, 7); 
        bdgs[2] = new Bridge(8, 15); 
        bdgs[3] = new Bridge(17, 3); 
        bdgs[4] = new Bridge(21, 40); 
        bdgs[5] = new Bridge(50, 4); 
        bdgs[6] = new Bridge(41, 57); 
        bdgs[7] = new Bridge(60, 80); 
        bdgs[8] = new Bridge(80, 90); 
        bdgs[9] = new Bridge(1, 30); 

        System.out.println(solution(bdgs));
    }
}

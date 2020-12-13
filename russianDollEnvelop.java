import java.util.Arrays;
class russianDollEnvelop{

    public static class Envelop implements Comparable<Envelop> {
        int w;
        int h;

        Envelop(int w, int h){
            this.w = w;
            this.h = h;
        }

        public int compareTo(Envelop o){
            return this.w - o.w;
        }
    }

    public static int solution(Envelop[] envlps){
        Arrays.sort(envlps);

        int[] dp = new int[envlps.length];
        int omax = 0;

        for(int i=0; i<dp.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(envlps[j].h < envlps[i].h){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }

            dp[i] = max + 1;
            if(dp[i] > omax){
                omax = dp[i];
            }
        }

        return omax;
    }

    public static void main(String[] args){
        Envelop[] envlps = new Envelop[11];

        envlps[0] = new Envelop(17, 5); 
        envlps[1] = new Envelop(26, 18); 
        envlps[2] = new Envelop(25, 34); 
        envlps[3] = new Envelop(48, 84); 
        envlps[4] = new Envelop(63, 72); 
        envlps[5] = new Envelop(42, 86); 
        envlps[6] = new Envelop(9, 55); 
        envlps[7] = new Envelop(4, 70); 
        envlps[8] = new Envelop(21, 45); 
        envlps[9] = new Envelop(68, 76);
        envlps[10] = new Envelop(58, 51);  

        System.out.println(solution(envlps));
    }
}

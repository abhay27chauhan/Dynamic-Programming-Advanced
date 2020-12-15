import java.util.HashMap;
class countDistinctSubsequence{

    public static void countDistinctSubsequence(String str){
        int[] dp = new int[str.length() + 1];

        dp[0] = 1;
        HashMap<Character, Integer> loc = new HashMap<>();
        for(int i=1; i<dp.length; i++){
            dp[i] = dp[i-1]*2;

            char c = str.charAt(i-1);
            if(loc.containsKey(c)){
                int j = loc.get(c);
                dp[i] = dp[i] - dp[j-1];
            }

            loc.put(c, i);
        }

        System.out.println(dp[str.length()]-1);
    }

    public static void main(String[] args){
        String str = "abc";
        countDistinctSubsequence(str);
    }
}

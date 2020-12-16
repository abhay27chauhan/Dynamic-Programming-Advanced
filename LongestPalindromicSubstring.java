class LongestPalindromicSubstring{

    public static void solution(String s){
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans =0;
        for(int g=0; g<s.length(); g++){
            for(int i=0, j=g; j<s.length(); j++, i++){
                if(g==0){
                    dp[i][j] = true;
                }else if(g==1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }

                if(dp[i][j]){
                    int len = g+1;
                    if(len > ans){
                        ans = len;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args){
        String str = "abccbc";
        solution(str);
    }
}

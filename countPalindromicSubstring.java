class countPalindromicSubstring{

    public static void solution(String str){
        boolean[][] dp = new boolean[str.length()][str.length()];
        int count = 0;

        for(int g=0; g<str.length(); g++){
            for(int i=0, j=g; j<str.length(); j++, i++){
                if(g==0){
                    dp[i][j] = true;
                }else if(g==1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }

                if(dp[i][j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args){
        String str = "abccbc";
        solution(str);
    }
}

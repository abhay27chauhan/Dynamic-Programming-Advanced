class LongestCommonSubsequence{

    public static void solution(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=dp.length-2; i>=0; i--){
            for(int j=dp[0].length-2; j>=0; j--){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if(c1 == c2){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }

    public static void main(String[] args){
        String s1 = "abcd";
        String s2 = "aebd";

        solution(s1, s2);

    }
}

/*
s1 = c1r1
s2 = c2r2
                                p1                          p3
no. of subsequence of s1 = (-)(no. of sub. of r1) + (c1)(no. of sub. of r1)

                                p2                          p4
no. of subsequence of s2 = (-)(no. of sub. of r2) + (c2)(no. of sub. of r2)

no. of common subsequence in s1 and s2 =  (comman)(p1xp2) + (comman)(p1xp4)
                                          (comman)(p3xp2) + (comman)(p3xp4)

2 cases -       1.  c1 = c2         |    2. c1 != c2
         maxL((comman)(p1xp2)) + 1  |   (comman)(p1xp2), (comman)(p1xp2),
                                    |            (comman)(p1xp2)  
                                    |
                                    |    max(L(p1, (p2+p4)), L(p2, L(p1+p3)))
                                                    or
                                    |    max(L(r1, s2), L(r2, s1))

*/

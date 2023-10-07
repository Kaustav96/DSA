package interview.Microsoft.DSA1;

public class LongestPallindromicSubstr {
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";

        System.out.println(longestPallString(str));
        System.out.println(longestPallStringDp(str));
    }

    private static int longestPallStringDp(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1,start=0;


        // length 1
        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }

        // length 2
        for(int i=0;i<n-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        // length >2
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {

                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // Checking for sub-string from ith index to
                // jth index if str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (dp[i + 1][j - 1]
                        && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.println(str.substring(start,start+maxLength));
        return maxLength;
    }

    private static int longestPallString(String str) {

        int n = str.length();
        int maxLength = 1,start=0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int flag = 1;
                for(int k=0;k<(j-i+1);k++){
                    if(str.charAt(i+k)!=str.charAt(j-k)){
                        flag = 0;
                    }
                }
                if(flag!=0 && (j-i+1)>maxLength){
                    maxLength = j-i+1;
                    start = i;
                }
            }
        }
        System.out.println(str.substring(start,start+maxLength));
        return maxLength;
    }
}

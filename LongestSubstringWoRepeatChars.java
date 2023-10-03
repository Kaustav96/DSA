package interview.Microsoft.DSA1;

public class LongestSubstringWoRepeatChars {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int n = str.length();

        System.out.println(lengthOfSubstr(str,n));
    }

    private static int lengthOfSubstr(String str, int n) {
        int res = 0;

        for(int i=0;i<n;i++){
            boolean[] visit = new boolean[256];
            for(int j=i;j<n;j++){
                if(visit[str.charAt(j)]==true) break;
                else{
                    res = Math.max(res,j-i+1);
                    visit[str.charAt(j)]=true;
                }
            }
            visit[str.charAt(i)] = false;
        }
        return res;
    }
}

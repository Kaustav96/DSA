package interview.Microsoft.DSA1;

import java.util.Arrays;

public class ZigZagConversion {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int numRows = 1;

        System.out.println(zigZag(str,numRows));
    }

    private static String zigZag(String str, int k) {
        if(k==1) return str;

        char[] sArr = str.toCharArray();
        int n = str.length();

        String[] ans = new String[k];

        Arrays.fill(ans,"");

        boolean down = true;
        int row = 0;

        for(int i=0;i<n;i++){
            ans[row]+=sArr[i];
            if(row==k-1){
                down=false;
            }
            else if(row==0){
                down=true;
            }
            if(down){
                row++;
            }
            else{
                row--;
            }
        }
        String res = "";
        for(int i=0;i<k;i++){
            res+=ans[i];
        }
        return res;
    }
}

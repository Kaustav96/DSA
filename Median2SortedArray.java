package interview.Microsoft.DSA1;

public class Median2SortedArray {
    public static void main(String[] args) {
        int a[] = {-5, 3, 6, 12, 15}, b[] = {-12, -10, -6, -3, 4, 10};


        System.out.println(getMedian(a, b));
    }

    private static double getMedian(int[] a, int[] b) {
        int n = a.length,m=b.length;
        if (n > m)
            return getMedian(b, a); // Swapping to make A smaller

        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            int leftA
                    = (leftAsize > 0)
                    ? a[leftAsize - 1]
                    : Integer
                    .MIN_VALUE; // checking overflow
            // of indices
            int leftB = (leftBsize > 0) ? b[leftBsize - 1]
                    : Integer.MIN_VALUE;
            int rightA = (leftAsize < n)
                    ? a[leftAsize]
                    : Integer.MAX_VALUE;
            int rightB = (leftBsize < m)
                    ? b[leftBsize]
                    : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                return Math.max(leftA, leftB);
            }
            else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
    }
}

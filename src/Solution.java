import java.util.*;

class Solution {
    public int maximizeSweetness(int[] sweetness, int noOfCuts) {
        int start = 0;
        int end = Arrays.stream(sweetness).sum()/(noOfCuts + 1);
        start = binarySearch(sweetness, noOfCuts, start, end);
        return start;
    }

    private int binarySearch(int[] sweetness, int noOfCuts, int start, int end) {
        while(start < end) {
            int mid = (start + end + 1)/2;
            if(canSplit(sweetness, mid, noOfCuts)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private boolean canSplit(int[] sweetness, int mid, int noOfCuts) {
        int sum = 0;
        int count = 0;

        for(int sweet : sweetness) {
            sum = sum + sweet;
            if(sum >= mid) {
                sum = 0;
                count++;
            }
        }
        return count >= noOfCuts + 1;
    }


}
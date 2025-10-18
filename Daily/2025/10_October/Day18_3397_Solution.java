import java.util.Arrays;

public class Day18_3397_Solution {
    public int maxDistinctElements(int[] nums, int k){
        Arrays.sort(nums);
        int cnt = 0;
        int prev = Integer.MIN_VALUE;
        for(int num: nums){
            int curr = Math.min(Math.max(prev+1,num-k),num+k);
            if(curr> prev ){
                cnt++;
                prev=curr;
            }
        }
        return cnt;
    }
}

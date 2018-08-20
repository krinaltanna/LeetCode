import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i< nums.length;i++){
            if(diff.containsKey(nums[i])){
                result[0] = diff.get(nums[i]);
                result[1] = i;
                return result;
            }
            int currDiff = target - nums[i];
            diff.put(currDiff, i);
            
        }
        return result;
    }
}

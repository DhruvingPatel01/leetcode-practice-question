import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store the value and its index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the required complement exists in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Store the current number and its index for future lookups
            map.put(nums[i], i);
        }
        
        // Per constraints, a solution always exists, but we return 
        // an empty array or throw an error to satisfy the compiler.
        return new int[] {};
    }
}
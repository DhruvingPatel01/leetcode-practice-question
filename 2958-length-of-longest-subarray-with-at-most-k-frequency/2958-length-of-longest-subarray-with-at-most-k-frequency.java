import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;
        
        for (int end = 0; end < n; end++) {
            if (!map.containsKey(nums[end])) {
                map.put(nums[end], 1);
            } else if (map.get(nums[end]) < k) {
                map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            } else {
                while (map.containsKey(nums[end]) && map.get(nums[end]) >= k) {
                    map.put(nums[start], map.getOrDefault(nums[start], 0) - 1);
                    if (map.get(nums[start]) <= 0) {
                        map.remove(nums[start]);
                    }
                    start++;
                }
                map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            }
            res = Math.max(res, end - start + 1);
        }

        return res;
    }
}
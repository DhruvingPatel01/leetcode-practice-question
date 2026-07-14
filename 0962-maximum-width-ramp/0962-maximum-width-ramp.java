class Solution {
    public int maxWidthRamp(int[] nums) {
        int n =nums.length;
        int[] stack = new int[n];
        int top = -1;

        for(int i = 0;i<n;i++) {
            if(top == -1 || nums[i] < nums[stack[top]]) {
                stack[++top] = i;
            }
        }
        int ans = 0;

        for(int j = n-1;j>=0;j--) {
                        while (top >= 0 && nums[j] >= nums[stack[top]]) {

                ans = Math.max(ans,j-stack[top]);
                top--;
            }
        }
        return ans;
    }
}
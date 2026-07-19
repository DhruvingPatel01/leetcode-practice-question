class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);

        while (arr.size() < n) {
            List<Integer> temp= new ArrayList<>();

            for(int x : arr) {
                if(2 * x-1 <= n) {
                    temp.add(2 * x-1);
                }
            }
            for (int x : arr) {
                if(2 * x <= n) {
                    temp.add(2 * x);
                }
            }
            arr = temp;
        }
        int[] ans = new int [n];
        for(int i = 0;i<n;i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}

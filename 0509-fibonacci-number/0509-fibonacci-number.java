class Solution {
    int count = 0;
    int[] memo = new int[31];
    public int fib(int n) {
        // int ans = rec(n);
        // System.out.println(count);
        // return ans;

        // int ans = memoFun(n);
        // System.out.println(count);
        // return ans;

        int ans = tab(n);
        System.out.println(count);
        return ans;
    }

    // recursion solution
    public int rec(int n) {
        count++;
        if(n <= 1) {
            return n;
        }
        int nextTerm = rec(n-1) + rec(n-2);
        return nextTerm;
    }

    // Memoization solution
    public int memoFun(int n) {
        count++;
        if(n <= 1) {
            return n;
        }

        if(memo[n] != 0) {
            return memo[n];
        }

        memo[n] = memoFun(n-1) + memoFun(n-2);
        return memo[n];
    }

    // Tabulation solution
    public int tab(int n) {
        if(n <= 1) {
            return n;
        }
        int[] table = new int[n+1];
        table[0] = 0;
        table[1] = 1;

        for(int i = 2; i <= n; i++) {
            count++;
            table[i] = table[i-1] + table[i-2];
        }
        return table[n];
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // Start by assuming the first string is the common prefix
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            // Check if the current string starts with our 'prefix'
            // indexOf returns 0 if the prefix is at the very beginning
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) return "";
            }
        }
        
        return prefix;
    }
}

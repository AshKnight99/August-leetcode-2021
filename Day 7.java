/*
Palindrome Partitioning II
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lower-case English letters only.
*/
class Solution {
    public int minCut(String s) {
        int len = s.length();
        char arr[] = s.toCharArray();
        int cuts[] = new int[len];
        boolean isPal[][] = new boolean[len][len];
        int minCut = 0;
        for(int i = 0; i < len; i++){
            minCut = i;
            for(int j = 0; j <= i; j++){
                if(arr[i] == arr[j] && ((i - j) < 2 || isPal[j + 1][i - 1])){
                    
                    isPal[j][i] = true;
                    minCut = Math.min(minCut, j == 0 ? 0 : cuts[j - 1] + 1);
                }
            }
            cuts[i] = minCut;
        }
        return cuts[len - 1];
    }
}
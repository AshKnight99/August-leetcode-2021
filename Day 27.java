/*
Longest Uncommon Subsequence II
Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.

An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.

A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
 

Example 1:

Input: strs = ["aba","cdc","eae"]
Output: 3
Example 2:

Input: strs = ["aaa","aaa","aa"]
Output: -1
 

Constraints:

1 <= strs.length <= 50
1 <= strs[i].length <= 10
strs[i] consists of lowercase English letters.
*/
class Solution {
    public int findLUSlength(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : strs){
            int sub = (int)(1 << s.length()) - 1;
            for(int i = 1; i <= sub; i++){
                StringBuilder builder = new StringBuilder();
                int t = i, j = 0;
                while( t > 0 ){
                    if( (t & 1) == 1 ){
                        builder.append(s.charAt(j));
                    }
                    j++;
                    t >>= 1;
                }
                int count = map.getOrDefault(builder.toString(), 0);
                map.put(builder.toString(), count + 1);
            }
        }
        int max = -1;
        for(Map.Entry<String, Integer> m : map.entrySet()){
            // System.out.println(m.getKey() + " " + m.getValue());
            if( m.getValue() == 1 ) max = Math.max(max, m.getKey().length());
        }
        return max;
    }
}
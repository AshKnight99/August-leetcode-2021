/*
Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word : strs) {
            char[] keys = new char[26];
            for(char c : word.toCharArray()) {
                keys[c-'a']++;
            }

            String key = new String(keys);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }
}
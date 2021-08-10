/*
Flip String to Monotone Increasing
A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.

 

Example 1:

Input: s = "00110"
Output: 1
Explanation: We flip the last digit to get 00111.
Example 2:

Input: s = "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.
Example 3:

Input: s = "00011000"
Output: 2
Explanation: We flip to get 00000000.
 

Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.
*/

class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int zeroToOne = 0, oneCount = 0;
        int i = 0;
        
        while(s.charAt(i) == '0') i++;
        
        for(; i < len; i++){
            if(s.charAt(i) == '0') zeroToOne++; //flip 0 -> 1
            else oneCount++;
            if(zeroToOne > oneCount) zeroToOne = oneCount; // choose min Value
        }
     return zeroToOne;   
    }
}
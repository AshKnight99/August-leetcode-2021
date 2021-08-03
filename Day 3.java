/*Subsets II
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        List <Integer> list = new ArrayList<>();
        subsetFormation(nums, 0, list);
        return result;        
    }
    private void subsetFormation(int nums[], int index, List<Integer> list){
        result.add(new ArrayList<>(list));
        
        if(index >= nums.length) return;
        
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subsetFormation(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

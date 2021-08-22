/*
Rectangle Area II


We are given a list of (axis-aligned) rectangles. Each rectangle[i] = [xi1, yi1, xi2, yi2] , where (xi1, yi1) are the coordinates of the bottom-left corner, and (xi2, yi2) are the coordinates of the top-right corner of the ith rectangle.

Find the total area covered by all rectangles in the plane. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:


Input: rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
Output: 6
Explanation: As illustrated in the picture.
Example 2:

Input: rectangles = [[0,0,1000000000,1000000000]]
Output: 49
Explanation: The answer is 1018 modulo (109 + 7), which is (109)2 = (-7)2 = 49.
 

Constraints:

1 <= rectangles.length <= 200
rectanges[i].length = 4
0 <= rectangles[i][j] <= 109
The total area covered by all rectangles will never exceed 263 - 1 and thus will fit in a 64-bit signed integer.
*/
class Solution {
    public int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
          Set<Integer> coorx = new HashSet<>();
          Set<Integer> coory = new HashSet<>();
          for (int[] rec : rectangles) {
              coorx.add(rec[0]); coorx.add(rec[2]);
              coory.add(rec[1]); coory.add(rec[3]);
          }
          
          Integer[] compressx = coorx.toArray(new Integer[0]);
          Arrays.sort(compressx);
          Integer[] compressy = coory.toArray(new Integer[0]);
          Arrays.sort(compressy);
          
          Map<Integer, Integer> mapx = new HashMap<>();
          for(int i = 0; i < compressx.length; i++) {
              mapx.put(compressx[i], i);
          }
          Map<Integer, Integer> mapy = new HashMap<>();
          for(int i = 0; i < compressy.length; i++) {
              mapy.put(compressy[i], i);
          }
          
          boolean[][] grid = new boolean[compressx.length][compressy.length];
          for (int[] rec: rectangles) {
              for (int x = mapx.get(rec[0]); x < mapx.get(rec[2]); x++) {
                  for (int y = mapy.get(rec[1]); y < mapy.get(rec[3]); y++) {
                      grid[x][y] = true;
                  }
              }
          }
          
          long res = 0L;
          for (int i = 0; i < grid.length; i++) {
              for (int j = 0; j < grid[0].length; j++) {
                  if (grid[i][j]) {
                      res += (long)(compressx[i + 1] - compressx[i]) * (compressy[j + 1] - compressy[j]);
                  }
              }
          }
          res %= 1000000007;
          return (int)res;
    }
}
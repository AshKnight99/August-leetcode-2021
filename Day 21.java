/*
Sudoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
*/
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return ;
        solve(board , 0 , 0);
    }
    
     public boolean solve(char[][] board, int i, int j) {
        if(i == 9 && j == 0) return true;
        if(board[i][j] != '.') 
            return solve(board, (j+1) == 9? i+1 : i, (j+1) == 9? 0 : j+1);
        
        for(char num = '1'; num <= '9'; num++) {
            if(isValid(board, i, j, num)){
                board[i][j] = num;
                if(solve(board, (j+1) == 9? i+1 : i, (j+1) == 9? 0 : j+1)) 
                    return true;
                board[i][j] = '.';
            }
        }
        return false;
    }
     private boolean isValid(char[][] board, int row, int col, char c){
        int allrow = 3 * (row / 3);
        int allcol = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) 
                return false; //check row
            if (board[row][i] == c) 
                return false; //check column
            if (board[allrow + i / 3][allcol + i % 3] == c) 
                return false; //check 3*3 block
        }
        return true;
    }
}
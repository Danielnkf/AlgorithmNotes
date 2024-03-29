/*
 * Given a 2D board and a word, find if the word exists in the grid.

 * The word can be constructed from letters of sequentially adjacent
 *  cell, where "adjacent" cells are those horizontally or vertically 
 *  neighboring. The same letter cell may not be used more than once.

 * For example,
 * Given board =

 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, word))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String s) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || s.charAt(0) != board[i][j])
            return false;
        if(s.length() == 1)
            return true;
        board[i][j] = '#';
        boolean flag = dfs(board, i - 1, j, s.substring(1, s.length())) || dfs(board, i + 1, j, s.substring(1, s.length()))
            || dfs(board, i, j - 1, s.substring(1, s.length())) || dfs(board, i, j + 1, s.substring(1, s.length()));
        board[i][j] = s.charAt(0);
        return flag;
    }
}

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word==null || word.length()==0) return false;
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(dfs(board,word,0,i,j))
                    return true;
        return false;
    }
    public boolean dfs(char[][] board, String word,int deep,int i,int j){
        if(deep==word.length()-1 && word.charAt(deep)==board[i][j])
            return true;
        if(word.charAt(deep)!=board[i][j])
            return false;
        char temp = board[i][j];
        board[i][j] = '.';
        boolean b1 = false;boolean b2 = false;boolean b3 = false;boolean b4 = false;
        if(i-1>=0 && board[i-1][j]!='.')
            b1 = dfs(board,word,deep+1,i-1,j);
        if(!b1 && j-1>=0 && board[i][j-1]!='.')
            b2 = dfs(board,word,deep+1,i,j-1);
        if(!b1 && !b2 && i+1<board.length && board[i+1][j]!='.')
            b3 = dfs(board,word,deep+1,i+1,j);
        if(!b1 && !b2 && !b3 && j+1<board[0].length && board[i][j+1]!='.')
            b4 = dfs(board,word,deep+1,i,j+1);
        board[i][j] = temp;
        return b1||b2||b3||b4;
    }
}

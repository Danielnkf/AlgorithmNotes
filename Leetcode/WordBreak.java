/*
 * Given a string s and a dictionary of words dict, determine if s can be 
 * segmented into a space-separated sequence of one or more dictionary words.

 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].

 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBrealen {
/*  public boolean wordBreak(String s, Set<String> dict) {
        boolean[][] dp = new boolean[s.length()][s.length() + 1];
        for(int len = 1; len <= s.length(); len++) {
            for(int i = 0; i <= s.length() - len; i++) {
                if(dict.contains(s.substring(i, i + len))) 
                    dp[i][len] = true;
                else {
                    for(int k = 1; k < len; k++) {
                        if(dp[i][k] && dp[i + k][len - k]) {
                            dp[i][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][s.length()];
    }


    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        for(int i = 0; i < s.length(); i++) {
            if(i > 0 && !dp[i])
                continue;
            for(int j = s.length(); j > i; j--) {
                dp[j] = dp[j] || dict.contains(s.substring(i, j));
            }  
        }
        return dp[s.length()];
    }
    //brutal force
    public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0 || dict.isEmpty())
	    return false;
    	if (dict.contains(s))
    	    return true;
    	for (int i = 1; i < s.length(); i++) {
    	    System.out.println(s.substring(0, i) + " " + s.substring(i));
    	    if (wordBreak(s.substring(0, i), dict)
    		    && wordBreak(s.substring(i), dict))
    		return true;
    	}
    	return false;
    }
}
*/
//Same Idea
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null && s.length()==0) return false;
        boolean[] dp=new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j]==true && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
//Same idea different direction
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null || s.length()==0) return false;
        boolean[] possible = new boolean[s.length() + 1];
        	possible[s.length()] = true;
        	for (int i = s.length() - 1; i >= 0; i--) {
        	    for (int j = s.length(); j > i; j--) {
        		possible[i] = possible[j] && dict.contains(s.substring(i, j));
        		if (possible[i])
        		    break;
        	    }
        	}
        return possible[0];
    }
}
//

    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i < s.length(); i++) {
            if(dp[i]) {
                for(int j = i + 1; j <= s.length(); j++) {
                    if(dict.contains(s.substring(i, j)))
                        dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}

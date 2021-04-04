package com.test.String;

public class StringSolution {
    /*10. 正则表达式匹配
     */
    public boolean isMatch(String s, String p) {
        if(p==null) return false;
        int i = 0;
        int j = 0;

        while (i<s.length() && j < p.length()){
            Character s1 = s.charAt(i);
            Character p1 = p.charAt(j);
            if(p1 != '.' && p1 != '*'){
                if(p1 != s1){
                    if(j+1<p.length() && p.charAt(j+1) == '*'){
                        j++;
                        i--;
                    }else  return true;
                }
                j++;
            }else if(p1 == '*'){
                if(j==0) return false;
                if(j==p.length() -1) j++;
                else if(s1 != p.charAt(j-1) && p.charAt(j-1)!='.'){
                    j ++;
                    i--;
                }
            }else {
                j ++;
            }
            i++;

        }
        return i==s.length() && j == p.length();
    }
}

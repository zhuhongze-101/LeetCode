package com.test.Array;

public class ArraySolution {
    public ArraySolution(){}

//    编写一个函数来查找字符串数组中的最长公共前缀。
//    如果不存在公共前缀，返回空字符串 ""。
//    输入：strs = ["flower","flow","flight"]
//    输出："fl"
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return  "";
        if(strs.length == 1) return strs[0];
        String result = "";//longestCommonPrefix(strs[0],strs[1]);
        int i = 0;
        Character commonChar = CommonCharInPos(strs,i);
        while (commonChar!=null){
            result += commonChar;
            i++;
            commonChar = CommonCharInPos(strs,i);
        }
        return result;
    }

    public String longestCommonPrefix_Optimality(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0]; //以第一个字符串作为最长公共前缀
        for (String s: strs) {
            while (!s.startsWith(str)) {
                // 如果不是以它开头，那就去掉最后一个字符
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    /**
     * 在数组中每一个数组找到相同位置是否存在相同字符
     * @param strs 字符数组
     * @param i 位置索引
     * @return 如果相同当前位置索引的字符。如果不同返回null
     */
    public Character CommonCharInPos(String[] strs, int i){
        Character result = null;
        for (int j = 0; j < strs.length; j++) {
            if(i>= strs[j].length()) return null;
            if(result==null){
                result = strs[j].charAt(i);
            }else if(result != strs[j].charAt(i)){
                return null;
            }
        }
        return  result;
    }

}

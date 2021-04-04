package com.test.Array;

import java.util.ArrayList;
import java.util.List;

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
    //最优解11
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

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 双指针直接在相应的数据的修改，节省一个相应的数据空间 原地修改数据结构
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int i = 0;
        int j = 1;
        while (j< nums.length){
           if(nums[i] != nums[j]){
               i++;
               nums[i] = nums[j];
           }
           j++;
        }


        return i+1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if(totalLength == 0) return 0;
        int i = 0;
        int j = 0;
        int index = 0;
        int result = 0;
        int curNum = 0;
        while (index < totalLength){
            if(i>=nums1.length){
                curNum = nums2[j];
                j++;

            }else  if(j>=nums2.length){
                curNum = nums1[i];
                i++;

            }else  if(nums1[i] >= nums2[j]){
                curNum = nums2[j];
                j++;
            }else{
                curNum = nums1[i];
                i++;
            }
            if((index == Math.floor(totalLength/2)-1 && totalLength%2 == 0) || index == Math.floor(totalLength/2)  ){
                result += curNum;
                if(index == Math.floor(totalLength/2)) break;
            }

            index ++;
        }
        return totalLength%2 == 0?result/2.0:result;

    }
    //6. Z 字形变换
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] temp = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            temp[i] = new StringBuilder();
        }
        int one = 2 * numRows - 2;
        for (int j = 0; j < s.length(); j++) {
            String str = s.substring(j,j+1);
            if(j%one < numRows){
                temp[j%one].append(str);
            }else {
                temp[one - j%one].append(str);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(temp[i]);
        }
        return result.toString();

    }
}

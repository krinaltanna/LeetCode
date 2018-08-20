/*

https://leetcode.com/problems/longest-palindromic-substring/

Maintain a 2D matrix a[][] of boolean
--a[i][j] = true if string from character i to character j is true
--All single characters are palindromes so all a[i][i] =true
then compare each element with next element and find number of same characters (plaindrones of size 2) a[i][i+1] = true id a[i]=a[i+1]
--now try finding higher sized palindronmes , a plaindrome is of length k where k = k-i if a[i]=a[j] and a[i+1][j-a]= true


*/


import java.util.*;
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] w = s.toCharArray();
        int start=0;
        int max=0;
        boolean[][] result = new boolean[n][n];
        if(s.length() == 0){
            return  null;
        }
        //all single characters are palindrome
        if(s.length() == 1){
            return s;
        }
        //palindromes of size 2 if 3 same charcters are adjacent
        for(int i =0; i<n; i++){
            result[i][i]= true; 
            max= 1;
        }
        for(int i= 0; i<n-1; i++){
            if(w[i] == w[i+1]){
                result[i][i+1]= true;
                start = i;
                max = 2;
                
            }
        }
        for(int k = 3; k<=n; k++){
            for(int i = 0; i<=n-k;i++){
                int j= i+k-1;
                if(result[i+1][j-1] == true && w[i]== w[j]){
                    result[i][j] = true;
                    if(k>max){
                        start = i;
                        max=k;
                    }
                }
            }
        }
        return s.substring(start,max+start);
        
        
    }
}

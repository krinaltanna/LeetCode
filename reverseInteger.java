//https://leetcode.com/problems/reverse-integer/description/



import java.io.*;
import java.util.*;
class Solution {
    public int reverse(int x) {
        boolean isNegative=false;
        if (x<0){
            isNegative=true;
            x=x*-1;
        }
        int max = (int) Math.pow(2,31);
        int min = max *-1;
        max=max-1;
        int result =0;
        while(x !=0){
            int unit = x%10;
            int prev = result;
            result = prev*10 + unit;
            //There is no way you can prevent Java compiler from returning garbage value when overflow happens, thats why compare the new                 //result with previous result to see that new value is not a garbage value
            if((result-unit)/10!=prev){
                return 0;
            }
            
            x=x/10;
        }
    /*    int unit = x%10;
            int prev = result;
            result = prev*10 + unit;
            if((result-unit)/10!=prev){
                return 0;
            }
     */
        if(isNegative){
            result = result *(-1);
        }
        return result;
   
    }
}

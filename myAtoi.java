//https://leetcode.com/problems/string-to-integer-atoi/description/





class Solution {
    public int myAtoi(String str) {
      //  int pow = Math.pow(2,31);
        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
        char[] s = str.toCharArray();
        int i =0;
        Character space =' ';
        int len = s.length;
        if(len==0){
            return 0;
        }
        //remove the preceding ' ' charcters
        while(i<len &&(s[i]==space)){
            i++;
        }
        //check if chaacter after spaces is + or - sign
        Character sign;
        boolean isNegative=false;
        if(i< len && (s[i] == '+' || s[i] == '-' )){
            sign=s[i];
            i=i+1;
            if(sign =='-'){                
                isNegative=true;
            }            
        }        
        int result=0;
       // int previous=0;
        //check if charcters in array are not between 0 and 9 (getNumbericValue should return between 0 and 9)
        while(i < len && Character.getNumericValue(s[i])<10 &&  Character.getNumericValue(s[i])>=0){
            int unit = Character.getNumericValue(s[i]);
            int previous=result;
            result=previous*10+unit;
            
            //check for overflow--if the value is 2147483647, there is double overflow i.e it reaches Int_max , so starts going to Int_min 
            //and while multiplying previous by 10 and then when you subtract negative it reach int_min and hence negative overflow will                 //start from Int-max which is equla to previous, and hence it returns the int_min as result
            if((result-unit*1.0)/10 != (double)previous){
                if(isNegative){
                    return INT_MIN;
                }
                else{
                    return INT_MAX;
                }
            }
            i++;
        }
        
        System.out.println(isNegative);
        if(isNegative){
            result= result*(-1);
        }
        return result;
    }
}

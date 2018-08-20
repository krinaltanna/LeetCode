/*

This is wrong approach
Will store in a 2D matrix ;
1st think  how to find a number of columns : consider the elements in first column = numRows then 1 in each column from bottom until it reaches top,the column where it reaches top will have numsRows elements 
so the entire matrix will be repitition of units of (1 + Numrows-2 columns) holding numows + numrows-2 elements, now we simply find num of columns = (s.length() * (1 + Numrows-2))/numows + numrows-2 which literally becomes s.length()/2
This calculation is futile if numRows > s.length()/2
*/

class Solution {
    public String convert(String s, int numRows) {
        int l = s.length();
        String[] arr = new String[numRows];
        boolean down=true;
        int row =0;
        if(numRows<=1){
            return s;
        }
        //this initialization is important or it will take nulkl value foe beganning of every row
        for(int i=0; i < numRows;i++){
            arr[i]= "";
        }
        for(int i = 0; i<l;i++){
            if(down){
                arr[row]=arr[row] +s.charAt(i);
                if(row==numRows-1){
                    down=false;
                    row=numRows-2;
                }
                else{
                    row++;
                }
            }
            else{
                arr[row]=arr[row] +s.charAt(i);
                if(row==0){
                    down= true;
                    row=1;
                }
                else{
                    row--;
                }
            }
        }
        //you can append the string  to first arr of element , and wont need a separate result variable
        String result="";
        for(int i =0; i < arr.length;i++){
            result = result + arr[i];
        }
        return result;        
    }
}

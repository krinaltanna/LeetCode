/*

Use hashMap to store characters and their indices
Maintain a starting pointer ns. All the elements between ns and i should be unique
The criteria to restart max and update ns would be the element is repeated and the index of repeated character is freator than ns
*/



class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len= s.length();
        int ns =0;
        HashMap<Character,Integer> letters = new HashMap<Character, Integer>();
        int max=0;
        if(len ==0){
            return 0;
        }
        if(len==1){
            return 1;
        }
        else{
            for(int i =0; i< len;i++){
                Character c=s.charAt(i);
                if(letters.containsKey(c) && letters.get(c)>=ns){
                    ns= letters.get(c)+1;
                    max = Math.max(max,i-ns+1);
                    letters.put(c,i);
                                    
                }
                else{
                    letters.put(c,i);
                    max = Math.max(max,i-ns+1);                    
                }
                
            }
            return max;
        }        
    }
}

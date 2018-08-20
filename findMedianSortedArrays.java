//https://leetcode.com/problems/median-of-two-sorted-arrays/description/

/*
if we merged two sorted arrays to maintain the sort , and then median fo the resultant will be answer
Since the time requirement is less than o(m+N), dont fill complete array, just  fill half the arrays (th)
Maintain 3 pointers i, j, k to track nums1, nums2, result array respectively
Fill the array aschendingly till either threshold is reached or either nums1 o rnums2 is exhausted using a while loop
Then if threshold is reached , median will be result[th]or average of result[th] and result[th-1]
If threshold is not reached , and either nums1 is exhausted or nums2, then fill the remaining array with elements of array which is next exchausted
The edge cases would be to select correct value of second last element of result and also to see that if last element of exhausting array is greator or smaller than next of element of remainder array

*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1= nums1.length;
        int l2 = nums2.length;
        int total = l1+ l2;
        boolean isEven = false;
        if (total%2==0){
            isEven =true;            
        }
        int th = total/2;
        int previous =0;
        int result=0;
       // int result[] = new int[th+1];
        int i=0;
        int j=0;
        int k=0;
        while(k<=th&& i <l1 && j<l2){ 
            previous=result;            
           if(nums1[i]> nums2[j]){               
               result=nums2[j];               
               // result[k] = nums2[j];
                j++;
            }
            else{
                //previous=result;
                result=nums1[i];
               //result[k]=nums1[i];
                i++;
            }
          //  System.out.println("r:" +result);
           // System.out.println("p:" +previous);
            k++; 
          //  System.out.println("k:" +k);
         }
        if(k<th+1 && i>=l1){
            if(k<=th-1){
                previous=(int)nums2[th-k+j-1]; 
               // result[th-1]=(int)nums2[th-k+j-1];                
            }
            else{
                 previous=result;
            }
           
            result=(int)nums2[th-k+j];
           // result[th]=(int)nums2[th-k+j];
        }
        else if(k<th+1 && j>=l2){
            if(k<=th-1){
                previous=(int)nums1[th-k+i-1];
               // result[th-1]=(int)nums1[th-k+i-1];                
            }
            else{
                previous =result;
                
            }
            
            result=(int)nums1[th-k+i];
            
            //result[th]=(int)nums1[th-k+i];
        }
        if(isEven){
           // System.out.println("fr: "+result);
            //System.out.println("fp:" +previous);
            return (double)(result+previous)/2;
           // return (double)(result[th]+result[th-1])/2;
        }
        else{
            return (double)result;
            //return (double)result[th];            
        }        
    }
}

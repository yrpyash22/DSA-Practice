class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    int i = m - 1;    // nums1 ke last element ka pointer , 2
    int j = n - 1;    //   nums2 ke last element ka pointer , 2
    int k = m + n - 1;  // nums1 ke last element ko pointer jo baad mai barega , 5 


        while (i >= 0 && j >= 0)      // (2 && 2) 
        {
            if (nums1[i] > nums2[j])  // (3>6) ,(3>5), (3>2), (2>2)  
            {
                nums1[k] = nums1[i];               //, k[3,5,6]                  
                i--;
            } else {
                nums1[k] = nums2[j];  //k[6], k[5,6],         k[2,3,5,6]
                j--;
            }
            k--;
        }

        // Agar nums2 me elements bach gaye
        while (j >= 0) 
        {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
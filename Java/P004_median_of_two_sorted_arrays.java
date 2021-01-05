public class P004_median_of_two_sorted_arrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    return sol_1(nums1, nums2);
  }

  public double sol_1(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    int median = 0;
    int medianCount = 0;
    
    if ((len1 + len2) % 2 == 1) {
      median = (len1 + len2 + 1) / 2;
      medianCount = 1;
    }
    else {
      median = (len1 + len2) / 2;
      medianCount = 2;
    }
    int divisor = medianCount;
    
    int index1 = 0, index2 = 0;
    int counter = 0;
    int sum = 0;
    while (medianCount > 0 && index1 < len1 && index2 < len2) {
      ++counter;
      if (nums1[index1] <= nums2[index2]) {
        if (counter == median) {
          sum += nums1[index1];
          --medianCount;
          median += 1;
        }
        ++index1;
      }
      else {
        if (counter == median) {
          sum += nums2[index2];
          --medianCount;
          median += 1;
        }
        ++index2;
      }
    }
    
    while (medianCount > 0 && index1 < len1) {
      ++counter;
      if (counter == median) {
        sum += nums1[index1];
        --medianCount;
        median += 1;
      }
      ++index1;
      
    }
  
    while (medianCount > 0 && index2 < len2) {
      ++counter;
      if (counter == median) {
        sum += nums2[index2];
        --medianCount;
        median += 1;
      }
      ++index2;
    }
    
    return (double) sum / divisor;
  }


  public static void main(String[] args) {
    P004_median_of_two_sorted_arrays p = new P004_median_of_two_sorted_arrays();
    int []a1 = {1, 3};
    int []b1 = {2};
    System.out.println(p.findMedianSortedArrays(a1, b1) == 2);

    int []a2 = {1, 2};
    int []b2 = {3, 4};
    System.out.println(p.findMedianSortedArrays(a2, b2) == 2.5);

    int []a3 = {1, 2, 3};
    int []b3 = {};
    System.out.println(p.findMedianSortedArrays(a3, b3) == 2);

    int []a4 = {1, 2};
    int []b4 = {};
    System.out.println(p.findMedianSortedArrays(a4, b4) == 1.5);

    int []a5 = {};
    int []b5 = {1, 2};
    System.out.println(p.findMedianSortedArrays(a5, b5) == 1.5);

    int []a6 = {};
    int []b6 = {1, 2, 3};
    System.out.println(p.findMedianSortedArrays(a6, b6) == 2);
  }
}

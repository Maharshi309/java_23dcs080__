import java.util.*; 
class Count9{
public static int array_count9(int[] nums)
 { int count = 0;
for (int num : nums) {
     if (num == 9) {
count++;
}
}
return count;
}
public static void main(String[] args)
 { int[] nums1 = {1, 2, 9};
int[] nums2 = {1, 9, 9};
int[] nums3 = {1, 9, 9, 3, 9};
System.out.println("number of 9 in {1,2,9} array:"+ array_count9(nums1)); // Output: 1
System.out.println("number of 9	in {1,9,9} array:"+ array_count9(nums2)); // Output: 2
System.out.println("number of 9	in {1,9,9,3,9} array:"+array_count9(nums3)); // Output: 3
System.out.println("23DCS080 Maharshi Patel ");


}
}

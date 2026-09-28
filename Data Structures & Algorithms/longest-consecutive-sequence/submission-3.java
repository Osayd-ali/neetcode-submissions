// Input: An array of integers nums
// Output: return the length of the longest consecutive sequence of elements that can be formed

// Consecutive sequence means a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array

// Basically trying to find the longest sequence of elements thats not necessarily continous. where each element is exactly 1 greater than the previous element. 

// For the basic solution, we can have a nested loop approach
// The outer loop selects one element, then the inner loop looks for an element which is exactly 1 greater than the outer loop's selected element. 
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}

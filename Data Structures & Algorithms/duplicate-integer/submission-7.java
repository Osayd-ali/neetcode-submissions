class Solution {
    public boolean hasDuplicate(int[] nums) {
    // if array contains duplicates then return true otherwise return false
    // the case of finding duplicates then use a hashset as hashset stores all unqiue elements
    // access each element and add it to the hashset, if set contains that element return true otherwise return false
    Set<Integer> set = new HashSet<>();
    for(int i=0; i<nums.length; i++){
        if(set.contains(nums[i])){
            return true; // duplicate indeed exists
        }
        set.add(nums[i]);
    }
    return false;
    }
}
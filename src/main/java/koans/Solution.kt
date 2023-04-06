package koans

internal class Solution {
  fun rotate(nums: IntArray, k: Int) {
    val a = IntArray(nums.size)
    for (i in nums.indices) {
      a[(i + k) % nums.size] = nums[i]
    }
    for (i in nums.indices) {
      nums[i] = a[i]
    }
  }
}
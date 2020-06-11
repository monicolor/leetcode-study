package com.colorx.easy;

import java.util.stream.Stream;

/**
 * @author colorx
 * @version 1.0
 * @date 2020/6/10 19:15
 *
 * * Input: numbers={2, 7, 11, 15}, target=9
 * * Output: index1=1, index2=2
 * * 题目描述：在有序数组中找出两个数，使它们的和为 target。
 * *
 * * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 * *
 * * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
 * * 如果 sum > target，移动较大的元素，使 sum 变小一些；
 * * 如果 sum < target，移动较小的元素，使 sum 变大一些。
 * * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        if (result != null){
            for (Integer integer : result) {
                System.out.println(integer);
            }
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) {
            return null;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}

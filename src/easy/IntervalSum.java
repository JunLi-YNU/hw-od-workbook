package easy;

import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月10日 21:40:31
 * @version: 1.0
 * @Description:
 * 题目描述
 * 给定一个含有N个正整数的数组, 求出有多少个连续区间（包括单个正整数）, 它们的和大于等于x。
 * 输入描述
 * 第一行两个整数N x（0 < N <= 100000, 0 <= x <= 10000000)
 * 第二行有N个正整数（每个正整数小于等于100)。  输出描述 输出一个整数，表示所求的个数。
 * 用例1
 * 输入  3 7 3 4 7
 * 输出  4
 * 第一行的3表示第二行数组输入3个数，第一行的7是比较数，
 * 用于判断连续数组是否大于该数；组合为 3 + 4; 3 + 4 + 7; 4 + 7; 7;
 * 都大于等于指定的7；所以共四组.
 */
public class IntervalSum {
    public static void main(String[] args) {
        getIntervalSum();
//        slideWindow();
    }

    private static void getIntervalSum() {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();
        int targetSum = scanner.nextInt();
        int[] nums = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            nums[i] = scanner.nextInt();
        }
        int targetSumCount = 0;
        int index = 0;

        while (index < nums.length){
            int sum = 0 ;
            for (int i = index; i < nums.length; i++) {
                sum += nums[i];
                if(sum >= targetSum){
                    targetSumCount++;
                }
            }
            index++;
        }
        System.out.println(targetSumCount);
        scanner.close();
    }

    private static void slideWindow(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
        int left = 0; // 滑动窗口的左端点
        int right = 0; // 滑动窗口的右端点
        int count = 0; // 记录连续区间个数
        int sum = 0; // 记录当前区间的和
        while (right < n) {
            sum += nums[right];
            while (sum >= x) {
                // 如果当前区间和大于等于x，那么以left为起点的所有连续区间都符合要求
                count += n - right;
                sum -= nums[left];
                left++;
            }
            right++;
        }
        System.out.println(count);
    }
}

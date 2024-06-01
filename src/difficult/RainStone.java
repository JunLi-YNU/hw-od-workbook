package difficult;

import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月08日 16:48:28
 * @version: 1.0
 * @Description: MELON有一堆精美的雨花石（数量为n，重量各异），准备送给S和W。
 * MELON希望送给俩人的雨花石重量一致，请你设计一个程序，帮MELON确认是否能将雨花石平均分配。
 * 输入描述
 * 第1行输入为雨花石个数: n，0 < n < 31.
 * 第2行输入为空格分割的各雨花石重量: m[0] m[1] … m[n - 1]， 0 < m[k] < 1001  不需要考虑异常输入的情况。
 * 输出描述
 * 如果可以均分，从当前雨花石中最少拿出几块，可以使两堆的重量相等:如果不能均分，则输出-1。
 */
public class RainStone {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] stones = new int[n];
//        int totalWeight = 0;
//        for (int i = 0; i < n; i++) {
//            int oneStone = scanner.nextInt();
//            stones[i] = oneStone;
//            totalWeight += oneStone;
//        }
//        if (totalWeight % 2 != 0) {
//            System.out.println("-1");
//        } else {
//            //目标重量
//            int targetWeight = totalWeight / 2;
//            int[] stonesTargetWeight = new int[targetWeight + 1];
//            for (int i = 1; i < targetWeight + 1; i++) {
//                stonesTargetWeight[i] = n;
//            }
//            for (int i = 1; i < n; i++) {
//                int weight = stones[i - 1];
//            }
//
//        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 输入雨花石个数
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = scanner.nextInt();  // 输入雨花石重量
        }
        int totalWeight = 0;
        for (int stone : stones) {
            totalWeight += stone;  // 计算雨花石总重量
        }
        if (totalWeight % 2 != 0) {  // 如果总重量为奇数，无法均分
            System.out.println(-1);
        } else {
            int targetWeight = totalWeight / 2;  // 目标重量为总重量的一半
            // 创建动态规划数组，dp[i]表示前i块雨花石中是否能够取出一些雨花石使得重量和为j
            int[] dp = new int[targetWeight + 1];
            // 初始化dp数组，将除了dp[0]之外的其他元素设置为n，表示最坏情况下需要拿出所有雨花石
            for (int i = 1; i <= targetWeight; i++) {
                dp[i] = n;
            }
            // 遍历每一块雨花石
            for (int i = 0; i < n; i++) {
                int weight = stones[i];  // 当前雨花石的重量
                // 从目标重量开始递减，更新dp数组
                for (int j = targetWeight; j >= weight; j--) {
                    // 如果当前重量可以由前面的雨花石组成，更新dp[j]为最小需要拿出的雨花石数量
                    dp[j] = Math.min(dp[j], dp[j - weight] + 1);
                    System.out.println();
                    for (int x : dp
                    ) {
                        System.out.print(x +",");
                    }
                    System.out.println();
                }
            }
            // 如果dp[targetWeight]仍然等于n，表示无法找到满足条件的雨花石组合
            if (dp[targetWeight] == n) {
                System.out.println(-1);
            } else {
                // 输出最少需要拿出的雨花石数量
                System.out.println(dp[targetWeight]);
            }
        }


    }
}

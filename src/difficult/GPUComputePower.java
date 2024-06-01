package difficult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月08日 21:15:43
 * @version: 1.0
 * @Description: 题目描述 现有两组服务器A和B，每组有多个算力不同的CPU，
 * 其中 A[i] 是 A 组第 i 个CPU的运算能力，B[i] 是 B组 第 i 个CPU的运算能力。
 * 一组服务器的总算力是各CPU的算力之和。  为了让两组服务器的算力相等，允许从每组各选出一个CPU进行一次交换，
 * 求两组服务器中，用于交换的CPU的算力，并且要求从A组服务器中选出的CPU，算力尽可能小。
 * 输入描述
 * 第一行输入为L1和L2，以空格分隔，L1表示A组服务器中的CPU数量，L2表示B组服务器中的CPU数量。
 * 第二行输入为A组服务器中各个CPU的算力值，以空格分隔。
 * 第三行输入为B组服务器中各个CPU的算力值，以空格分隔。
 * 1 ≤ L1 ≤ 10000 1 ≤ L2 ≤ 10000 1 ≤ A[i] ≤ 100000 1 ≤ B[i] ≤ 100000
 * 输出描述
 * 对于每组测试数据，输出两个整数，以空格分隔，依次表示A组选出的CPU算力，B组选出的CPU算力。
 * 要求从A组选出的CPU的算力尽可能小。
 */
public class GPUComputePower {
    public static void main(String[] args) {
        gpuComputePower();
    }

    private static void gpuComputePower() {
        Scanner scanner = new Scanner(System.in);
        int gpuServiceACount = scanner.nextInt();
        int gpuServiceBCount = scanner.nextInt();
        System.out.println(gpuServiceBCount);
        System.out.println(gpuServiceACount);
        int[] gpuServiceAArr = new int[gpuServiceACount];
        HashMap<Integer, Integer> gpuServiceBArr = new HashMap<>();

        int serviceAPower = 0;
        int serviceBPower = 0;
        for (int i = 0; i < gpuServiceACount; i++) {
            int power = scanner.nextInt();
            gpuServiceAArr[i] = power;
            serviceAPower += power;
        }
        Arrays.sort(gpuServiceAArr);

        for (int i = 0; i < gpuServiceBCount; i++) {
            int power = scanner.nextInt();
            serviceBPower += power;
            gpuServiceBArr.put(power, gpuServiceBArr.getOrDefault(power, 0) + 1);
        }
        int sub = (int) Math.round((serviceAPower - serviceBPower) / 2.0);
        for (int powerA : gpuServiceAArr) {
            int powerB = powerA - sub;
            if(gpuServiceBArr.containsKey(powerB) && gpuServiceBArr.get(powerB) > 0){
                System.out.println(powerA + " " + powerB);
                break;
            }
        }

//        int sub = (serviceAPower - serviceBPower) / 2;
//
//        System.out.println(sub);
//        if (sub > 0) {
//            for (int j : gpuServiceAArr) {
//                for (int k : gpuServiceBArr) {
//                    if ((j - sub) == k) {
//                        System.out.println(j + " " + k);
//                        break;
//                    }
//                }
//            }
//        }else {
//            for (int j : gpuServiceBArr) {
//                for (int k : gpuServiceAArr) {
//                    if ((j + sub) == k) {
//                        System.out.println(k + " " + j);
//                        break;
//                    }
//                }
//            }
//        }
    }

    private static void trueMethod() {
        // 创建扫描器读取输入
        Scanner scanner = new Scanner(System.in);
        // 读取A组和B组的服务器数量
        int serverCountGroupA = scanner.nextInt();
        int serverCountGroupB = scanner.nextInt();
        // 初始化A组的总算力为0
        int totalPowerGroupA = 0;
        // 创建数组存储A组的服务器算力
        int[] powerGroupA = new int[serverCountGroupA];
        // 读取A组的服务器算力，并计算总算力
        for (int i = 0; i < serverCountGroupA; i++) {
            powerGroupA[i] = scanner.nextInt();
            totalPowerGroupA += powerGroupA[i];
        }
        // 初始化B组的总算力为0
        int totalPowerGroupB = 0;
        // 创建HashMap存储B组的服务器算力和对应的数量
        HashMap<Integer, Integer> powerCountGroupB = new HashMap<>();
        // 读取B组的服务器算力，并计算总算力
        for (int i = 0; i < serverCountGroupB; i++) {
            int power = scanner.nextInt();
            totalPowerGroupB += power;
            powerCountGroupB.put(power, powerCountGroupB.getOrDefault(power, 0) + 1);
        }
        // 计算两组总算力差的一半，四舍五入取整
        int halfDifference = (int) Math.round((totalPowerGroupA - totalPowerGroupB) / 2.0);
        // 对A组的服务器算力进行排序
        Arrays.sort(powerGroupA);
        // 从小到大遍历A组的服务器
        // 从小到大遍历A组的服务器
        for (int powerA : powerGroupA) {
            // 计算需要在B组中找到的服务器算力
            int powerB = powerA - halfDifference;
            // 如果B组中存在这样的服务器，并且数量大于0
            if (powerCountGroupB.containsKey(powerB) && powerCountGroupB.get(powerB) > 0) {
                // 输出A组和B组选出的服务器的算力
                System.out.println(powerA + " " + powerB);
                break;
            }
        }
    }
}

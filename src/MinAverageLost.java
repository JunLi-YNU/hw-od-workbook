import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月13日 14:42:36
 * @version: 1.0
 * @Description: 题目描述
 * 服务之间交换的接口成功率作为服务调用关键质量特性，某个时间段内的接口失败率使用一个数组表示，
 * <p>
 * 数组中每个元素都是单位时间内失败率数值，数组中的数值为0~100的整数，
 * <p>
 * 给定一个数值(minAverageLost)表示某个时间段内平均失败率容忍值，即平均失败率小于等于minAverageLost，
 * <p>
 * 找出数组中最长时间段，如果未找到则直接返回NULL。
 * <p>
 * 输入描述
 * 输入有两行内容，第一行为{minAverageLost}，第二行为{数组}，数组元素通过空格(” “)分隔，
 * <p>
 * minAverageLost及数组中元素取值范围为0~100的整数，数组元素的个数不会超过100个。
 * <p>
 * 输出描述
 * 找出平均值小于等于minAverageLost的最长时间段，输出数组下标对，格式{beginIndex}-{endIndx}(下标从0开始)，
 * <p>
 * 如果同时存在多个最长时间段，则输出多个下标对且下标对之间使用空格(” “)拼接，多个下标对按下标从小到大排序。
 */
public class MinAverageLost {
    public static void main(String[] args) {
        printMinAverageLost();
    }

    private static void printMinAverageLost() {
        Scanner scanner = new Scanner(System.in);
        int minAverage = scanner.nextInt();
        scanner.nextLine();
        int[] numArrays = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<int[]> arrayList = new ArrayList<>();
        int target = 0;
        int count = 0;
        for (int i = 0; i < numArrays.length; i++) {
            for (int j = i; j < numArrays.length; j++) {
                count = count + 1;
                target += numArrays[j];
                if (j > i) {
                    int currentAverage = (int) Math.ceil(target * 1.0 / count);
                    if (currentAverage <= minAverage) {
                        System.out.println("i:" + i + " j:" + j + " target:" + target +
                                " count:" + count + " minAverage:" + minAverage
                                + " currentAverage:" + currentAverage);
                        arrayList.add(new int[]{i, j});
                    }
                }
            }
            count = 0;
            target = 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int[] targetIndex : arrayList) {
            hashMap.put(targetIndex[0], Math.max(hashMap.getOrDefault(targetIndex[0], 0), targetIndex[1]));
        }
        System.out.println();
        if (hashMap.isEmpty()) {
            System.out.println("NULL");
        } else {
            for (Map.Entry<Integer, Integer> targetIndex : hashMap.entrySet()) {
                System.out.print(targetIndex.getKey() + "-" + targetIndex.getValue() + " ");
            }
        }//最后留下的人
    }
}

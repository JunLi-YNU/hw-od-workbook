import java.io.Serial;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月13日 14:12:38
 * @version: 1.0
 * @Description: 题目描述
 * 已知连续正整数数列{K}=K1,K2,K3…Ki的各个数相加之和为S，i=N (0<S<100000, 0<N<100000), 求此数列K。
 * <p>
 * 输入描述
 * 输入包含两个参数，1）连续正整数数列和S，2）数列里数的个数N。
 * <p>
 * 输出描述
 * 如果有解输出数列K，如果无解输出-1。
 * <p>
 * 用例
 * 输入	525 6
 * 输出	85 86 87 88 89 90
 * 说明	无
 */
public class DoublePoint {
    public static void main(String[] args) {
        printSerial();
    }

    private static void printSerial() {
        Scanner scanner = new Scanner(System.in);
        int targetSum = scanner.nextInt();
        int numCount = scanner.nextInt();
        StringBuilder targetSerial = new StringBuilder();
        int i = 0;
        while (true) {
            int currentSum = 0;
            for (int j = i; j < i + numCount; j++) {
                currentSum += j;
            }
            if (currentSum == targetSum) {
                for (int j = i; j < i + numCount; j++) {
                    targetSerial.append(j).append(" ");
                }
                break;
            }
            if (currentSum > targetSum){
                System.out.println(-1);
                break;
            }
            i++;
        }
        System.out.println(targetSerial);
    }
}

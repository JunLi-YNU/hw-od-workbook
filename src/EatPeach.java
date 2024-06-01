import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月13日 12:55:58
 * @version: 1.0
 * @Description: 题目描述
 * 孙悟空爱吃蟠桃，有一天趁着蟠桃园守卫不在来偷吃。已知蟠桃园有 N 棵桃树，每颗树上都有桃子，守卫将在 H 小时后回来。
 * <p>
 * 孙悟空可以决定他吃蟠桃的速度K（个/小时），每个小时选一颗桃树，并从树上吃掉 K 个，如果树上的桃子少于 K 个，则全部吃掉，并且这一小时剩余的时间里不再吃桃。
 * <p>
 * 孙悟空喜欢慢慢吃，但又想在守卫回来前吃完桃子。
 * <p>
 * 请返回孙悟空可以在 H 小时内吃掉所有桃子的最小速度 K（K为整数）。如果以任何速度都吃不完所有桃子，则返回0。
 * <p>
 * 输入描述
 * 第一行输入为 N 个数字，N 表示桃树的数量，这 N 个数字表示每颗桃树上蟠桃的数量。
 * <p>
 * 第二行输入为一个数字，表示守卫离开的时间 H。
 * <p>
 * 其中数字通过空格分割，N、H为正整数，每颗树上都有蟠桃，且 0 < N < 10000，0 < H < 10000。
 * <p>
 * 输出描述
 * 吃掉所有蟠桃的最小速度 K，无解或输入异常时输出 0。
 * <p>
 * 用例1
 * 输入	2 3 4 5
 * 4
 * 输出	5
 * 说明	无
 */
public class EatPeach {
    public static void main(String[] args) {
        printMinSpeed();
    }

    private static void printMinSpeed() {
        Scanner scanner = new Scanner(System.in);
        int[] everyPeachCounts = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int usableTime = scanner.nextInt();
        int n = everyPeachCounts.length;

        if (n == 0 || usableTime <= 0 || usableTime >= 10000 || n >= 10000 || n > usableTime) {
            System.out.println(0);
            return;
        }
        //初始化二分查找边界
        int left = 1, right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(everyPeachCounts, usableTime, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean canFinish(int[] everyPeachCounts, int usableTime, int mid) {
        int ans = 0;
        for (int peachCount : everyPeachCounts
        ) {
            ans += (int) Math.ceil(peachCount * 1.0 / mid);
        }
        System.out.println(ans + ":" + mid);
        return ans <= usableTime;
    }
}

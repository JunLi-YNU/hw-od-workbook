import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月14日 10:41:50
 * @version: 1.0
 * @Description:
 */
public class MaxNormalCycle {
    public static void main(String[] args) {
        printMaxNormalCycle();
    }

    private static void printMaxNormalCycle() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//故障确认周期数
        int t = scanner.nextInt();//确认工具故障数
        int p = scanner.nextInt();//故障恢复周期数
//        int[] s = Arrays.stream(scanner.nextLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
        scanner.nextLine();
        Integer[] a = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(m, t, p, a));
//        int tCount = 0;//故障次数
//        int pCount = 0;//故障恢复周期
//        boolean isFailure = false;
//        int startNormalIndex = 0;
//        int endNormalIndex = 0;
//        for (int i = 0; i < s.length; i++) {
//                if (i == 0 && s[i] <= 0) {
//                    tCount++;
//                } else {
//                    if (s[i] <= 0 || s[i] < s[i - 1] || s[i] - s[i - 1] >= 10) {
//                        isFailure = true;
//                        tCount++;
//                        pCount = 0;
//                    } else {
//                        pCount++;
//                        if(pCount == p){
//                            startNormalIndex = i-3;
//                            isFailure = false;
//                        }
//                    }
//
//                }
//                if(tCount <=  t ){
//
//                }
//            i = startNormalIndex;
//            }
    }

    /**
     * @param m 故障确认周期数
     * @param t 故障次数门限值
     * @param p 故障恢复周期数
     * @param s 数组，元素是每个周期的采样数据
     * @return 最长连续周期的长度
     */
    public static int getResult(Integer m, Integer t, Integer p, Integer[] s) {
        int i = 0; // 连续正常周期的起始位置
        int fault = 0; // m个周期内错误数据的个数
        int cycle = 0; // 处于m个周期内第几个周期
        int ans = 0; // 最终结果，即最长连续正常周期长度

        // 如果采样数据一开始就是错误的，则直接丢弃
        while (s[i] <= 0) {
            // i指针后移，表示前面区间不属于连续正常周期范围
            i++;
            // 虽然错误数据被丢弃，但是仍然属于m周期内的出现的错误数据，因此需要计数
            fault++;
            cycle++;

            // 如果在m周期范围内，错误数据数量达到门限t，则工具故障，并进入故障恢复检测阶段
            if (cycle <= m) {
                if (cycle == m) {
                    cycle = 0;
                    fault = 0;
                }

                if (fault == t) {
                    cycle = 0;
                    fault = 0;
                    int p1 = p;
                    while (i < s.length && p1 > 0) {
                        // 故障恢复条件是，p个周期内一直都是正常数据，并要求连续，如果不连续，则重新计数
                        if (isFault(s, i)) {
                            p1 = p;
                        } else {
                            p1--;
                        }
                        i++;
                    }
                }
            }
        }

        // 这个cycle计数对应第i周期的
        cycle++;
        int j = i + 1;

        while (j < s.length) {
            cycle++; // 这个cycle计数对应第j周期的
            if (isFault(s, j)) {
                s[j] = s[j - 1];
                fault++;
            }

            j++;

            if (cycle <= m) {
                if (cycle == m) {
                    cycle = 0;
                    fault = 0;
                }

                if (fault == t) {
                    cycle = 0;
                    fault = 0;
                    ans = Math.max(ans, j - i); // 注意此时的j必然是故障开始的j，因此不计入正常连续周期中，因此求长度时不需要+1
                    // 发现故障，故障开始，进行故障恢复判断
                    int p1 = p;
                    while (j < s.length && p1 > 0) {
                        // 故障恢复条件是，p个周期内一直都是正常数据，要求连续
                        if (isFault(s, j)) {
                            p1 = p;
                        } else {
                            p1--;
                        }
                        i = j;
                    }
                }
            }
        }

        ans = Math.max(ans, j - i); // 注意这里的j必然是越界的j，因此求长度时不需要+1
        return ans;
    }

    // 该方法用于判断数据是否错误
    public static boolean isFault(Integer[] s, int j) {
        return s[j] <= 0 || (j >= 1 && (s[j] < s[j - 1] || s[j] - s[j - 1] >= 10));

    }
}

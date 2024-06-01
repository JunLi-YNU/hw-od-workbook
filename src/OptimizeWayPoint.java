import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月12日 18:47:37
 * @version: 1.0
 * @Description: 输入描述
 * 2 8 3 7 3 6 3 5 4 4 5 3 6 2 7 3 8 4 7 5  1、
 * 所有数字以空格分隔，每两个数字一组，第一个数字是行号，第二个数字是列号；
 * 2、行号和列号范围为[0,64)，用例输入保证不会越界，考生不必检查；
 * 3、输入数据至少包含两个坐标点。
 * 输出描述
 * 2 8 3 7 3 5 6 2 8 4 7 5
 * 压缩后的最简化坐标列表，和输入数据的格式相同。
 * 备注: 输出的坐标相对顺序不能变化。
 */
public class OptimizeWayPoint {
    public static void main(String[] args) {
        printOptimizeWayPoint();
    }

    private static void printOptimizeWayPoint() {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println();
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        List<int[]> wayPoints = new ArrayList<>();
        boolean mark = true;
        for (int i = 0; i < nums.length; i++) {
            wayPoints.add(new int[]{nums[i], nums[++i]});
        }
        for (int[] s : wayPoints
        ) {
            System.out.println(s[0] + ":" + s[1]);
        }
        List<int[]> targetWayPoints;
        targetWayPoints = getTargetWayPoint(wayPoints);
        System.out.println();
        for (int[] point : targetWayPoints
        ) {
            System.out.print(point[0] + " ");
            System.out.print(point[1] + " ");
        }
    }

    private static List<int[]> getTargetWayPoint(List<int[]> wayPoints) {
        List<int[]> targetWayPoints = new ArrayList<>();
        targetWayPoints.add(wayPoints.get(0));
        for (int i = 1; i < wayPoints.size() - 1; i++) {
            if (isTurningPoint(wayPoints.get(i - 1), wayPoints.get(i), wayPoints.get(i + 1))) {
                targetWayPoints.add(wayPoints.get(i));
            }
        }
        targetWayPoints.add(wayPoints.get(wayPoints.size() - 1));
        return targetWayPoints;
    }

    private static boolean isTurningPoint(int[] prePoint, int[] currPoint, int[] nextPoint) {
        int x1 = currPoint[0] - prePoint[0];
        int y1 = currPoint[1] - prePoint[1];
        int x2 = nextPoint[0] - currPoint[0];
        int y2 = nextPoint[1] - currPoint[1];
        return x1 * y2 != x2 * y1;
    }
}

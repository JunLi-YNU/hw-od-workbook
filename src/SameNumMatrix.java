import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月11日 20:15:29
 * @version: 1.0
 * @Description: 题目描述
 * 从前有个村庄，村民们喜欢在各种田地上插上小旗子，旗子上标识了各种不同的数字。
 * 某天集体村民决定将覆盖相同数字的最小矩阵形的土地分配给村里做出巨大贡献的村民，
 * 请问此次分配土地，做出贡献的村民种最大会分配多大面积?
 * 输入描述
 * 第一行输入 m 和 n，  m 代表村子的土地的长 n 代表土地的宽 第二行开始输入地图上的具体标识
 * 输出描述
 * 此次分配土地，做出贡献的村民种最大会分配多大面积
 * 备注 旗子上的数字为1~500，土地边长不超过500  未插旗子的土地用0标识
 * 用例1
 * 输入
 * 3 3
 * 1 0 1
 * 0 0 0
 * 0 1 0
 * 输出
 * 9
 * 说明  土地上的旗子为1，其坐标分别为(0,0)，(2,1)以及(0,2)，为了覆盖所有旗子，
 * 矩阵需要覆盖的横坐标为0和2，纵坐标为0和2，所以面积为9，即（2-0+1）*（2-0+1）= 9
 */
public class SameNumMatrix {
    public static void main(String[] args) {
        getMatrixArea();
    }

    private static void getMatrixArea() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] areaS = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                areaS[i][j] = scanner.nextInt();
            }
        }

        // 使用哈希表来存储每个数字的最小和最大位置
        Map<Integer, int[]> minPos = new HashMap<>();
        Map<Integer, int[]> maxPos = new HashMap<>();
        for (int i = 0; i < x ; i++) {
            for (int j = 0; j < y; j++) {
                int num = areaS[i][j];
                if (num != 0) {
                    if (!minPos.containsKey(num)) {
                        minPos.put(num, new int[]{i, j});
                        maxPos.put(num, new int[]{i, j});
                    } else {
                        minPos.get(num)[0] = Math.min(minPos.get(num)[0], i);
                        minPos.get(num)[1] = Math.min(minPos.get(num)[1], j);
                        maxPos.get(num)[0] = Math.max(minPos.get(num)[0], i);
                        maxPos.get(num)[1] = Math.max(minPos.get(num)[1], j);
                    }
                }
            }
        }

        int maxArea = 1;
        for (Integer num:maxPos.keySet()
        ) {
            int minX = minPos.get(num)[0];
            int minY = minPos.get(num)[1];
            int maxX = maxPos.get(num)[0];
            int maxY = maxPos.get(num)[1];
            int area = (maxX - minX + 1) * (maxY - minY + 1);
            maxArea = Math.max(maxArea,area);
        }
        System.out.println(maxArea);
    }
}

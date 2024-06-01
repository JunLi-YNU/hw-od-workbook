package difficult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月11日 10:42:33
 * @version: 1.0
 * @Description: 题目描述
 * 小华和小为是很要好的朋友，他们约定周末一起吃饭。 通过手机交流，他们在地图上选择了多个聚餐地点（
 * 由于自然地形等原因，部分聚餐地点不可达），求小华和小为都能到达的聚餐地点有多少个？
 * 输入描述
 * 第一行输入m和n，m代表地图的长度，n代表地图的宽度。
 * 第二行开始具体输入地图信息，地图信息包含：
 * 0 为通畅的道路
 * 1 为障碍物（且仅1为障碍物）
 * 2 为小华或者小为，地图中必定有且仅有2个 （非障碍物）
 * 3 为被选中的聚餐地点（非障碍物）
 * 输出描述
 * 可以被两方都到达的聚餐地点数量，行末无空格。
 * 用例 输入	4 4
 * 2 1 0 3
 * 0 1 2 1
 * 0 3 0 0
 * 0 0 0 0
 * 输出
 * 2
 * 说明
 * 第一行输入地图的长宽为3和4。
 * 第二行开始为具体的地图，
 * 其中：3代表小华和小明选择的聚餐地点；
 * 2代表小华或者小明（确保有2个）；
 * 0代表可以通行的位置；
 * 1代表不可以通行的位置。
 * 此时两者能都能到达的聚餐位置有2处。
 * 输入
 * 4 4
 * 2 1 2 3
 * 0 1 0 0
 * 0 1 0 0
 * 0 1 0 0
 * 输出	0
 * 说明
 * 第一行输入地图的长宽为4和4。
 * 第二行开始为具体的地图，
 * 其中：
 * 3代表小华和小明选择的聚餐地点；
 * 2代表小华或者小明（确保有2个）；
 * 0代表可以通行的位置；
 * 1代表不可以通行的位置。
 * 由于图中小华和小为之间有个阻隔，此时，没有两人都能到达的聚餐地址，故而返回0。
 * 备注：
 * 地图的长宽为m和n，其中：  4 <= m <= 100  4 <= n <= 100
 * 聚餐的地点数量为 k，则  1< k <= 100
 */
public class EatPlace {
    // 定义四个方向的偏移量（上、下、左、右）
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    // 深度优先搜索函数
    private static boolean dfs(int currX, int currY, int targetX, int targetY, int[][] map, boolean[][][] visited, int person) {
        // 如果当前位置就是目标位置，返回true
        if (currX == targetX && currY == targetY) {
            return true;
        }
        // 遍历四个方向
        for (int[] dir : dirs) {
            int nextX = currX + dir[0], nextY = currY + dir[1];
            // 如果下一个位置超出地图范围，或者是障碍物，或者已经访问过，跳过
            if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length || map[nextX][nextY] == 1 || visited[nextX][nextY][person]) {
                continue;
            }
            // 标记下一个位置为已访问
            visited[nextX][nextY][person] = true;
            // 递归搜索下一个位置
            if (dfs(nextX, nextY, targetX, targetY, map, visited, person)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        getEatPlaceCount();
    }

    private static void getEatPlaceCount() {
        // 输入初始化
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] map = new int[m][n];
        // 使用三维数组visited来记录每个人访问过的位置
        boolean[][][] visited = new boolean[m][n][2];
        List<int[]> persons = new ArrayList<>();
        List<int[]> targets = new ArrayList<>();
        // 读取地图信息，并记录小华和小为的位置以及聚餐地点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 2) {
                    persons.add(new int[]{i, j});
                } else if (map[i][j] == 3) {
                    targets.add(new int[]{i, j});
                }
            }
        }
        // 获取小华和小为的位置
        int[] xiaohua = persons.get(0);
        int[] xiaowei = persons.get(1);
        int res = 0;
        // 遍历所有聚餐地点
        for (int[] target : targets) {
            // 重置visited数组
            visited = new boolean[m][n][2];
            // 判断小华是否能到达目标位置
            if (dfs(xiaohua[0], xiaohua[1], target[0], target[1], map, visited, 0)) {
                // 重置visited数组
                visited = new boolean[m][n][2];
                // 判断小为是否能到达目标位置
                if (dfs(xiaowei[0], xiaowei[1], target[0], target[1], map, visited, 1)) {
                    // 如果两个人都能到达目标位置，结果加1
                    res++;
                }
            }
        }
        // 输出可以被两人都到达的聚餐地点数量
        System.out.println(res);
        scanner.close();
    }

    private static int[][] mDirs = {{-1, 0}, {1, 0}, {0, -1, 0, 1}};

    private static boolean mDfs(int currentX, int currentY, int targetX, int targetY, int[][] map,
                                boolean[][][] visited, int person) {
        //
        if (currentX == targetX && currentY == targetY) {
            return true;
        }
        for (int[] dir : mDirs
        ) {
            int nextX = currentX + dir[0], nextY = currentY + dir[1];
            // 如果下一个位置超出地图范围，或者是障碍物，或者已经访问过，跳过
            if (nextX > 0 || nextY > 0 || nextX >= map.length ||
                    nextY >= map[0].length || map[nextX][nextY] == 1 || visited[nextX][nextY][person]) {
                continue;
            }
            // 标记下一个位置为已访问
            visited[nextX][nextY][person] = true;
            // 递归搜索下一个位置
            if (dfs(nextX, nextY, targetX, targetY, map, visited, person)) {
                return true;
            }
        }
        return false;
    }
}

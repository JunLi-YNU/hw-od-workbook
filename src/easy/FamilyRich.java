package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月10日 18:08:17
 * @version: 1.0
 * @Description: 题目描述
 * 在一棵树中，每个节点代表一个家庭成员，节点的数字表示其个人的财富值，
 * 一个节点及其直接相连的子节点被定义为一个小家庭。  现给你一棵树，
 * 请计算出最富裕的小家庭的财富和。
 * 输入描述
 * 第一行为一个数N，表示成员总数，成员编号1-N,1<=N<=1000
 * 第二行为N个空格分隔的数，表示编号1-N的成员的财富值。0<=财富值<=1000000
 * 接下来N-1行，每行两个空格分隔的整数(N1N2)，表示N1是N2的父节点。
 * 输出描述
 * 最富裕的小家庭的财富和
 */
public class FamilyRich {
    public static void main(String[] args) {
        getFamilyRich();
    }

    private static void getFamilyRich() {
        Scanner scanner = new Scanner(System.in);
        int nodeCount = scanner.nextInt();
        int[] nodeValue = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            nodeValue[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nodeCount - 1; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            hashMap.put(key, hashMap.getOrDefault(key,
                    nodeValue[key - 1]) + nodeValue[value - 1]);
            scanner.nextLine();
        }
        int targetMax = 0;
        for (int v : hashMap.values()
        ) {
            if (targetMax < v) {
                targetMax = v;
            }
        }
        System.out.println(targetMax);
    }
    //
}

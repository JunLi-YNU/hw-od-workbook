package easy;

import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月08日 18:47:48
 * @version: 1.0
 * @Description: 题目描述：用连续自然数之和来表达整数 （本题分值100）
 * 一个整数可以由连续的自然数之和来表示。
 * 给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式
 * <p>
 * 输入描述
 * 一个目标整数T (1 <=T<= 1000)
 * <p>
 * 输出描述
 * 该整数的所有表达式和表达式的个数。如果有多种表达式，输出要求为：
 * 自然数个数最少的表达式优先输出
 * 每个表达式中按自然数递增的顺序输出，具体的格式参见样例。
 * 在每个测试数据结束时，输出一行”Result:X”，其中X是最终的表达式个数。
 */
public class IntegerSum {
    public static void main(String[] args) {
        solution();
    }


    private static void solution() {
        Scanner scanner = new Scanner(System.in);
        int targetNum = scanner.nextInt();
        List<String> targetExpressions = new ArrayList<>();
        for (int i = 0; i <= targetNum; i++) {
            int sum = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = i; j <= targetNum; j++) {
                sum += j;
                stringBuilder.append(j).append("+");
                if (sum == targetNum) {
                    targetExpressions.add(targetNum + "="
                            + stringBuilder.substring(0, stringBuilder.length() - 1));
                    break;
                }
            }
        }
        targetExpressions.sort(Comparator.comparing(String::length));
        for (String targetExpression : targetExpressions
        ) {
            System.out.println(targetExpression);
        }

        System.out.println(targetExpressions.size());
    }
}

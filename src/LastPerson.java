import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月13日 17:16:52
 * @version: 1.0
 * @Description: 题目描述
 * 有n个人围成一圈，顺序排号为1-n。
 * <p>
 * 从第一个人开始报数(从1到3报数)，凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
 * <p>
 * 输入描述
 * 输入人数n（n < 1000）
 * <p>
 * 输出描述
 * 输出最后留下的是原来第几号
 * <p>
 * 用例
 * 输入	2
 * 输出	2
 * 说明	报数序号为1的人最终报3，因此序号1的人退出圈子，最后剩下序号为2的那位
 */
public class LastPerson {
    public static void main(String[] args) {
        printLastPerson();
    }

    private static void printLastPerson() {
        Scanner scanner = new Scanner(System.in);
        int personCount = scanner.nextInt();
        ArrayList<Integer> persons = new ArrayList<>();
        int cir = 3;
        for (int i = 1; i <= personCount; i++) {
            persons.add(i);
        }

        while (persons.size() > 1) {
            while (persons.size() > 1 && cir > 1) {
                System.out.println();
                for (int x : persons
                ) {
                    System.out.print(x + " ");
                }
                persons.add(persons.get(0));
                persons.remove(0);
                cir--;
            }
            // 当圈子中的人数小于等于1时，跳出循环
            if (persons.size() <= 1) {
                break;
            }
            // 当报数计数器为1时，移除报数为3的人，并重置报数计数器为3
            if (cir == 1) {
                persons.remove(0);
                cir = 3;
            }

        }
        // 输出最后留下的人的原始编号
        System.out.println();
        System.out.println(persons.get(0));
    }
}

import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月12日 18:02:08
 * @version: 1.0
 * @Description: 题目描述
 * 均衡串定义: 字符串只包含两种字符，且两种字符的个数相同。
 * 给定一个均衡字符串，请给出可分割成新的均衡子串的最大个数。
 * 约定字符串中只包含大写的X和Y两种字符。
 * 输入描述
 * 均衡串: XXYYXY 字符串的长度[2,100001]。给定的字符串均为均衡串
 * 输出描述
 * 可分割为两个子串: XXYY XY  备注 分割后的子串，是原字符串的连续子串。//优化
 */
public class SameElementString {
    public static void main(String[] args) {
        printlnSameElementCountString();
    }

    private static void printlnSameElementCountString() {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();
        char[] chars = inputStr.toCharArray();

        char x = 'X';
        char y = 'Y';
        int xCount = 0;
        int yCount = 0;
        int count = 0;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
            if (chars[i] == x) {
                xCount++;
            } else {
                yCount++;
            }
            if (xCount == yCount) {
                count++;
                StringBuilder targetStr = new StringBuilder();
                for (int j = index; j <= i; j++) {
                    targetStr.append(chars[j]);
                    index = j+1;
                }
                System.out.println(targetStr);
                xCount = 0;
                yCount = 0;
            }
        }
        System.out.println(count);
    }
}

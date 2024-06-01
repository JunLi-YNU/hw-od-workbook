package difficult;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月11日 18:18:19
 * @version: 1.0
 * @Description: 题目描述：
 * 构成指定长度字符串的个数 (本题分值100) 输入一个字符串 和 一个数字。
 * 求输出用字符串里字符构成指定长度字符串的个数，构成的字符串不同，且每个字符串相邻字符串不能相同
 * 输入描述
 * 输入一行，字符串 长度  输出描述 指定长度字符串的个数
 * 用例1
 * 输入  aab 2
 * 输出  2 说明  只能构成ab,ba。
 * 用例2
 * 输入  abc 2
 * 输出  6 说明
 * 可以构成：ab ac ba bc ca cb 。
 */
public class StringNumGeneration {
    public static void main(String[] args) {
        getGeneration();
    }

    private static void getGeneration() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int targetStrLength = scanner.nextInt();
        System.out.println("targetStrLength:" + targetStrLength);
        char[] chars = str.toCharArray();
        HashSet<String> targetStr = new HashSet<>();

        boolean[] usedStrChar = new boolean[str.length()];
        dsfGeneration(chars, targetStrLength, "", targetStr, usedStrChar);
        for (String string : targetStr
        ) {
            System.out.println(string);
        }
        System.out.println(targetStr.size());
        scanner.close();
    }

    private static void dsfGeneration(char[] chars, int targetStrLength, String currentStr, HashSet<String> targetStr,
                                      boolean[] usedStrChar) {
        if (currentStr.length() == targetStrLength) {
            System.out.println(currentStr);
            targetStr.add(currentStr);
            return;
        }
        for (int i = 0; i < chars.length; i++) {

            //判断当前字符是否被使用，当前字符是否和目标字符串的最后一位相同
            if (usedStrChar[i] || (!currentStr.isEmpty()
                    && currentStr.charAt(currentStr.length() - 1) == chars[i])) {
                continue;
            }
            usedStrChar[i] = true;
            dsfGeneration(chars, targetStrLength, currentStr + String.valueOf(chars[i]), targetStr, usedStrChar);
            usedStrChar[i] = false;
        }
    }
}

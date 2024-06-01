package difficult;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月13日 17:49:48
 * @version: 1.0
 * @Description: 题目描述
 * 给定一段英文文章片段，由若干单词组成，单词间以空格间隔，单词下标从0开始。
 * 请翻转片段中指定区间的单词顺序并返回翻转后的内容。
 * <p>
 * 例如给定的英文文章片段为"I am a developer"，翻转区间为[0,3]，则输出“developer a am I”。
 * <p>
 * String reverseWords(String s, int start, int end)
 * <p>
 * 输入描述
 * 使用换行隔开三个参数
 * <p>
 * 第一个参数为英文文章内容即英文字符串
 * 第二个参数为待翻转内容起始单词下标
 * 第三个参数为待翻转内容最后一个单词下标
 * 输出描述
 * 翻转后的英文文章片段所有单词之间以一个半角空格分隔进行输出。
 * <p>
 * 备注
 * 英文文章内容首尾无空格
 * <p>
 * 用例1
 * 输入
 * <p>
 * I am a developer.
 * 1
 * 2
 * 输出
 * <p>
 * I a am developer.
 */
public class ReverseWords {
    public static void main(String[] args) {
        printReverseWords();
    }

    private static void printReverseWords() {
        Scanner scanner = new Scanner(System.in);
        String[] printScanner = scanner.nextLine().split(" ");
        int startIndex = scanner.nextInt();
        int endIndex = scanner.nextInt();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(printScanner));
        if (startIndex < 0) {
            startIndex = arrayList.size() - 1 + startIndex;
        }
        if (endIndex < 0) {
            endIndex = arrayList.size() - 1 + endIndex;
        }
        if (endIndex > arrayList.size() - 1) endIndex = arrayList.size() - 1;
        while (startIndex < endIndex) {
//            System.out.println("startIndex:" + startIndex + " endIndex:" + endIndex);
            String startStr = arrayList.get(startIndex);
            String endStr = arrayList.get(endIndex);
            arrayList.remove(startIndex);
            arrayList.remove(endIndex - 1);
            arrayList.add(startIndex, endStr);
            arrayList.add(endIndex, startStr);

            startIndex++;
            endIndex--;
        }
//        System.out.println();
        for (String s : arrayList
        ) {
            System.out.print(s + " ");
        }
    }
}

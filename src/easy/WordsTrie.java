package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月10日 17:42:26
 * @version: 1.0
 * @Description: 题目描述 主管期望你来实现英文输入法单词联想功能。
 * 需求如下：  依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，
 * 按字典序输出联想到的单词序列， 如果联想不到，请输出用户输入的单词前缀。
 * 注意：  英文单词联想时，区分大小写 缩略形式如”don’t”，判定为两个单词，
 * ”don”和”t” 输出的单词序列，不能有重复单词，且只能是英文单词，不能有标点符号
 * 输入描述
 * 输入为两行。
 * 首行输入一段由英文单词word和标点符号组成的语句str；
 * 接下来一行为一个英文单词前缀pre。
 * 0 < word.length() <= 20 0 < str.length <= 10000 0 < pre <= 20
 * 输出描述
 * 输出符合要求的单词序列或单词前缀，存在多个时，单词之间以单个空格分割
 */
public class WordsTrie {
    public static void main(String[] args) throws IOException {
        getWords();
    }

    private static void getWords() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String content = bufferedReader.readLine();
        String targetWord = bufferedReader.readLine();
        // 将标点符号替换为空格
        content = content.replaceAll("[^a-zA-Z]}", " ");
        String[] splitToWord = content.split("\\s+");
        TreeSet<String> treeSet = new TreeSet<>(Arrays.asList(splitToWord));

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : treeSet
        ) {
            if (word.startsWith(targetWord)) {
                stringBuilder.append(word).append(" ");
            }
        }
        if (!stringBuilder.isEmpty()) {
            System.out.println(stringBuilder.toString());
        } else {
            System.out.println(targetWord);
        }
    }
}

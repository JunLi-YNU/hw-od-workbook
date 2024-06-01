import java.lang.invoke.VarHandle;
import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月13日 11:36:21
 * @version: 1.0
 * @Description: 题目描述： 全量和已占用字符集 、字符串统计（分值100）
 * 给定两个字符集合，一个是全量字符集，一个是已占用字符集，已占用字符集中的字符不能再使用。
 * <p>
 * 要求输出剩余可用字符集。
 * <p>
 * 输入描述
 * 输入一个字符串 一定包含@，@前为全量字符集 @后的为已占用字符集
 * 已占用字符集中的字符一定是全量字符集中的字符
 * 字符集中的字符跟字符之间使用英文逗号隔开
 * 每个字符都表示为字符+数字的形式用英文冒号分隔，比如a:1标识一个a字符
 * 字符只考虑英文字母，区分大小写
 * 数字只考虑正整型 不超过100
 * 如果一个字符都没被占用 @标识仍存在，例如 a:3,b:5,c:2@
 * 输出描述
 * 输出可用字符集
 * 不同的输出字符集之间用回车换行
 * 注意 输出的字符顺序要跟输入的一致，如下面用例不能输出b:3,a:2,c:2
 * 如果某个字符已全部占用 则不需要再输出
 * ACM输入输出模式
 * 如果你经常使用Leetcode,会知道letcode是不需要编写输入输出函数的。但是华为OD机考使用的是 ACM 模式，需要手动编写输入和输出。
 * <p>
 * 所以最好在牛-客上提前熟悉这种模式。例如C++使用cin/cout,python使用input()/print()。JavaScript使用node的readline()和console.log()。Java 使用sacnner/system.out.print()
 * <p>
 * 用例
 * 输入
 * <p>
 * a:3,b:5,c:2@a:1,b:2
 * 输出
 * <p>
 * a:2,b:3,c:2
 * 说明
 * <p>
 * 全量字符集为三个a，5个b，2个c
 * 已占用字符集为1个a，2个b
 * 由于已占用字符不能再使用
 * 因此剩余可用字符为2个a，3个b，2个c
 * 因此输出a:2,b:3,c:2
 */
public class CharacterCount {
    public static void main(String[] args) {
        printlnCharacterCount();
    }

    private static void printlnCharacterCount() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] strings = str.split("@");
        List<String> preStrings = Arrays.stream(strings[0].split(",")).toList();
        List<String> afterStrings = Arrays.stream(strings[1].split(",")).toList();
        HashMap<String, Integer> preStrMap = new HashMap<>();
        HashMap<String, Integer> afterStrMap = new HashMap<>();
        for (String s : preStrings
        ) {
            String[] splitStr = s.split(":");
            String key = splitStr[0];
            int value = Integer.parseInt(splitStr[1]);
            preStrMap.put(key, value);
        }
        for (String s : afterStrings
        ) {
            String[] splitStr = s.split(":");
            String key = splitStr[0];
            int value = Integer.parseInt(splitStr[1]);
            afterStrMap.put(key, value);
        }
        for (Map.Entry<String, Integer> entry : afterStrMap.entrySet()
        ) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (preStrMap.containsKey(key)) {
                preStrMap.put(key, preStrMap.get(key) - value);
            }
        }
        for (Map.Entry<String, Integer> entry : preStrMap.entrySet()
        ) {
            if (entry.getValue() != 0) {
                System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
            }
        }
    }
}

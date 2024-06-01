import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月12日 20:55:03
 * @version: 1.0
 * @Description: 题目描述：
 * 出租车计费 、靠谱的车 程序员小明打了一辆出租车去上班。
 * 出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。
 * 出租车司机解释说他不喜欢数字4，所以改装了计费表，任何数字位置遇到数字4就直接跳过，
 * 其余功能都正常。
 * 比如：  23再多一块钱就变为25； 39再多一块钱变为50； 399再多一块钱变为500；
 * 小明识破了司机的伎俩，准备利用自己的学识打败司机的阴谋。
 * 给出计费表的表面读数，返回实际产生的费用。
 * 输入描述
 * 只有一行，数字N，表示里程表的读数。  (1<=N<=888888888)。
 * 输出描述
 * 一个数字，表示实际产生的费用。以回车结束。
 * 用例
 * 输入	5
 * 输出	4
 * 说明	5表示计费表的表面读数。4表示实际产生的费用其实只有4块钱。
 * 输入	17
 * 输出	15
 * 说明	17表示计费表的表面读数。15表示实际产生的费用其实只有15块钱。
 */
public class RealValue {
    public static void main(String[] args) {
        getRealValue();
    }

    private static void getRealValue() {
        Scanner scanner = new Scanner(System.in);
        String valueStr = scanner.nextLine();
        int current = 0;
        for (char c : valueStr.toCharArray()
        ) {

            int digit = c - '0';
            if (digit > 4) {
                digit--;
            }
            System.out.println(digit + ":" + current);
            current = current * 9 + digit;
        }
        System.out.println(current);
    }
}

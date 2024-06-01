package OD_2024_2_28;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月28日 10:41:43
 * @version: 1.0
 * @Description:
 * 题目描述
 * 输入字符串s，输出s中包含所有整数的最小和。
 *
 * 说明：
 *
 * 字符串s，只包含 a-z A-Z ±
 *
 * 合法的整数包括
 *
 * 1）正整数：一个或者多个0-9组成，如 0 2 3 002 102
 *
 * 2）负整数：负号 – 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 *
 * 输入描述
 * 包含数字的字符串
 *
 * 输出描述
 * 所有整数的最小和
 *
 * 用例1
 * 输入
 * bb1234aa
 * 输出
 * 10
 * 用例2
 * 输入
 * bb12-34aa
 * 输出
 * -31
 * 说明
 * 1+2+（-34） = -31
 */
public class OD149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();
        int inputStrLength = inputStr.length();
        int sumOfStrNum = 0;
        List<Integer> getNumStr = new ArrayList<>();
        List<Integer> negativeNum = new ArrayList<>();
        boolean isNegative = false;
        StringBuilder currentNegativeStr = new StringBuilder();
        for (int i = 0; i < inputStrLength; i++) {
            char currentChar = inputStr.charAt(i);
            if (isNum(currentChar)) {
                if(isNegative){
                    currentNegativeStr.append(currentChar);
                }else {
                    getNumStr.add(Integer.parseInt(String.valueOf(currentChar)));
                }
            } else if (currentChar == '-') {
                isNegative = true;
            }else {
                if(isNegative && !isNum(currentChar)) {
                    negativeNum.add(Integer.parseInt(currentNegativeStr.toString()));
                    currentNegativeStr = new StringBuilder();
                    isNegative = false;
                }
            }
        }
        for (int num:getNumStr
             ) {
            System.out.println("first:"+num);
            sumOfStrNum = sumOfStrNum +  num;
        }
        for (int num:negativeNum
             ) {
            System.out.println("second:"+num);
            sumOfStrNum = sumOfStrNum - num;
        }
        System.out.println(sumOfStrNum);
    }

    private static boolean isNum(char currentChar) {
        return '0' <= currentChar && currentChar <= '9';
    }
}

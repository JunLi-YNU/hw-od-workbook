package OD_2024_2_29;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月29日 14:17:58
 * @version: 1.0
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println((int) 'A' - (int) 'a');
//        System.out.println(Integer.valueOf('a'));
        Scanner scannerIn = new Scanner(System.in);
        String inputString = scannerIn.nextLine();
        String targetStr = scannerIn.next();
        HashMap<Character, Integer> charStrHashMap = getCharacterIntegerHashMap(inputString);
        if (targetStr.charAt(0) >= 'A' && targetStr.charAt(0) <= 'Z') {
            System.out.println(charStrHashMap.get((char) (targetStr.charAt(0) + 32)));
        } else {
            System.out.println(charStrHashMap.get(targetStr.charAt(0)) + ":" + targetStr.charAt(0));
        }
    }

    private static HashMap<Character, Integer> getCharacterIntegerHashMap(String inputString) {
        HashMap<Character, Integer> charStrHashMap = new HashMap<>();
        int stringLength = inputString.length();
        for (int i = 0; i < stringLength; i++) {
            char currentChar = inputString.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'z') {
                charStrHashMap.put(currentChar, charStrHashMap.getOrDefault(currentChar, 0) + 1);
            } else if (currentChar >= 'A' && currentChar <= 'Z') {
                charStrHashMap.put((char) (currentChar + 32), charStrHashMap.getOrDefault((char) (currentChar + 32), 0) + 1);
            } else if (currentChar >= '0' && currentChar <= '9') {
                charStrHashMap.put(currentChar, charStrHashMap.getOrDefault(currentChar, 0) + 1);
            }
        }
        return charStrHashMap;
    }
}

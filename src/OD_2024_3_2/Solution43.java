package OD_2024_3_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
 * @Author: LiJun-YNU
 * @createTime: 2024年03月02日 23:14:17
 * @version: 1.0
 * @Description:
 */
public class Solution43 {
    public static void main(String[] args) {
        Scanner mInputScanner = new Scanner(System.in);
        String inputString = mInputScanner.nextLine();
        System.out.println(inputString);
        int stringLength = inputString.length();
        int charICount = 0;
        int charOCount = 0;
        int charXCount = 0;
        for (int i = 0; i < stringLength; i++) {
            switch (inputString.charAt(i)) {
                case 'i' -> charICount++;
                case 'o' -> charOCount++;
                case 'x' -> charXCount++;
                default -> {
                }
            }
        }
        int maxICountIsCan = 0;
        if (charICount == 0) {
            maxICountIsCan = Integer.MAX_VALUE;
        } else {
            for (int i = charICount; i >= 0; i--) {
                if ((i % 2) == 0) {
                    maxICountIsCan = i;
                    break;
                }
            }
        }
        int maxOCountIsCan = 0;
        if (charOCount == 0) {
            maxOCountIsCan = Integer.MAX_VALUE;
        } else {
            for (int i = charOCount; i >= 0; i--) {
                if ((i % 2) == 0) {
                    maxOCountIsCan = i;
                    break;
                }
            }
        }
        System.out.println(charOCount + ":" + maxOCountIsCan);

        int maxXCountIsCan = 0;
        if (charXCount == 0) {
            maxXCountIsCan = Integer.MAX_VALUE;
        } else {
            for (int i = charXCount; i >= 0; i--) {
                if (i % 2 == 0) {
                    maxXCountIsCan = i;
                    break;
                }
            }
        }


        int currentICount = 0;
        int currentOCount = 0;
        int currentXCount = 0;
        ArrayList<Integer> targetStrList = new ArrayList<>();

        for (int i = 0; i < stringLength; i++) {
            StringBuilder targetStr = new StringBuilder();
            for (int j = i; j < stringLength; j++) {
                if (inputString.charAt(j) != 'o' && inputString.charAt(j) != 'x' && inputString.charAt(j) != 'i') {
                    targetStr.append(inputString.charAt(j));
                } else if (currentICount < maxICountIsCan && currentOCount < maxOCountIsCan && currentXCount < maxXCountIsCan) {
                    targetStr.append(inputString.charAt(i));
                    switch (inputString.charAt(j)) {
                        case 'i' -> ++currentICount;
                        case 'o' -> ++currentOCount;
                        case 'x' -> ++currentXCount;
                        default -> {
                        }
                    }
                }
            }
            System.out.println(targetStr.length());
            targetStrList.add(targetStr.length());
        }
        Collections.sort(targetStrList);
        System.out.println(targetStrList.get(0));
    }
}

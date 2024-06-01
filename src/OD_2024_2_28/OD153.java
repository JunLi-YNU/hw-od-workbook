package OD_2024_2_28;

import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月28日 11:33:58
 * @version: 1.0
 * @Description:
 */
public class OD153 {
    public static void main(String[] args) {
        Scanner mScanner = new Scanner(System.in);
        String inputStr = mScanner.next();
        int inputStrLength = inputStr.length();
        int currentIndex = 0;

        List<Integer> targetStrArr = new ArrayList<>();
        while (currentIndex < inputStrLength) {
            StringBuilder targetStr = new StringBuilder();
            boolean isContainsChar = false;
            char currentChar = inputStr.charAt(currentIndex);
            if (!mIsNum(currentChar)) {
                targetStr.append(currentChar);
                int afterIndex = currentIndex + 1;
                while (afterIndex < inputStrLength) {
                    char afterChar = inputStr.charAt(afterIndex);
                    if (mIsNum(afterChar)) {
                        targetStr.append(afterChar);
                    } else {
                        break;
                    }
                    afterIndex++;
                }
                if (targetStr.length() > 1) {
                    targetStrArr.add(targetStr.length());
                }

            } else {
                targetStr.append(currentChar);
                int afterIndex = currentIndex + 1;
                while (afterIndex < inputStrLength) {
                    char afterChar = inputStr.charAt(afterIndex);
                    if (mIsNum(afterChar)) {
                        targetStr.append(afterChar);
                    } else {
                        if (!isContainsChar) {
                            targetStr.append(afterChar);
                            isContainsChar = true;
                        } else {
                            break;
                        }
                    }
                    afterIndex++;
                }
                if (isContainsChar) {
                    targetStrArr.add(targetStr.length());
                }
            }
            currentIndex++;
        }
        Collections.sort(targetStrArr);
        if (targetStrArr.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(targetStrArr.get(targetStrArr.size() - 1));
        }
    }

    private static boolean mIsNum(char r) {
        return (r >= '0' && r <= '9');
    }
}

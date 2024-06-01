package OD_2024_2_29;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月29日 15:07:28
 * @version: 1.0
 * @Description:
 */
public class SolutionBackStringNum {
    public static void main(String[] args) {
        Scanner mScannerInput = new Scanner(System.in);
        String[] mInputString = mScannerInput.nextLine().split(" ");
        int mInputStringLength = mInputString.length;
        if (mInputStringLength == 0) {
            System.out.println(" ");
        }
        StringBuilder mTargetString = new StringBuilder();
        for (String s : mInputString) {
            mTargetString.insert(0, s);
        }
        System.out.println(mTargetString);
    }
}

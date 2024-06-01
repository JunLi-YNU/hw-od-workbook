package OD_2024_2_29;

import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月29日 15:30:34
 * @version:
 * @Description:
 */
public class SolutionSortStrings {
    public static void main(String[] args) {
        //贪心
        Scanner mInputScanner = new Scanner(System.in);
        int inputStringsCount = mInputScanner.nextInt();
        List<String> mInputStrings = new ArrayList<>();
        for (int i = 0; i < inputStringsCount; i++) {
            mInputStrings.add(mInputScanner.nextLine());
        }
        Collections.sort(mInputStrings);
        for (int i = 0; i < mInputStrings.size(); i++) {
            if(i == 0){
                System.out.print(mInputStrings.get(i));
            }else {
                System.out.println(mInputStrings.get(i));
            }
        }
    }
}

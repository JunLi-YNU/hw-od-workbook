package OD_2024_2_29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月29日 15:56:46
 * @version: 1.0
 * @Description:
 */


public class Solution01 {
    public static void main(String[] args) {
        Scanner mInputScanner = new Scanner(System.in);
        int allTimesOfDay = mInputScanner.nextInt();
        int crossCityCounts = mInputScanner.nextInt();
        int[] crossCityNeedTime = new int[crossCityCounts+1];
        for (int i = 0; i <= crossCityCounts; i++) {
            crossCityNeedTime[i] = mInputScanner.nextInt();
        }
        List<int[]> cityGetAndSub = new ArrayList<>();
        for (int i = 0; i < crossCityCounts; i++) {
            cityGetAndSub.add(new int[]{mInputScanner.nextInt(), mInputScanner.nextInt()});
        }
        int sumOfCrossCityNeedTime = 0;
        for (int j : crossCityNeedTime) {
            sumOfCrossCityNeedTime += j;
        }
        int haveMakeMoneyTimes = allTimesOfDay - sumOfCrossCityNeedTime;
        int sumMakeMoney = 0;
        int currentCity = 0;
        while (haveMakeMoneyTimes > 0 && currentCity < crossCityCounts) {
            haveMakeMoneyTimes--;

            while (cityGetAndSub.get(currentCity)[0] > 0 && haveMakeMoneyTimes > 0 ) {
                sumMakeMoney += cityGetAndSub.get(currentCity)[0];

                cityGetAndSub.get(currentCity)[0] -= cityGetAndSub.get(currentCity)[1];

                if(currentCity < crossCityCounts - 1){
                    if(cityGetAndSub.get(currentCity)[0]<cityGetAndSub.get(currentCity+1)[0]){
                        sumMakeMoney += cityGetAndSub.get(currentCity)[0];
                        break;
                    }
                }
                haveMakeMoneyTimes--;
            }
            currentCity++;
        }
        System.out.println(sumMakeMoney);
    }
}

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月16日 15:17:10
 * @version:
 * @Description:
 */
//public class StringHandler {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String[] strings = scanner.nextLine().split(" ");
//        handleString(strings);
//    }
//
//    private static void handleString(String[] strings) {
//        ArrayList<String> filterString = new ArrayList<>();
//        for (String str : strings
//        ) {
//            if (str.length() <= 9 && str.startsWith("a")) {
//                System.out.println(str);
//
//                char[] stringChar = str.toCharArray();
//                boolean illegal = false;
//                for (char c:stringChar
//                     ) {
//                    System.out.println(c);
//                }
//
//                for (int i = 1; i < str.length(); i++) {
//                    if (!(stringChar[i] <= '9' && stringChar[i] >= '0')) {
//                        illegal = true;
//                        break;
//                    }
//                }
//                if (illegal) {
//                    char[] chars = new char[]{stringChar[0], 0, 0, 0, 0, 0, 0, 0, 0};
//                    ArrayList<String> arrayList = new ArrayList<>();
//
//                    arrayList.add(1,String.valueOf(stringChar[0]));
//                    for (int i = stringChar.length - 1; i > 1; i--) {
//                        for (int j = chars.length - 1; j > 0; j--) {
//                           arrayList.add(j,String.valueOf(stringChar[i]));
//                        }
//                    }
//                    filterString.add();
//                }
//            }
//        }
//        Collections.sort(filterString);
//        for (String str:filterString
//             ) {
//            System.out.println(str);
//        }
//    }
//}

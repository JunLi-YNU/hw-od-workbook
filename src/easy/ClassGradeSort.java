package easy;

import java.util.*;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年02月10日 22:05:04
 * @version: 1.0
 * @Description: 题目描述 小明来到学校当老师，需要将学生按考试总分或单科分数进行排名，你能帮帮他吗？
 * 输入描述
 * 第 1 行输入两个整数，学生人数 n 和科目数量 m。  0 < n < 100 0 < m < 10
 * 第 2 行输入 m 个科目名称，彼此之间用空格隔开。科目名称只由英文字母构成，单个长度不超过10个字符。
 * 科目的出现顺序和后续输入的学生成绩一一对应。 不会出现重复的科目名称。
 * 第 3 行开始的 n 行，每行包含一个学生的姓名和该生 m 个科目的成绩（空格隔开）
 * 学生不会重名。 学生姓名只由英文字母构成，长度不超过10个字符。
 * 成绩是0~100的整数，依次对应第2行种输入的科目。 第n+2行，输入用作排名的科目名称。
 * 若科目不存在，则按总分进行排序。
 * 输出描述 输出一行，按成绩排序后的学生名字，空格隔开。成绩相同的按照学生姓名字典顺序排序。
 * 样例1
 * 输入
 * 3 2
 * yuwen shuxue
 * fangfang 95 90
 * xiaohua 88 98
 * minmin 100 82
 * shuxue
 * 输出
 * xiaohua fangfang minmin
 * 说明：  按照shuxue成绩排名依次是 xiaohua fangfang minmin
 */
public class ClassGradeSort {
    public static void main(String[] args) {
        getGradesSort();

    }

    private static void getGradesSort() {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = scanner.nextInt();
        int classCount = scanner.nextInt();
        String[] className = new String[classCount];
        for (int i = 0; i < classCount; i++) {
            className[i] = scanner.next();
        }
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (int i = 0; i < studentsCount; i++) {
            Student student = new Student(scanner.next());
            for (int j = 0; j < classCount; j++) {
                student.addGrade(className[j], scanner.nextInt());
            }
            studentArrayList.add(student);
        }
        String targetClassName = scanner.next();

        studentArrayList.sort((o1, o2) -> {
            int score1 = targetClassName.isEmpty() ? o1.total :
                    o1.getClassGrades().getOrDefault(targetClassName, 0);
            int score2 = targetClassName.isEmpty() ? o2.total :
                    o2.getClassGrades().getOrDefault(targetClassName, 0);
            if (score1 != score2) {
                return score2 - score1;
            } else {
                return o1.name.compareTo(o2.name);
            }
        });
        studentArrayList.forEach(student -> System.out.print(student.name + " "));
    }


    static class Student {
        private String name;
        private Map<String, Integer> classGrades;

        private int total;

        public Student(String name) {
            this.name = name;
            this.classGrades = new HashMap<>();
            this.total = 0;
        }

        public Student(String name, Map<String, Integer> classGrades, int total) {
            this.name = name;
            this.classGrades = classGrades;
            this.total = total;
        }

        public void addGrade(String classStr, int grade) {
            classGrades.put(classStr, grade);
            total += grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, Integer> getClassGrades() {
            return classGrades;
        }

        public void setClassGrades(Map<String, Integer> classGrades) {
            this.classGrades = classGrades;
        }

        public int getTotal() {

            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
}

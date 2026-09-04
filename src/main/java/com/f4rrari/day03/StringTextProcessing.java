package com.f4rrari.day03;

import java.util.ArrayList;
import java.util.List;

public class StringTextProcessing {

    public static void main(String[] args) {
        // 1. 演示 == 与 equals 的区别
        demonstrateEqualsVsOperator();

        // 2. 练习常用方法
        demonstrateStringMethods();

        // 3. StringBuilder 性能对比
        demonstrateStringBuilder();

        // 4. 解析学生数据并计算平均分
        parseStudentData();
    }

    // ==================== 1. == 与 equals 的区别 ====================
    private static void demonstrateEqualsVsOperator() {
        System.out.println("=== 1. == 与 equals 的区别 ===\n");

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = new String("Hello");

        // == 比较的是引用地址
        System.out.println("s1 == s2: " + (s1 == s2));           // true (字符串常量池)
        System.out.println("s1 == s3: " + (s1 == s3));           // false (不同对象)
        System.out.println("s3 == s4: " + (s3 == s4));           // false (不同对象)

        // equals 比较的是内容
        System.out.println("s1.equals(s2): " + s1.equals(s2));   // true
        System.out.println("s1.equals(s3): " + s1.equals(s3));   // truer
        System.out.println("s3.equals(s4): " + s3.equals(s4));   // true

        System.out.println("\n总结：== 比较引用地址，equals 比较内容\n");
    }

    // ==================== 2. 常用方法练习 ====================
    private static void demonstrateStringMethods() {
        System.out.println("=== 2. String 常用方法练习 ===\n");

        String text = "Hello,World,Java,Programming";

        // split - 分割
        String[] parts = text.split(",");
        System.out.println("split: " + String.join(" | ", parts));

        // join - 连接
        String joined = String.join("-", "A", "B", "C");
        System.out.println("join: " + joined);

        // substring - 子字符串
        String sub = text.substring(6, 11);
        System.out.println("substring(6,11): " + sub);

        // indexOf - 查找索引
        int index = text.indexOf("World");
        System.out.println("indexOf('World'): " + index);

        // replace - 替换
        String replaced = text.replace(",", " | ");
        System.out.println("replace: " + replaced);

        // format - 格式化
        String formatted = String.format("姓名: %s, 年龄: %d, 成绩: %.2f", "张三", 20, 95.5);
        System.out.println("format: " + formatted);

        System.out.println();
    }

    // ==================== 3. StringBuilder 性能对比 ====================
    private static void demonstrateStringBuilder() {
        System.out.println("=== 3. StringBuilder 性能对比 ===\n");

        final int LOOPS = 100000;

        // 使用 + 拼接
        long start1 = System.currentTimeMillis();
        String result1 = "";
        for (int i = 0; i < LOOPS; i++) {
            result1 += "a";
        }
        long end1 = System.currentTimeMillis();
        System.out.println("使用 + 拼接 " + LOOPS + " 次耗时: " + (end1 - start1) + "ms");

        // 使用 StringBuilder
        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LOOPS; i++) {
            sb.append("a");
        }
        String result2 = sb.toString();
        long end2 = System.currentTimeMillis();
        System.out.println("使用 StringBuilder 拼接 " + LOOPS + " 次耗时: " + (end2 - start2) + "ms");

        System.out.println("\n为什么 StringBuilder 更快？");
        System.out.println("1. String 是不可变的，每次 + 都会创建新的 String 对象");
        System.out.println("2. StringBuilder 是可变的，在原有缓冲区上直接追加");
        System.out.println("3. 大量拼接时，StringBuilder 避免频繁创建对象和垃圾回收\n");
    }

    // ==================== 4. 解析学生数据 ====================
    private static void parseStudentData() {
        System.out.println("=== 4. 解析学生数据并计算平均分 ===\n");

        // 测试数据
        String data = "1,张三,80;2,李四,90";
        String dataWithEmpty = "1,张三,80;2,李四,90;;";  // 包含空字符串和结尾分号
        String dataWithTrailing = "1,张三,80;2,李四,90;";

        System.out.println("测试数据1 (正常): " + data);
        parseAndPrint(data);

        System.out.println("\n测试数据2 (包含空和结尾分号): " + dataWithEmpty);
        parseAndPrint(dataWithEmpty);

        System.out.println("\n测试数据3 (结尾分号): " + dataWithTrailing);
        parseAndPrint(dataWithTrailing);
    }

    private static void parseAndPrint(String input) {
        List<Student> students = parseStudents(input);

        if (students.isEmpty()) {
            System.out.println("没有有效的学生数据");
            return;
        }

        System.out.println("解析结果:");
        for (Student s : students) {
            System.out.println("  " + s);
        }

        double avg = calculateAverage(students);
        System.out.printf("平均分: %.2f\n", avg);
    }

    private static List<Student> parseStudents(String input) {
        List<Student> students = new ArrayList<>();

        // 处理空字符串
        if (input == null || input.trim().isEmpty()) {
            return students;
        }

        // 按分号分割，处理结尾分号的情况
        String[] records = input.split(";");

        for (String record : records) {
            // 跳过空记录（处理连续分号或结尾分号）
            if (record == null || record.trim().isEmpty()) {
                continue;
            }

            String[] fields = record.split(",");

            // 验证字段数量
            if (fields.length != 3) {
                System.out.println("跳过无效记录: " + record);
                continue;
            }

            try {
                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                double score = Double.parseDouble(fields[2].trim());

                students.add(new Student(id, name, score));
            } catch (NumberFormatException e) {
                System.out.println("跳过格式错误记录: " + record);
            }
        }

        return students;
    }

    private static double calculateAverage(List<Student> students) {
        if (students.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Student s : students) {
            sum += s.getScore();
        }
        return sum / students.size();
    }

    // ==================== Student 内部类 ====================
    static class Student {
        private final int id;
        private final String name;
        private final double score;

        public Student(int id, String name, double score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getScore() { return score; }

        @Override
        public String toString() {
            return String.format("Student{id=%d, name='%s', score=%.1f}", id, name, score);
        }
    }
}

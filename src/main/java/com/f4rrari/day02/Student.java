package com.f4rrari.day02;

public class Student extends Person {
    // static字段：统计学生总数
    public static int studentCount = 0;

    private final String studentId;
    private String major;
    private double gpa;

    // 构造方法1：完整参数
    public Student(String name, int age, String gender, String studentId, String major) {
        super(name, age, gender);
        this.studentId = studentId;
        this.major = major;
        this.gpa = 0.0;
        studentCount++;
        System.out.println("🎓 创建Student: " + name + " (学号: " + studentId + ")");
        System.out.println("   当前学生总数: " + studentCount);
    }

    // 构造方法2：简化参数（构造方法链）
    public Student(String name, String studentId, String major) {
        this(name, 18, "未知", studentId, major);
    }

    // 构造方法3：带GPA参数
    public Student(String name, int age, String gender, String studentId, String major, double gpa) {
        this(name, age, gender, studentId, major);
        this.gpa = gpa;
    }

    // 方法重写：覆盖父类的getRole()
    @Override
    public String getRole() {
        return "学生";
    }

    // 方法重写：增加学生特有信息
    @Override
    public void introduce() {
        super.introduce();
        System.out.printf("   📚 学号：%s，专业：%s，GPA：%.2f%n", studentId, major, gpa);
    }

    // 学生特有方法
    public void study() {
        System.out.println("   📖 " + name + " 正在努力学习...");
    }

    public void study(String subject) {
        System.out.println("   📖 " + name + " 正在学习 " + subject + "...");
    }

    // static方法：获取学生总数
    public static int getStudentCount() {
        return studentCount;
    }

    // Getter/Setter
    public String getStudentId() { return studentId; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
}
package com.f4rrari.day02;

public class Teacher extends Person {  // 继承
    private final String employeeId;
    private String department;
    private String title;  // 职称

    public Teacher(String name, int age, String gender, String employeeId, String department, String title) {
        super(name, age, gender);
        this.employeeId = employeeId;
        this.department = department;
        this.title = title;
    }

    // 方法重写
    @Override
    public String getRole() {
        return "教师";
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.printf("工号：%s，部门：%s，职称：%s%n", employeeId, department, title);
    }

    // 教师特有方法
    public void teach() {
        System.out.println(name + " 正在授课...");
    }

    public void teach(String subject) {
        System.out.println("   📝 " + name + " 正在教授 " + subject + "...");
    }

    // getter/setter
    public String getEmployeeId() { return employeeId; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
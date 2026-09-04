package com.f4rrari.day02;

public class StudentTeacherTest {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     🎯 Student & Teacher 完整功能测试");
        System.out.println("═══════════════════════════════════════════════════\n");

        // ========== 1. 测试继承和构造方法链 ==========
        System.out.println("【1. 继承和构造方法链测试】");
        System.out.println("─────────────────────────────────────────────────");

        System.out.println("① 创建Student对象（完整参数）：");
        Student s1 = new Student("张三", 20, "男", "S001", "计算机科学", 3.8);

        System.out.println("\n② 创建Student对象（简化参数 - 构造方法链）：");
        Student s2 = new Student("李四", "S002", "数学");

        System.out.println("\n③ 创建Student对象（带GPA）：");
        Student s3 = new Student("王五", 19, "女", "S003", "物理", 3.5);

        System.out.println("\n④ 创建Teacher对象：");
        Teacher t1 = new Teacher("赵六", 35, "女", "T001", "计算机学院", "副教授");

        System.out.println("\n" + "═".repeat(55) + "\n");

        // ========== 2. 测试方法重写和多态 ==========
        System.out.println("【2. 方法重写和多态测试】");
        System.out.println("─────────────────────────────────────────────────");

        System.out.println("① Person引用指向Student对象（向上转型）：");
        Person p1 = new Student("孙七", 21, "男", "S004", "化学", 3.2);
        p1.introduce();  // 实际调用Student的introduce

        System.out.println("\n② Person引用指向Teacher对象（向上转型）：");
        Person p2 = new Teacher("周八", 42, "男", "T002", "数学学院", "教授");
        p2.introduce();  // 实际调用Teacher的introduce

        System.out.println("\n③ 多态数组：");
        Person[] people = {
                new Student("吴九", 20, "女", "S005", "英语", 3.7),
                new Teacher("郑十", 38, "男", "T003", "外国语学院", "讲师"),
                new Student("冯十一", 22, "男", "S006", "经济学", 3.9),
                new Teacher("陈十二", 45, "女", "T004", "经济学院", "教授")
        };

        for (int i = 0; i < people.length; i++) {
            System.out.println("\n  " + (i+1) + ". " + people[i].getClass().getSimpleName() + ":");
            people[i].introduce();
        }

        System.out.println("\n" + "═".repeat(55) + "\n");

        // ========== 3. 测试static字段 ==========
        System.out.println("【3. static字段统计测试】");
        System.out.println("─────────────────────────────────────────────────");

        System.out.println("📊 当前学生总数: " + Student.getStudentCount());

        System.out.println("\n创建更多学生...");
        Student s4 = new Student("钱十三", "S007", "哲学");
        Student s5 = new Student("孙十四", 22, "女", "S008", "社会学", 3.1);

        System.out.println("\n📊 最终学生总数: " + Student.getStudentCount());
        System.out.println("📊 直接访问static字段: " + Student.studentCount);  // 注意：需要将studentCount改为public才能访问

        System.out.println("\n" + "═".repeat(55) + "\n");

        // ========== 4. 测试子类特有方法 ==========
        System.out.println("【4. 子类特有方法测试】");
        System.out.println("─────────────────────────────────────────────────");

        System.out.println("① Student特有方法 - study():");
        s1.study();
        s1.study("Java编程");  // 方法重载

        System.out.println("\n② Teacher特有方法 - teach():");
        t1.teach();
        t1.teach("数据结构");  // 方法重载

        System.out.println("\n" + "═".repeat(55) + "\n");

        // ========== 5. 测试向下转型 ==========
        System.out.println("【5. 向下转型测试】");
        System.out.println("─────────────────────────────────────────────────");

        Person p3 = new Student("刘十五", 20, "男", "S009", "软件工程", 3.6);
        System.out.println("① 父类引用: " + p3.getClass().getSimpleName());
        p3.introduce();

        System.out.println("\n② 向下转型为Student:");
        if (p3 instanceof Student) {
            Student student = (Student) p3;
            System.out.println("   ✅ 转型成功！");
            student.study();
            System.out.println("   GPA: " + student.getGpa());
            System.out.println("   专业: " + student.getMajor());
        }

        Person p4 = new Teacher("杨十六", 40, "女", "T005", "艺术学院", "副教授");
        System.out.println("\n③ 向下转型为Teacher:");
        if (p4 instanceof Teacher) {
            Teacher teacher = (Teacher) p4;
            System.out.println("   ✅ 转型成功！");
            teacher.teach();
            System.out.println("   职称: " + teacher.getTitle());
            System.out.println("   部门: " + teacher.getDepartment());
        }

        System.out.println("\n" + "═".repeat(55) + "\n");

        // ========== 6. 综合业务场景 ==========
        System.out.println("【6. 综合业务场景 - 学校管理系统】");
        System.out.println("─────────────────────────────────────────────────");

        System.out.println("🏫 学校人员列表：");
        Person[] schoolPeople = {
                new Student("张三", 20, "男", "S001", "计算机科学", 3.8),
                new Student("李四", 19, "女", "S002", "数学", 3.5),
                new Teacher("赵六", 35, "女", "T001", "计算机学院", "副教授"),
                new Student("王五", 21, "男", "S003", "物理", 3.2),
                new Teacher("周八", 42, "男", "T002", "数学学院", "教授")
        };

        System.out.println("\n📋 所有人员介绍：");
        for (Person p : schoolPeople) {
            System.out.println("   " + p.getClass().getSimpleName() + ": " + p.getName() +
                    " (" + p.getRole() + ")");
        }

        // 统计
        int studentCount = 0;
        int teacherCount = 0;
        for (Person p : schoolPeople) {
            if (p instanceof Student) studentCount++;
            else if (p instanceof Teacher) teacherCount++;
        }
        System.out.println("\n📊 统计结果：");
        System.out.println("   👨‍🎓 学生: " + studentCount + " 人");
        System.out.println("   👨‍🏫 教师: " + teacherCount + " 人");
        System.out.println("   📚 学生总数(static): " + Student.getStudentCount() + " 人");

        System.out.println("\n" + "═".repeat(55) + "\n");

        // ========== 7. 封装性验证 ==========
        System.out.println("【7. 封装性验证】");
        System.out.println("─────────────────────────────────────────────────");
        System.out.println("✅ 私有属性无法直接访问:");
        System.out.println("   // s1.studentId = 'xxx';  ← 编译错误！");
        System.out.println("   // t1.department = 'xxx'; ← 编译错误！");
        System.out.println("   // Student.studentCount = 10; ← 编译错误！(如果private)");

        System.out.println("\n✅ 必须通过公共方法访问:");
        System.out.println("   s1.setGpa(3.9);          ← 正确！");
        System.out.println("   t1.setDepartment('新部门'); ← 正确！");
        System.out.println("   Student.getStudentCount(); ← 正确！");

        // 演示Setter
        System.out.println("\n📝 演示修改GPA:");
        System.out.println("   修改前: " + s1.getName() + " 的GPA = " + s1.getGpa());
        s1.setGpa(3.9);
        System.out.println("   修改后: " + s1.getName() + " 的GPA = " + s1.getGpa());

        System.out.println("\n" + "═".repeat(55) + "\n");

        System.out.println("🎉 Student & Teacher 所有功能测试完成！");
        System.out.println("\n📌 核心概念总结:");
        System.out.println("   ✅ 继承: Student extends Person, Teacher extends Person");
        System.out.println("   ✅ 多态: Person引用调用子类重写的方法");
        System.out.println("   ✅ 封装: private属性 + public getter/setter");
        System.out.println("   ✅ static: 统计学生总数");
        System.out.println("   ✅ 方法重写: getRole(), introduce()");
        System.out.println("   ✅ 方法重载: study(), teach()");
        System.out.println("   ✅ 向上转型: Person p = new Student()");
        System.out.println("   ✅ 向下转型: (Student) p");
    }
}
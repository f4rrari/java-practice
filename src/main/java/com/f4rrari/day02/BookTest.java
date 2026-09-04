package com.f4rrari.day02;

// ============ BookTest.java - 完整测试类 ============
public class BookTest {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("     📚 Book类完整功能测试");
        System.out.println("═══════════════════════════════════════\n");

        // ========== 1. 测试构造方法链 ==========
        System.out.println("【1. 构造方法测试】");
        System.out.println("────────────────────────────────────");

        // 无参构造
        System.out.println("① 使用无参构造：");
        Book book1 = new Book();
        System.out.println("   " + book1);

        // 两参构造
        System.out.println("\n② 使用两参构造：");
        Book book2 = new Book("Java编程思想", "Bruce Eckel");
        System.out.println("   " + book2);

        // 三参构造
        System.out.println("\n③ 使用三参构造：");
        Book book3 = new Book("深入理解Java虚拟机", "周志明", 89.0);
        System.out.println("   " + book3);

        System.out.println("\n" + "═".repeat(40) + "\n");

        // ========== 2. 测试Getter方法 ==========
        System.out.println("【2. Getter方法测试】");
        System.out.println("────────────────────────────────────");
        System.out.println("📖 书名：  " + book3.getTitle());
        System.out.println("✍️  作者：  " + book3.getAuthor());
        System.out.println("💰 价格：  ¥" + book3.getPrice());
        System.out.println("🔢 ISBN：  " + book3.getIsbn());

        System.out.println("\n" + "═".repeat(40) + "\n");

        // ========== 3. 测试Setter方法（带验证） ==========
        System.out.println("【3. Setter方法测试（带验证）】");
        System.out.println("────────────────────────────────────");

        System.out.println("① 测试正常更新：");
        book3.setTitle("深入理解Java虚拟机（第3版）");
        book3.setAuthor("周志明（更新）");
        book3.setPrice(99.0);

        System.out.println("\n② 测试异常值验证：");
        book3.setPrice(-50.0);  // 负数验证
        book3.setTitle("");     // 空字符串验证
        book3.setAuthor(null);  // null验证

        System.out.println("\n📌 最终状态：");
        System.out.println("   " + book3);

        System.out.println("\n" + "═".repeat(40) + "\n");

        // ========== 4. 测试方法重载 ==========
        System.out.println("【4. 方法重载测试】");
        System.out.println("────────────────────────────────────");

        Book book4 = new Book("Effective Java", "Joshua Bloch", 79.0);
        System.out.println("书籍信息：" + book4);

        System.out.println("\n① 调用无参版本 getDiscountPrice()：");
        double discount1 = book4.getDiscountPrice();
        System.out.println("   原价 ¥" + book4.getPrice() + " → 8折价 ¥" + discount1);

        System.out.println("\n② 调用有参版本 getDiscountPrice(0.7)：");
        double discount2 = book4.getDiscountPrice(0.7);
        System.out.println("   原价 ¥" + book4.getPrice() + " → 7折价 ¥" + discount2);

        System.out.println("\n③ 调用有参版本 getDiscountPrice(0.85)：");
        double discount3 = book4.getDiscountPrice(0.85);
        System.out.println("   原价 ¥" + book4.getPrice() + " → 85折价 ¥" + discount3);

        System.out.println("\n④ 测试参数验证 getDiscountPrice(1.5)：");
        double discount4 = book4.getDiscountPrice(1.5);  // 无效折扣率
        System.out.println("   返回结果：" + discount4);

        System.out.println("\n" + "═".repeat(40) + "\n");

        // ========== 5. 综合业务场景测试 ==========
        System.out.println("【5. 综合业务场景测试】");
        System.out.println("────────────────────────────────────");

        // 创建购物车中的书籍
        System.out.println("🛒 购物车中的书籍：");
        Book[] cart = {
                new Book("Spring实战", "Craig Walls", 89.0),
                new Book("MySQL必知必会", "Ben Forta", 49.0),
                new Book("算法导论", "Thomas H. Cormen", 128.0)
        };

        System.out.println("\n📊 购物车结算（不同折扣）：");
        double total = 0;
        for (int i = 0; i < cart.length; i++) {
            Book book = cart[i];
            double discount = 0;

            // 不同书籍不同折扣
            if (i == 0) {
                discount = book.getDiscountPrice(0.75);  // 75折
                System.out.printf("  %d. %s → 75折：¥%.2f%n",
                        i + 1, book.getTitle(), discount);
            } else if (i == 1) {
                discount = book.getDiscountPrice();      // 默认8折
                System.out.printf("  %d. %s → 8折：¥%.2f%n",
                        i + 1, book.getTitle(), discount);
            } else {
                discount = book.getDiscountPrice(0.65);  // 65折
                System.out.printf("  %d. %s → 65折：¥%.2f%n",
                        i + 1, book.getTitle(), discount);
            }
            total += discount;
        }
        System.out.printf("\n💰 总计：¥%.2f%n", total);

        System.out.println("\n" + "═".repeat(40) + "\n");

        // ========== 6. toString方法测试 ==========
        System.out.println("【6. toString方法测试】");
        System.out.println("────────────────────────────────────");

        Book book5 = new Book("Head First设计模式", "Eric Freeman", 109.0);
        System.out.println("直接打印对象自动调用toString()：");
        System.out.println("  " + book5);
        System.out.println("  等同于：" + book5.toString());

        System.out.println("\n" + "═".repeat(40) + "\n");

        // ========== 7. 封装性验证 ==========
        System.out.println("【7. 封装性验证】");
        System.out.println("────────────────────────────────────");
        System.out.println("✅ 私有属性无法直接访问：");
        System.out.println("   // book5.title = '新书名';  ← 编译错误！");
        System.out.println("   // book5.price = 200;      ← 编译错误！");
        System.out.println("\n✅ 必须通过公共方法访问：");
        System.out.println("   book5.setTitle('新书名');  ← 正确！");
        System.out.println("   book5.getTitle();          ← 正确！");

        System.out.println("\n" + "═".repeat(40) + "\n");

        System.out.println("🎉 Book类所有功能测试完成！");
    }
}
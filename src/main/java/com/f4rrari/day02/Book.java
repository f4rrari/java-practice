package com.f4rrari.day02;

// ============ Book.java ============
public class Book {
    private String title;
    private String author;
    private double price;
    private String isbn;

    // 构造方法链
    public Book() {
        this("Unknown", "Unknown", 0.0);
    }

    public Book(String title, String author) {
        this(title, author, 0.0);
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = generateIsbn();
        System.out.println("📚 创建新书：" + this.title);
    }

    // Getter方法
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    // Setter方法（带验证）
    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
            System.out.println("✅ 书名已更新为：" + title);
        } else {
            System.out.println("❌ 书名不能为空！");
        }
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
            System.out.println("✅ 作者已更新为：" + author);
        } else {
            System.out.println("❌ 作者不能为空！");
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
            System.out.println("✅ 价格已更新为：¥" + price);
        } else {
            System.out.println("❌ 价格不能为负数！");
        }
    }

    // 方法重载：计算折扣价格
    public double getDiscountPrice() {
        return price * 0.8; // 默认8折
    }

    public double getDiscountPrice(double discountRate) {
        if (discountRate < 0 || discountRate > 1) {
            System.out.println("⚠️ 折扣率应在0-1之间，使用默认8折");
            return getDiscountPrice();
        }
        return price * discountRate;
    }

    // 私有辅助方法
    private String generateIsbn() {
        return "ISBN-" + System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return String.format("《%s》by %s, ￥%.2f [ISBN: %s]",
                title, author, price, isbn);
    }
}
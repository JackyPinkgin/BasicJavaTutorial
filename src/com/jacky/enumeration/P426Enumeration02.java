package com.jacky.enumeration;

/**
 * @author Jacky
 * @version 1.0
 * @date 2021/10/16
 */
public class P426Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.AUTUMN);
    }
}

//自定义枚举实现
class Season{
    private String name;
    private String desc;

    public final static Season SPRING = new Season("春天","温暖");
    public final static Season WINTER = new Season("冬天","寒冷");
    public final static Season AUTUMN = new Season("秋天","凉爽");
    public final static Season SUMMER = new Season("夏天","炎热");


    //构造器私有化，防止被外部new
    //去掉set相关方法
    //在season内部，直接创建固定的对象
    //优化，可以加入final修饰符
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
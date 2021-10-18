package com.jacky.enumeration;

/**
 * @author Jacky
 * @version 1.0
 * @date 2021/10/16
 */
public class P427Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
        System.out.println(Season2.AUTUMN);

        Season2[] values = Season2.values();
        for (Season2 value : values) {
            System.out.println(value.name());
        }
        for (Season2 value : values) {
            
        }
    }
}

//自定义枚举实现
enum Season2 {
    SPRING("春天","温暖"),WINTER("冬天","寒冷"),AUTUMN("秋天","凉爽"),SUMMER("夏天","炎热")/*,WHAT*/;

    private String name;
    private String desc;

    //如果使用的无参构造器，创建常量对象，则可以直接使用这种类型的定义"WHAT"
    Season2() {
    }

    private Season2(String name, String desc) {
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
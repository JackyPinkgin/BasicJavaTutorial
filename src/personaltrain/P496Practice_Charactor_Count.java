package personaltrain;


/**
 * 2021/10/22
 */
public class P496Practice_Charactor_Count {
    public static void main(String[] args) {
        String a= "asdjSSDDhqwd481sad";
        count(a);

    }

    public static void count(String str) {

        int num = 0, cap = 0, small = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] >= '0' && chars[i] <= '9') {
                num++;
            }
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                small++;
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                cap++;
            }
        }
        System.out.println("数字有 "+num);
        System.out.println("大写字母有 "+cap);
        System.out.println("小写字母有 "+small);

    }
}


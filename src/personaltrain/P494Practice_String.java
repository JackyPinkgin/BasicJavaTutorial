package personaltrain;

import com.sun.org.apache.xpath.internal.axes.PredicatedNodeTest;

/**
 * 2021/10/21
 */
public class P494Practice_String {
    public static void main(String[] args) {


        String str = "abcdefgh";

        try {
            str = recerse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str);


    }

    public static String recerse(String str, int start, int end) {

        if (!(str != null && start >= 0 && end > start && end < str.length())) {
            throw new RuntimeException("参数不正确");

        }

        char[] chars = str.toCharArray();
        char tmp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        return new String(chars);
    }
}

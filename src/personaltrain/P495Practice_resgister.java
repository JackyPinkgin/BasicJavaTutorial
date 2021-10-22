package personaltrain;

/**
 * 2021/10/22
 */
public class P495Practice_resgister {
    public static void main(String[] args) {

        String name = "jack";
        String pwd = "1234588";
        String email = "374@qq.com";
        try {
            userRegister(name, pwd, email);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void userRegister(String name, String pwd, String email) {
        int userLength = name.length();
        if (!(userLength >= 2 && userLength <= 4)) {
            throw new RuntimeException("username length should be 2-4");
        }

        if (!(pwd.length() == 6 && isDigtal(pwd))) {
            System.out.println(isDigtal(pwd));
            throw new RuntimeException("密码长度要是6并且全部是数字");
        }
        int i = email.indexOf("@");
        int j = email.indexOf(".");
        if (!(i > 0 && j > i)) {
            System.out.println("邮箱中需要包含@和.,并且@在.前面");
        }

    }

    public static boolean isDigtal(String str) {

        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}

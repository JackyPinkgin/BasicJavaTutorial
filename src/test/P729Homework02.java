package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 2021/12/1
 */
public class P729Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {

        Class<?> fileClass = Class.forName("java.io.File");

        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        Constructor<?> declaredConstructor = fileClass.getDeclaredConstructor(String.class);
        String filePath = "d:\\new.txt";
        Object o = declaredConstructor.newInstance(filePath);//创建file对象
        System.out.println(o.getClass());

        FileWriter fileWriter = new FileWriter((File) o, true);
        fileWriter.write("风雨之后见彩虹");
        fileWriter.close();

        Method createNewFile = fileClass.getMethod("createNewFile");
        createNewFile.invoke(o);

    }
}

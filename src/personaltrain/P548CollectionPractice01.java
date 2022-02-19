package personaltrain;

import java.util.ArrayList;

/**
 * 2021/10/28
 */
@SuppressWarnings("all")
public class P548CollectionPractice01 {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new News("新冠确诊病例超千万，数百万印度教信徒赴横河\"圣浴\"引民众担忧"));
        arrayList.add(new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));

        for (int i = arrayList.size() - 1; i >= 0; i--) {
//            System.out.println(arrayList.get(i).toString());
            String title = ((News) arrayList.get(i)).getTitle();
            char[] cs = ((News) arrayList.get(i)).getTitle().toCharArray();
            if (cs.length > 15) {
                for (int j = 0; j < 15; j++) {
                    System.out.print(cs[j]);
                }
                System.out.println("...");
            }
        }

        System.out.println("用subString方法");

        for (int i = arrayList.size() - 1; i >= 0; i--) {
            String title = ((News) arrayList.get(i)).getTitle();
            System.out.println(processString(title));
        }

    }

    public static String processString(String title) {
        if (title == null) {
            return "";
        }
        if (title.length() > 15) {
            return title.substring(0, 15) + "...";
        } else {
            return title;
        }

    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
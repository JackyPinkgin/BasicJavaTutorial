import java.awt.*;

//用来快速打开alm上bug的详情页列表

public class BrowserOpen2 {
    public static void main(String[] args) {

        String[] uris = {"2217309","2199265","2191233","2131196","2306680","2322868",
                "2242455","2313737","2313823","1970972","2180130","2159310","2001903","1992084"
        };

        if (Desktop.isDesktopSupported()) {
            for (int i = 0; i < uris.length; i++) {
                try {//创建一个URI实例,注意不是URL
                    String link = "http://alm.adc.com/OPPO/%E4%BA%92%E8%81%94%E7%BD%91%E5%95%86%E4%B8%9A%E4%B8%AD%E5%BF%83/_workitems/edit/" + uris[i];
//                    java.net.URI uri = java.net.URI.create("http://code.oppoer.me/instant-game/" + uris[i] + "/code_statistics");
                    java.net.URI uri = java.net.URI.create(link);
                    //获取当前系统桌面扩展
                    Desktop dp = Desktop.getDesktop();
                    //判断系统桌面是否支持要执行的功能
                    if (dp.isSupported(Desktop.Action.BROWSE)) {
                        //获取系统默认浏览器打开链接
                        dp.browse(uri);
                        System.out.println(link);
                    }
                } catch (NullPointerException e) {
                    //此为uri为空时抛出异常
                } catch (java.io.IOException e) {
                    //此为无法获取系统默认浏览器
                }
            }
        }

    }
}



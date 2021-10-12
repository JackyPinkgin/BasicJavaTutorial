import java.awt.*;

//统计客户端代码变更量时  快速打开所有工程的火眼网页
// TODO: 2021/10/12 增加在打开的页面上，切换tab页，选择特定时间段，获取每一个人的数据并写入到excel中

public class BrowserOpen {
    public static void main(String[] args) {

        String[] uris = {"splash", "comp_share", "comp_web", "comp_game", "comp_ucenter", "comp_video", "comp_welfare", "comp_common",
                "comp_search", "comp_promode", "qg-client-common", "og-network", "qg-client", "qg-card", "qg-stat", "qg-uiwidget",
                "account_auth", "game-instant-imageloader", "card-base", "game-instant-websocket-encrypt", "game-instant-imagepicker",
                "game-instant-log", "game-instant-websocket", "game-instant-network", "game-instant-uiwidget", "JKeyboardPanelSwitch",
                "emoji", "game-instant-okdownload", "game-instant-battle"
        };

        if (java.awt.Desktop.isDesktopSupported()) {
            for (int i = 0; i < uris.length; i++) {
                try {//创建一个URI实例,注意不是URL
                    String link = "http://code.oppoer.me/instant-game/" + uris[i] + "/code_statistics";
                    java.net.URI uri = java.net.URI.create("http://code.oppoer.me/instant-game/" + uris[i] + "/code_statistics");
                    //获取当前系统桌面扩展
                    java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                    //判断系统桌面是否支持要执行的功能
                    if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                        //获取系统默认浏览器打开链接
                        dp.browse(uri);
                        System.out.println(link);
                    }
                } catch (java.lang.NullPointerException e) {
                    //此为uri为空时抛出异常
                } catch (java.io.IOException e) {
                    //此为无法获取系统默认浏览器
                }
            }
        }

    }
}



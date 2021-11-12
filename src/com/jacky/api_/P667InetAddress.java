package com.jacky.api_;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 2021/11/12
 */
public class P667InetAddress {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);


    }
}

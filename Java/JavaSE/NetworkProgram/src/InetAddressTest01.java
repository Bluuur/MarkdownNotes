/*
    InetAddress类表示IP地址

    方法:
        public static InetAddress getByName(String host)确定主机名称的IP地址.主机名称可以是机器名称,也可以是IP地址
        public String getHostName() 获取此IP地址的主机名
        public String getHostAddress() 获取IP地址
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest01 {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress address = InetAddress.getByName("MSI");//通过主机名方式获取InetAddress对象
        InetAddress address = InetAddress.getByName("169.254.122.209");//通过IP地址的方式获取InetAddress对象
        String ip = address.getHostAddress();
        String name = address.getHostName();
        System.out.println(name);
        System.out.println(ip);

    }
}

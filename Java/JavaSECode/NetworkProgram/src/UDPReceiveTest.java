import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
    UDP接收数据的步最
    1: 创建接收端的Socket对象 (DatagramSocket)
    2: 创建一个数据包，用于接收数据
    3: 调用DatagramSocket对象的方法接收数据
    4: 解析数据包，并把数据在控制台显示
    5: 关闭接收端
 */
public class UDPReceiveTest {
    public static void main(String[] args) throws IOException {
//        1: 创建接收端的Socket对象 (DatagramSocket)
        DatagramSocket ds = new DatagramSocket(5555);
//        2: 创建一个数据包，用于接收数据
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);
//        3: 调用DatagramSocket对象的方法接收数据
        ds.receive(dp);
//        4: 解析数据包，并把数据在控制台显示
        byte[] datas = dp.getData();
        int len = dp.getLength();
        String dataStr = new String(datas,0,len);
        System.out.println(dataStr);
//        5: 关闭接收端
        ds.close();
    }
}

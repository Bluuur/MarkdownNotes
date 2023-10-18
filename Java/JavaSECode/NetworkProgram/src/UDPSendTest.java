import java.io.IOException;
import java.net.*;

public class UDPSendTest {
    public static void main(String[] args) throws IOException {
        //创建发送端的Socket对象
        DatagramSocket ds = new DatagramSocket();
        //DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port)
        //创建数据,并把数据打包
        byte[] bys = "test".getBytes();
        DatagramPacket dp = new DatagramPacket(bys,bys.length,InetAddress.getByName("169.254.122.209"),5555);
        //调用DatagramSocket对象的方法发送数据
        ds.send(dp);
        //关闭发送端
        ds.close();
    }
}

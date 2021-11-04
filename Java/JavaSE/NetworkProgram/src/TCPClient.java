import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        while (true){
            //创建客户端的Socket对象
            //Socket(InetAddress address, int port)
            String mes = "";
            Scanner scanner = new Scanner(System.in);
            System.out.print(">>");
            mes = scanner.nextLine();
            Socket s = new Socket("localhost",5555);
            //获取输出流,写数据
            OutputStream os = s.getOutputStream();
            os.write(mes.getBytes());
            //释放资源
            s.close();
        }
    }
}


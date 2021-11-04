import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        while (true){
            //创建服务器端的Socket对象
            ServerSocket ss = new ServerSocket(5555);

            //Socket accept()监听要对这个套接字作出的连接并接受它
            Socket s =  ss.accept();


            //获取输入流,读数据
            InputStream is = s.getInputStream();
            byte[] bys = new byte[1024];
            int len = is.read(bys);
            String data = new String(bys, 0, len);

            //判断data是不是以'来自'开头
//                是-->文本内容,直接在控制台输出
//                不是-->文件,创建fis接受
            
            System.out.println(data);

            //释放资源
            s.close();
            ss.close();
        }
    }

}


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    java.io.FileInputStream
        1.文件字节输入流，万能的，任何类型的文件都可以采用这个流来读取
        2.字节的方式，完成输入的操作，完成读的操作（硬盘--->内存）
 */
public class FileInputStreamTest01 {
    public static void main(String[] args) {
        //创建文件字节输入流对象
        //文件路径：D:\progrem\Java_learnling\chapter01\test（IDEA会自动把\变成\\，因为Java中\表示转义）
        FileInputStream fis = null;
        try {
            //以下都是采用了绝对路径的方式（也可以采用相对路径）
//            FileInputStream fis = new FileInputStream("D:\\progrem\\Java_learnling\\chapter01\\test");
            //也可以写成斜杠/
            fis = new FileInputStream("D:/progrem/Java_learnling/chapter01/test");
            //开始读
            int readData = fis.read();//这个方法的返回值是：读取到的“字节”本身
            System.out.println(readData);//97

            readData = fis.read();
            System.out.println(readData);//98

            readData = fis.read();
            System.out.println(readData);//99

            readData = fis.read();
            System.out.println(readData);//100

            readData = fis.read();
            System.out.println(readData);//101

            readData = fis.read();
            System.out.println(readData);//102
            //读到文件末尾了，读不到内容了，返回-1
            readData = fis.read();//这里读不到内容了，返回值是-1
            System.out.println(readData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//在finally语句块中确保流一定关闭
            if (fis != null) {//关闭流的前提是：流不是空，流是null的时候没必要关闭（避免空指针异常）
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

public class reviewOnThread {
    public static void main(String[] args) {
        ThreadReview tr = new ThreadReview();
        tr.start();//直接调用run()方法相当于普通方法的调用,不会开启新的栈

        for (int i = 0; i < 1000; i++){
            System.out.println("主线程-->" + i);
        }
    }
}

//方法一:继承Thread类
class ThreadReview extends Thread{
    @Override
    public void run() {
        for(int i = 0 ; i < 1000 ; i++){
            System.out.println("分支线程-->" + i);
        }
    }
}

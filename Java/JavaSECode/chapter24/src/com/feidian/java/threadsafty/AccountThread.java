package com.feidian.java.threadsafty;

public class AccountThread extends Thread{
    private Account act;

    public AccountThread(Account act){
        this.act = act;
    }

    @Override
    public void run() {
        //run方法的执行表示取款操作
        //假设取款5000
        double money = 5000;
        synchronized (act){
            act.withdraw(money);
        }
        System.out.println(Thread.currentThread().getName() + "对账户:" + act.getActno() + "取款成功,余额:" + act.getBalance());
    }
}

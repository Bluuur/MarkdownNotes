package com.feidian.java.threadsafty;

public class Account {
    private String actno;
    private double balance;

    public Account() {
    }

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //取款方法
    public void withdraw(double money){
        //多线程并发此方法,会导致线程安全问题
//        synchronized (this){//使用同步代码块;this是账户对象,是被共享的
//            以下是同步代码块
            //取款之前的余额
            double before = this.getBalance();
            //取款之后的余额
            double after = before - money;

            //模拟网络延迟
            try {
                Thread.sleep(24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //更新余额
            this.setBalance(after);

//        }
    }
}

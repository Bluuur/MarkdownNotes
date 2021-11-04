public class SuperTest03 {
}
//银行账户类
class Account{//父类
    //私有属性,只能在本类中调用
    private String actno;
    private double balance;

    //构造方法
    public Account(){

    }

    public Account(String actno, double balance){
        this.actno = actno;
        this.balance =balance;
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
}


class CreditAccount extends Account{//子类
    private double credit;

    public CreditAccount() {
    }

    public CreditAccount(String actno, double balance, double credit) {
        super(actno, balance);//私有属性,通过调用父类的有参构造方法来完成赋值
        this.credit = credit;
    }
    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }
}


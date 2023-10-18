//银行账户类
//账户的属性:账号,余额
public class ExtendsTest01 {
    public static void main(String[] args) {
        //创建普通账户
        Account act = new Account();
        act.setActno("1111111");
        act.setBalance(10000);
        System.out.println(act.getActno() + ",余额" + act.getBalance());

        //创建信用账户
        CreditAccount ca = new CreditAccount();
        ca.setActno("2222222");
        ca.setBalance(-10000);
        ca.setCredit(0.99);
        System.out.println(ca.getActno() + ",余额" + ca.getBalance() + ",信誉度" + ca.getCredit());
    }
}

//银行账户类
class Account{//父类
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

//信用卡类
//class CreditAccount{
//    private String actno;
//    private double balance;
//    private double credit;
//
//    //构造方法
//    public CreditAccount(){
//
//    }
//
//    public String getActno() {
//        return actno;
//    }
//
//    public void setActno(String actno) {
//        this.actno = actno;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public double getCredit() {
//        return credit;
//    }
//
//    public void setCredit(double credit) {
//        this.credit = credit;
//    }
//}
class CreditAccount extends Account{//子类
    private double credit;

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}

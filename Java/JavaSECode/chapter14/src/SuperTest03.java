public class SuperTest03 {
}
//�����˻���
class Account{//����
    //˽������,ֻ���ڱ����е���
    private String actno;
    private double balance;

    //���췽��
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


class CreditAccount extends Account{//����
    private double credit;

    public CreditAccount() {
    }

    public CreditAccount(String actno, double balance, double credit) {
        super(actno, balance);//˽������,ͨ�����ø�����вι��췽������ɸ�ֵ
        this.credit = credit;
    }
    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }
}


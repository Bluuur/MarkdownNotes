public class OverrideTest04 {
    public static void main(String[] args) {
        MyDate t1 = new MyDate(2021,3,13);
        System.out.println(t1.toString());//��Ҫ��������յ���Ϣ,��Ҫ����toString����
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;
    public MyDate(){}
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "��" + month + "��" + day + "��";
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

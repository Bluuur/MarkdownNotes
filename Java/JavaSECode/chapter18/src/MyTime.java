import java.util.Objects;

public class MyTime {
    private int year;
    private int month;
    private int day;

    public MyTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object obj) {//�������Ҫ����ת��(��̬),��Ϊ��д����,���ܸĶ���ʽ�����б�
        if(obj == null || !(obj instanceof MyTime)){//�������Ķ���Ϊnull,ֱ�ӷ���false;�������Ķ�����MyTime����,ֱ�ӷ���false
            return false;
        }

        if(obj == this){//�������Ķ�����������,ֱ�ӷ���true
            return true;
        }

        //obj��MyTime�ĸ���,����ת��
        MyTime mt = (MyTime) obj;
        return this.year == mt.year && this.month == mt.month && this.day == mt.day;
    }

//    @Override
//    public String toString() {
//        return "MyTime{" +
//                "year=" + year +
//                ", month=" + month +
//                ", day=" + day +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MyTime myTime = (MyTime) o;
//        return year == myTime.year && month == myTime.month && day == myTime.day;
//    }


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

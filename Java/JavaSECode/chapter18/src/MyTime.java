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
    public boolean equals(Object obj) {//这里必须要向下转型(多态),因为重写方法,不能改动形式参数列表
        if(obj == null || !(obj instanceof MyTime)){//如果传入的对象为null,直接返回false;如果传入的对象不是MyTime类型,直接返回false
            return false;
        }

        if(obj == this){//如果传入的对象是它本身,直接返回true
            return true;
        }

        //obj是MyTime的父类,向下转型
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

/*
    this除了可以用在实例方法中，还可以用在构造方法中
    通过当前的狗仔方法去调用另一个本类的构造方法
    可以使用以下语法格式
        this (实际参数列表);
        通过一个构造方法1去调用构造方法2，可以做到代码复用
        但需要注意的是，构造方法1和构造方法2都是在同一个类中
    this();方法只能出现在构造方法的第一行，并且只能出现一次（废话）
 */
public class ThisTest04 {
    public static void main(String[] args) {
        //调用无参数的构造方法
        Date d1 = new Date();
        d1.detail();
        //调用有参数的构造方法
        Date d2 = new Date(2020, 12,19);
        d2.detail();
    }
}
/*
    需求：
        1.定义一个日期类，可以表示年月日信息
        2.要求如果调用参数构造方法，默认创建的日期为：1970年1月1日
            除了调用无参数构造方法外，也可以调用有参数的构造方法来创建日期对象
 */
class Date{
    //年
    private int year;
    //月
    private int month;
    //日
    private int day;
    //无参数构造方法
    public Date() {
//        以下
//        this.year = 1970;
//        this.month = 1;
//        this.day = 1;
        this(1970, 1, 1);//实现代码复用
    }
    //提供一个可以打印日期的方法
    public void detail(){
        System.out.println(year + "年" + month + "月" + day + "日");
    }
    //有参数构造方法
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //setter and getter
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
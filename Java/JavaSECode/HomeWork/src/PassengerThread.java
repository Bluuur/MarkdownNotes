public class PassengerThread extends Thread{
    private SellTickets st;

    public PassengerThread(SellTickets st) {
        this.st = st;
    }

    @Override
    public void run() {
        while (st.getTickNum() > 0) {
            synchronized (st){
                st.sell(1);
            }
        }
    }
}

class SellTickets{
    private int tickNum;

    public SellTickets (int tickNum) {
        this.tickNum = tickNum;
    }

    public void sell(int tickBought){
        if(this.getTickNum() == 0){
            return;
        }
        tickNum = this.getTickNum();
        int remain = tickNum - tickBought;
        System.out.println(Thread.currentThread().getName() + "购买了" + tickBought + "张票,剩余" + remain +"张票");
        if(remain == 0){
            System.out.println("已售罄");
        }
        setTickNum(remain);
    }

    public int getTickNum() {
        return tickNum;
    }

    public void setTickNum(int tickNum) {
        this.tickNum = tickNum;
    }
}

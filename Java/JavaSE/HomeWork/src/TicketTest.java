public class TicketTest {
    public static void main(String[] args) {
        SellTickets st = new SellTickets(100);
        Thread passenger1 = new PassengerThread(st);
        Thread passenger2 = new PassengerThread(st);

        passenger1.setName("黄牛1");
        passenger2.setName("黄牛2");
        passenger1.start();
        passenger2.start();
    }
}

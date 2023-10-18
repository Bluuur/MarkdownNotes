public class ForTest05{
    public static void main(String[] args) {
        for(int i = 1; i < 10; i++){
            for(int t = 1; t <= i; t++){
                System.out.print(t + "*" + i +"=" + (i * t) + "     ");
            }
            System.out.println("");
        }
    }
}

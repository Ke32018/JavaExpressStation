package 快递e栈.View;

import java.util.Scanner;

public class DemoTest {
    public static void main(String[] args) {
        boolean k = choose();
        System.out.println(k);
    }

    public  static boolean choose(){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        boolean choose ;
        choose = s.equals("Y") || s.equals("y");
        return choose;
    }
}

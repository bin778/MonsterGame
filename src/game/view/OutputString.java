package game.view;

import java.util.Scanner;
public class OutputString {
    Scanner sc = new Scanner(System.in);

    public String outputString() {
        return sc.nextLine().trim();
    }
}

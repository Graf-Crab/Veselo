package gallows.main;


import java.util.Scanner;

public class StartGame {


    public static void main(String[] args) {

        GameProcess gameProcess = new GameProcess();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t\u001B[40mHi mannn\u001B[0m");
        System.out.println("\u001B[42mCan we Start? (Y / N)\u001B[0m");

        String a = scanner.next();

        if (a.matches("[y  Y]")) {
            gameProcess.gameStart();
        } else {
            scanner.close();
            System.out.println("See you later!\nGoodBYE!!!");
        }
    }
}








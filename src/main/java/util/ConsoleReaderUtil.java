package util;

import java.util.Scanner;
import service.Application;

public class ConsoleReaderUtil {
    public static Scanner scanner = new Scanner(System.in);

    //TODO: make it workable
    public void readFromConsole() {
        System.out.println("If you want to use console input "
                + "- just enter the path to file or url.");
        System.out.println("When you want to stop - enter \"Stop\" message)");
        Application.workOutUrlInput(scanner.nextLine());
        scanner.close();
    }
}

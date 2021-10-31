package util;

import java.util.Scanner;
import service.Application;

public class ConsoleReaderUtil {
    private static Scanner scanner = new Scanner(System.in);

    public void readFromConsole() {
        System.out.println("If you want to use console input"
                + "- just enter the path to file or url.");
        String input = scanner.nextLine();
        if (!input.equals("Stop")) {
            if (input.indexOf("http") != -1) {
                Application.workOutUrlInput(input);
            } else {
                Application.workOutFilesInput(input);
            }
        }
        scanner.close();
    }
}

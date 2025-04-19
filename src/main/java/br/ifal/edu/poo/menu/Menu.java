package br.ifal.edu.poo.menu;

import br.ifal.edu.poo.exceptions.menu.MenuIllegalOptionException;
import br.ifal.edu.poo.exceptions.menu.MenuInvalidOptionException;

import java.util.Map;
import java.util.Scanner;

public abstract class Menu {

    protected abstract String getString();
    protected abstract Map<String, MenuOption> getOptions();
    protected abstract boolean isInputValid(String input);
    protected abstract boolean shouldExit(String input);

    private String validateInput(Scanner scanner, String input) {
        try {
            if (!isInputValid(input)) {
                throw new MenuInvalidOptionException();
            }
        } catch (MenuInvalidOptionException exception) {
            System.out.println(exception.getMessage());

            return validateInput(scanner, scanner.nextLine());
        }

        return input;
    }

    public void printOptions() {
        final Map<String, MenuOption> options = getOptions();

        for (Map.Entry<String, MenuOption> entry : options.entrySet()) {
            final MenuOption option = entry.getValue();

            option.print(entry.getKey());
        }
    }

    public void start() {
        printOptions();
        System.out.println("> ");

        try (Scanner scanner = new Scanner(System.in)) {
            String input = validateInput(scanner, scanner.nextLine());
            final MenuOption option = getOptions().get(input);

            if (option == null) {
                throw new MenuIllegalOptionException();
            }

            try {
                option.onChoose().accept(scanner);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            while (!shouldExit(input)) {
                input = validateInput(scanner, scanner.nextLine());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}

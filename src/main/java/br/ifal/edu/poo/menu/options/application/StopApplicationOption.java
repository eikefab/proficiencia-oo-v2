package br.ifal.edu.poo.menu.options.application;

import br.ifal.edu.poo.menu.MenuOption;

import java.util.Scanner;
import java.util.function.Consumer;

public class StopApplicationOption extends MenuOption {

    public StopApplicationOption() {
        super("Sair");
    }

    @Override
    public Consumer<Scanner> onChoose() {
        return (scanner) -> {
            System.out.println("Saindo...");
            System.exit(0);
        };
    }

}

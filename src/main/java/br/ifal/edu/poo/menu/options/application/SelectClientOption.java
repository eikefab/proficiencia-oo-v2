package br.ifal.edu.poo.menu.options.application;

import br.ifal.edu.poo.ClientApplication;
import br.ifal.edu.poo.menu.MenuOption;

import java.util.Scanner;
import java.util.function.Consumer;

public class SelectClientOption extends MenuOption {

    public SelectClientOption() {
        super("Acessar como cliente");
    }

    @Override
    public Consumer<Scanner> onChoose() {
        return (scanner) -> {
            ClientApplication.main(new String[] {});
        };
    }
}

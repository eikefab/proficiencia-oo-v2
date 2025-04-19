package br.ifal.edu.poo.menu.options.application;

import br.ifal.edu.poo.ServerApplication;
import br.ifal.edu.poo.menu.MenuOption;

import java.util.Scanner;
import java.util.function.Consumer;

public class SelectServerOption extends MenuOption {

    public SelectServerOption() {
        super("Acessar como servidor");
    }

    @Override
    public Consumer<Scanner> onChoose() {
        return (scanner) -> {
            ServerApplication.main(new String[] {});
        };
    }

}

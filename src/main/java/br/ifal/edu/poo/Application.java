package br.ifal.edu.poo;

import br.ifal.edu.poo.menu.ApplicationMenu;
import br.ifal.edu.poo.menu.Menu;

public final class Application {

    private static final Menu APPLICATION_MENU = new ApplicationMenu();

    public static void main(String[] args) {
        APPLICATION_MENU.start();
    }

}

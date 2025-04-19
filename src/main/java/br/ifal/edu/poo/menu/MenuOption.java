package br.ifal.edu.poo.menu;

import java.util.Scanner;
import java.util.function.Consumer;

public abstract class MenuOption {

    private final String optionText;

    public MenuOption(String optionText) {
        this.optionText = optionText;
    }

    public abstract Consumer<Scanner> onChoose();

    public String getOptionText() {
        return optionText;
    }

    public void print(String key) {
        System.out.println(key + " - " + optionText.trim());
    }

}

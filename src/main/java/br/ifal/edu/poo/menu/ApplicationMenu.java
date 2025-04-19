package br.ifal.edu.poo.menu;

import br.ifal.edu.poo.menu.options.application.SelectClientOption;
import br.ifal.edu.poo.menu.options.application.SelectServerOption;
import br.ifal.edu.poo.menu.options.application.StopApplicationOption;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApplicationMenu extends Menu {

    @Override
    protected String getString() {
        return "main";
    }

    @Override
    protected Map<String, MenuOption> getOptions() {
        final Map<String, MenuOption> options = new LinkedHashMap<>();

        options.put("1", new SelectServerOption());
        options.put("2", new SelectClientOption());
        options.put("3", new StopApplicationOption());

        return options;
    }

    @Override
    protected boolean isInputValid(String input) {
        try {
            final int option = Integer.parseInt(input);

            return option >= 1 && option <= 3;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    @Override
    protected boolean shouldExit(String input) {
        final int option = Integer.parseInt(input);

        return option == 3;
    }

}

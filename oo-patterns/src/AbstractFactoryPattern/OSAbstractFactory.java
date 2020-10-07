/**
 *  -> Abstract Factory Pattern
 *
 *  1. Create standard factory
 *  2. Add layer of abstraction to have multiple components
 *     under separate factories, where factory is now an interface
 *
 */

package AbstractFactoryPattern;

interface UI {
    String button();
    String dialog();
}

interface Menu {
    String menu();
}

class WindowsButtons implements UI {
    @Override
    public String button() {
        return "Windows Button";
    }

    @Override
    public String dialog() {
        return "Windows Dialog";
    }
}

class WindowsMenu implements Menu {
    @Override
    public String menu() {
        return "Welcome to Windows 98";
    }
}

class MacOSButtons implements UI {
    @Override
    public String button() {
        return "MacOS Button";
    }

    @Override
    public String dialog() {
        return "MacOS Dialog";
    }
}

class MacOSMenu implements Menu {
    @Override
    public String menu() {
        return "Welcome to Macintosh";
    }
}

interface OSFactory {
    UI getUI();
    Menu getMenu();
}

class MacOSFactory implements OSFactory {
    @Override
    public UI getUI() {
        return new MacOSButtons();
    }

    @Override
    public Menu getMenu() {
        return new MacOSMenu();
    }
}

class WindowsFactory implements OSFactory {
    @Override
    public UI getUI() {
        return new WindowsButtons();
    }

    @Override
    public Menu getMenu() {
        return new WindowsMenu();
    }
}

class Test {
    public static void main(String[] args) {
        OSFactory os;
        String thisOs = "Windows";

        if(thisOs.equals("Windows")) {
            os = new WindowsFactory();
        } else {
            os = new MacOSFactory();
        }

        System.out.println(os.getUI().button());
        System.out.println(os.getMenu().menu());
    }
}


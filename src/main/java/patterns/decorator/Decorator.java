package patterns.decorator;

public class Decorator {
    public static void main(String[] args) {
        PrinterInterface printerInterface = new QuotesDecorator(new Printer("hey"));
        printerInterface.print();
    }
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {
    private String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

class QuotesDecorator implements PrinterInterface {
    private PrinterInterface component;

    public QuotesDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}


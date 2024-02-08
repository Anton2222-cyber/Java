package anonym_vs_lambda;

public class Controller {
    public Controller() {
        System.out.println("Controller: " + this);//посилання на об'єкт класу Controller
    }

    void test(){
        System.out.println("test");
    }

    void start() {
        Printer printerAnonymous = new Printer() {
            @Override
            public void print() {
                Controller.this.test();
                test();

                System.out.println("printerAnonymous: " + this);//посилання на об'єект анонімного класу
                System.out.println("printerAnonymous: " + Controller.this);//посилання на об'єкт класу Controller

            }
        };

        Printer printerLambda = () -> {
            System.out.println("printerLambda: " + this);//посилання на об'єкт класу Controller
        };

        printerAnonymous.print();
        printerLambda.print();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }
}

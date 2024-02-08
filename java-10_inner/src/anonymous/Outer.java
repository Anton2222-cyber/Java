package anonymous;

public class Outer {
    private int instanceVariable = -1;
    Worker worker = new Worker() {
        @Override
        public void work() {
            System.out.println(instanceVariable);
        }
    };
    static Worker worker2 = new Worker() {
        @Override
        public void work() {
//            System.out.println(instanceVariable);
        }
    };

    public void outerMethod() {
//        int localeVariable = -100;
//        Worker worker3 = new Worker() {
//            @Override
//            public void work() {
//                System.out.println(localeVariable);
////                localeVariable = 111;
//            }
//        };

        int localeVariable = -100;
        Worker worker3 = () -> {
            System.out.println(localeVariable);
            //localeVariable = 111;
        };
    }

}

package zateev;

public class Main {
    public static void main(String[] args) {
        Massive massive = new Massive();
//        System.out.println(Arrays.deepToString(massive.createMass(10000,3)));
        long s = System.currentTimeMillis();
        FindOnWidth findOnWidth = new FindOnWidth();

        findOnWidth.findRoute(massive.createMass(10000,1000));

        System.out.println((System.currentTimeMillis()-s));
        System.out.println(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory());
    }


}

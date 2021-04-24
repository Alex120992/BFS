package zateev;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Massive massive = new Massive();
//        System.out.println((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()));
        RouterFinderImpl routerFinderImpl = new RouterFinderImpl();
        routerFinderImpl.findRoute(massive.createMass(2000,1000));

    }
}

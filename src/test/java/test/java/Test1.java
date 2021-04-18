package test.java;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.junit.*;
import org.junit.rules.TestRule;
import zateev.FindOnWidth;
import zateev.Massive;
import zateev.RouteFinder;

public class Test1 {
    RouteFinder routeFinder;
    Massive massive;
    @Rule
    public TestRule benchMark = new BenchmarkRule();

    @Before
    public void setUp() {

        routeFinder = new FindOnWidth();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 5)
    public void changeMemoryInAddingMassive() {
        massive = new Massive();
        char[][] mas = massive.createMass(10000, 10000);
        int f = mas.length * mas[0].length;
        int s = 100000000;


        Assert.assertEquals(s ,f );
    }

    @After
    public void zeroing() {
        routeFinder = null;
    }
}
package test.java;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import zateev.RouterFinderImpl;

public class Test1 {
    RouterFinderImpl routeFinder;
    Massive massive;
    @Rule
    public TestRule benchMark = new BenchmarkRule();

    @Before
    public void setUp() {
        routeFinder = new RouterFinderImpl();
        massive = new Massive();
    }

    @Test
    @BenchmarkOptions(concurrency = 1, warmupRounds = 0, benchmarkRounds = 1)
    public void time1() {
        routeFinder.findRoute(massive.createMass2(2000,1000));
    }

    @After
    public void zeroing() {
        routeFinder = null;
    }
}
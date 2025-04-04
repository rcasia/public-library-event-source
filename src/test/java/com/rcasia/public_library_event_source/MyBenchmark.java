package com.rcasia.public_library_event_source;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class Bench {

    @Param({"10", "100", "1000", "10000"})
    public int size;

    private List<Integer> list;

    @Setup(Level.Iteration)
    public void setUp() {
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    @Benchmark
    public int benchmark() {
        return list.get(0);
    }
}

package me.bruno.santana.incubator;

import jdk.incubator.vector.IntVector;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//Add VM options: --add-modules jdk.incubator.vector
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
//@Warmup(iterations = 3)
//@Measurement(iterations = 8)
public class VectorApiDemo {

    public static void main(String[] args) throws RunnerException {
        /*sumTwoArrays();
        System.out.println("--------------------------------------------------");
        sumTwoArraysUsingVectorApi();*/
        Options opt = new OptionsBuilder()
                .include(VectorApiDemo.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public static void sumTwoArrays() {
        /*System.out.println("sumTwoArrays");
        Instant start = Instant.now();*/

        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] array2 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};

        int[] result = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] + array2[i];
        }

        /*Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis() + " ms");
        System.out.println(Duration.between(start, end).toNanos() + " ns");*/

        System.out.println(Arrays.toString(result));
    }

    @Benchmark
    public static void sumTwoArraysUsingVectorApi(){
        /*System.out.println("sumTwoArraysUsingVectorApi");
        Instant start = Instant.now();*/

        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] array2 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        int[] result = new int[array1.length];

        var species = IntVector.SPECIES_PREFERRED;
        var vector1 = IntVector.fromArray(species, array1, 0);
        var vector2 = IntVector.fromArray(species, array2, 0);
        var vectorResult = vector1.add(vector2);
        vectorResult.intoArray(result, 0);

        /*Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis() + " ms");
        System.out.println(Duration.between(start, end).toNanos() + " ns");*/

        System.out.println(Arrays.toString(result));
    }

}

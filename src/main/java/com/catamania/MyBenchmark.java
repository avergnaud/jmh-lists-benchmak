package com.catamania;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/*
 * http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/
 * */

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class MyBenchmark {

	int size = 1_000_000;
	Integer[] array = new Integer[size];
	LinkedList<Integer> linkedList = new LinkedList<>();
	ArrayList<Integer> arrayList = new ArrayList<>();
	Random random = new Random();

	@Setup
	public void setupArray() {
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt();
		}
	}

	@Setup
	public void setupLists() {
		for (int i = 0; i < size; i++) {
			int toAdd = random.nextInt();
			linkedList.add(toAdd);
			arrayList.add(toAdd);
		}
	}

	@Benchmark
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MICROSECONDS)
	@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MICROSECONDS)
	public int benchmarkGetFromLinkedList() {
		Integer retour = linkedList.get(size/2);
		return retour;
	}

	@Benchmark
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MICROSECONDS)
	@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MICROSECONDS)
	public int benchmarkGetFromArrayList() {
		Integer retour = arrayList.get(size/2);
		return retour;
	}
}

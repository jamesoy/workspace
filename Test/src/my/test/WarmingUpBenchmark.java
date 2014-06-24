package my.test;

import java.util.ArrayList;
import java.util.List;

public class WarmingUpBenchmark {

	public static void main(String[] args) {
		int warmUpCycles = 3000000;
		int testCycles = 5000000;
		
		WarmingUpBenchmark wub = new WarmingUpBenchmark();
		System.err.println("Warming up benchmark...");
		long nanosPerIteration = wub.runTest(warmUpCycles);
		System.err.println("Done warming up benchmark.");
		System.err.println("Nanoseconds per iteration: " + nanosPerIteration);
		System.gc();
		System.runFinalization();
		Runtime.getRuntime().gc();
		System.gc();
		System.runFinalization();
		Runtime.getRuntime().gc();
		System.gc();
		System.runFinalization();
		Runtime.getRuntime().gc();
		System.err.println("Entering measurement interval...");
		nanosPerIteration = wub.runTest(testCycles);
		System.err.println("Measurement interval done.");
		System.err.println("Nanoseconds per iteration: " + nanosPerIteration);
	}

	private long runTest(int iterations) {
		long startTime = System.nanoTime();
		
		for (int i = 0; i < iterations; i++) {
			doWork();
		}
		
		long elapsedTime = System.nanoTime();
		return (elapsedTime - startTime) / iterations;
	}
	
	private void doWork() {
		List<Integer> intList = new ArrayList<Integer>();
		int j = 1;
		for (int i = 0; i < 100; i++) {
			intList.add(j++);
		}
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += intList.get(i);
		}
		assert sum > 0;
	}
}

package my.test;

public class OptimizingAwayDead {

	final private static long NANOS_PER_MS = 1000000L;
	final private static int NUMBER = 25;
	
	public static void main(String[] args) {
		System.err.println("Warming up...");
		doTest(1000000L);
		System.err.println("1st warming up done.");
		System.err.println("Starting 2nd warming up...");
		doTest(900000000L);
		System.err.println("2nd warming up done.");
		System.err.println("Starting measurement interval...");
		doTest(900000000L);
		System.err.println("Measurement interval done.");
		System.err.println("\nTest completed.");
	}

	private static int calcFibonacci(int n) {
		int prev = -1;
		int result = 1;
		int sum = 0;
		
		for (int i = 0; i <= n; i++) {
			sum = prev + result;
			prev = result;
			result = sum;
		}
		
		return result;
	}
	
	private static void doTest(long iterations) {
//		int answer = 0;
		long startTime = System.nanoTime();
		for (long i = 0; i < iterations; i++) {
//			answer = calcFibonacci(NUMBER);
			calcFibonacci(NUMBER);
		}
//		assert answer > 0;
		long elapsedTime = System.nanoTime() - startTime;
		System.err.println("	Elapsed nanoseconds -> " + elapsedTime);
		float millis = elapsedTime / NANOS_PER_MS;
		float itrsPerMs = 0;
		if (millis != 0) {
			itrsPerMs = iterations / millis;
		}
		System.err.println("	Iterations per ms ---> " + itrsPerMs);
	}
	
	//90_909.09
	//2_319_587.8
	
	//90909.09
	//2325581.5
	
	//71428.57
	//2380952.5
	//2459016.5
	
	// Optimizing Away Dead Code is not happening on JDK 1.8
	
	//100_000
	//2_307_692
}

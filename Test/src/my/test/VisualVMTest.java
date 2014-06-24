package my.test;

import java.util.Scanner;
 
public class VisualVMTest {
      private static final long WARM_UP = 1000000L;
      private static final long TESTING = 5000000L;
      private static final long NANOS_PER_MILLIS = 1000000L;
 
      /**
      * @param args
      */
      public static void main(String[] args) {
            System.err.println("Presss any key to start...");
            Scanner readUserInput=new Scanner(System.in); 
            System.err.println(readUserInput.nextLine());
           
            System.err.println("Warming up started.");
            long startTime = System.nanoTime();
            for (int i = 0; i < WARM_UP; i++) {
                  fibonacci(25);
            }
            long elapsedTime = System.nanoTime() - startTime;
            System.err.println("Warming up ended.");
            System.err.println("Iterations per millis: " + WARM_UP / (elapsedTime / NANOS_PER_MILLIS));
           
            System.err.println("Testing started.");
            startTime = System.nanoTime();
            for (int i = 0; i < TESTING; i++) {
                  fibonacci(25);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.err.println("Iterations per millis: " + TESTING / (elapsedTime / NANOS_PER_MILLIS));
            System.err.println("Testing ended.");
 
            System.err.println("Presss any key to finish...");
            readUserInput=new Scanner(System.in); 
            System.err.println(readUserInput.nextLine());
            System.err.println("Completed.");
      }
 
      private static int fibonacci(int n) {
            int first = -1;
            int second = 1;
            int third = 0;
 
            for (int i = 0; i <= n; i++) {
                  third = first + second;
                  first = second;
                  second = third;
            }
           
            return second;
      }
}
import java.util.*;
public class recursion{
  public static double pError(double guess, double actual){
    return Math.abs(guess - actual) / actual * 100.0;
  }
  public static double sqrt(double n, double guess){
    if (pError(guess * guess, n) > .001){
      return sqrt(n, (n / guess + guess) / 2.0);
    } else {
      return guess;
    }
  }

  public static double sqrt(double n){
    return sqrt(n, 1);
  }

  public static int fib(int n){
    return fibHelper(n, 0, 1);
  }

  public static int fibHelper(int n, int first, int second){
    if (n == 0){
      return first;
    } else {
      return fibHelper(n - 1, second, first + second);
    }
  }

  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> result = new ArrayList<Integer>();
    return mAS(n, 0, result);
  }

  public static ArrayList<Integer> mAS(int n, int sum, ArrayList<Integer> a){
    if (n == 1){
      a.add(sum);
    } else {
      mAS(n - 1, sum + n, a);
      mAS(n - 1, sum, a);
    }
    return a;
  }

  public static void main(String[] args){
    System.out.println("Square root of 100: " + sqrt(100.0));
    System.out.println("Square root of 64: " + sqrt(64.0));
    System.out.println("30th term of fib sequence: " + fib(30));
    System.out.println("20th term of fib sequence: " + fib(20));
    System.out.println("/n");
    System.out.println("makeAllSums(5): " + makeAllSums(5));
    System.out.println("makeAllSums(8): " + makeAllSums(8));
  }
}

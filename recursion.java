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

  public static void main(String[] args){
    System.out.println("Square root of 100: " + sqrt(100.0));
    System.out.println("Square root of 64: " + sqrt(64.0));
    System.out.println("30th term of fib sequence: " + fib(30));
    System.out.println("20th term of fib sequence: " + fib(20));
  }
}

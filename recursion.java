import java.util.*;
public class recursion{
  public static boolean closeEnough(double guess, double actual){
    return Math.abs(guess - actual) <= .00001;
  }
  public static double sqrtHelp(double n, double guess, double tolerance){
    if (!(Math.abs(1 - (n / (guess * guess))) <= tolerance)){
      return sqrtHelp(n, (n / guess + guess) / 2.0, tolerance);
    } else {
      return guess;
    }
  }

  public static double sqrt(double n, double tolerance){
    if (n == 0){
	return 0;
    }
    return sqrtHelp(n, 1, tolerance);
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

//testcase must be a valid index of your input/output array
public static void testFib(int testcase){
  recursion r = new recursion();
  int[] input = {0,1,2,3,5,30};
  int[] output ={0,1,1,2,5,832040};
  int max = input.length;
  if(testcase < input.length){
    int in = input[testcase];
    try{
     
      int ans = r.fib(in);
      int correct = output[testcase];
      if(ans == correct){
        System.out.println("PASS test fib "+in+". "+correct);
      }
      else{
        System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);
       
      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test fib"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}


//testcase must be a valid index of your input/output array
public static void testSqrt(int testcase){
  recursion r = new recursion();
  double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
  double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
  int max = input.length;
  if(testcase < input.length){
    double in = input[testcase];
    try{
     
      double ans = r.sqrt(in,.00001);
      double correct = Math.sqrt(in);
      if(closeEnough(ans,correct)){
        System.out.println("PASS test sqrt "+in+" "+ans);
      }
      else{
        System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);
       
      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}

  public static void main(String[] args){
  	for (int i = 0; i < 5; i++){
		testSqrt(i);
	}
	for (int i = 0; i < 6; i++){
		testFib(i);
	}
  }
}

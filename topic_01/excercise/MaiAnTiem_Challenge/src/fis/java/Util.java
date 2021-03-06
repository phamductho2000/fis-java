package fis.java;

public final class Util {
	
	//Kiem tra co thuoc day fibonacci hay khong?
	public static boolean checkfibonacci(int n) {
        int a = 0;
        int b = 1;
        if (n==a || n==b) return true;
        int c = a+b;
        while(c <= n)
        {
            if(c == n) return true;
            a = b;
            b = c;
            c = a + b;
        }
        return false;
    }
	
	//Tim so tam giac
	public static int findTriangularNumber(int n) {
		int triangular = 0;
		for(int i = 1; i <= n; i++) {
	           triangular = triangular + i;
	     }
		return triangular;
	}
	
	//Kiem tra so nguyen to
	public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

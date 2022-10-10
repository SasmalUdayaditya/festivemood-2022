// Java code to check whether a
// number is Emirpimes or not
import java.io.*;

class CheckNumberEmirpimes
{
	
	// Checking whether a number
	// is semi-prime or not
	static boolean checkSemiprime(int num)
	{
		int cnt = 0;
		for (int i = 2; cnt < 2 &&
						i * i <= num; ++i)
		{
			while (num % i == 0)
			{
				num /= i;
	
				// Increment count of
				// prime numbers
				++cnt;
			}
		}
	
		// If number is still greater than 1,
		// after exiting the for loop add it
		// to the count variable as it indicates
		// the number is a prime number
		if (num > 1)
			++cnt;
	
		// Return '1' if count is equal
		// to '2' else return '0'
		return cnt == 2;
	}
	
	// Checking whether a number
	// is emirpimes or not
	static boolean isEmirpimes(int n)
	{
		// Number itself is not semiprime.
		if (checkSemiprime(n) == false)
			return false;
	
		// Finding reverse of n.
		int r = 0;
		for (int t = n; t != 0; t = t / n)
			r = r * 10 + t % 10;
	
		// The definition of emirpimes excludes
		// palindromes, hence we do not check
		// further, if the number entered is a
		// palindrome
		if (r == n)
			return false;
	
		// Checking whether the reverse of the
		// semi prime number entered is also
		// a semi prime number or not
		return (checkSemiprime(r));
	}

	// Driver Code
	public static void main (String[] args)
	{
		int n = 15;
		if (isEmirpimes(n))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

// This code is contributed by Ajit.

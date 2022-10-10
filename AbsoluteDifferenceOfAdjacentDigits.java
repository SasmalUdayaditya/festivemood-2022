// Java implementation of the above approach
import java.util.*;

class AbsoluteDifferenceOfAdjacentDigits
{

	// Function to check for a prime number
	static boolean Prime(int n)
	{
		if (n == 1)
			return false;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	// Function to find the sum of array
	static boolean checkSumPrime(String str)
	{
		int summ = 0;
		for (int i = 1; i < str.length(); i++)
			summ += Math.abs(str.charAt(i - 1) -
							str.charAt(i));

		if (Prime(summ))
			return true;
		else
			return false;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int num = 142;
		String str = "142";
		if (checkSumPrime(str))
			System.out.println("Prime");
		else
			System.out.println("Not Prime");
	}
}

// This code is contributed by
// sanjeev2552

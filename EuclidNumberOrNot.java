// Java program to check Euclid Number

import java.util.*;

class EuclidNumberOrNot {

	static final int MAX = 10000;
	static Vector<Integer> arr = new Vector<Integer>();

	// Function to get the prime numbers
	static void SieveOfEratosthenes()
	{
		// Create a boolean array "prime[0..n]" and initialize
		// all entries it as true. A value in prime[i] will
		// finally be false if i is Not a prime, else true.
		boolean[] prime = new boolean[MAX];

		for (int i = 0; i < MAX; i++)
			prime[i] = true;

		for (int p = 2; p * p < MAX; p++) {

			// If prime[p] is not changed, then it is a prime
			if (prime[p] == true) {

				// Update all multiples of p
				for (int i = p * 2; i < MAX; i += p)
					prime[i] = false;
			}
		}

		// store all prime numbers
		// to vector 'arr'
		for (int p = 2; p < MAX; p++)
			if (prime[p])
				arr.add(p);
	}

	// Function to check the number for Euclid Number
	static boolean isEuclid(long n)
	{

		long product = 1;
		int i = 0;
		while (product < n) {

			// Multiply next prime number
			// and check if product + 1 = n
			// holds or not
			product = product * arr.get(i);

			if (product + 1 == n)
				return true;

			i++;
		}

		return false;
	}
	public static void main(String[] args)
	{

		// Get the prime numbers
		SieveOfEratosthenes();

		// Get n
		long n = 31;

		// Check if n is Euclid Number
		if (isEuclid(n))
			System.out.println("YES");
		else
			System.out.println("NO");

		// Get n
		n = 42;

		// Check if n is Euclid Number
		if (isEuclid(n))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}

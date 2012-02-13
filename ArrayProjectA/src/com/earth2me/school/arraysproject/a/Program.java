package com.earth2me.school.arraysproject.a;

import java.util.ArrayList;
import java.util.List;

import com.earth2me.school.arraysproject.Console;
import com.earth2me.school.arraysproject.IProgram;

/**
 * @author Paul Buonopane
 * @category APCS
 * @school Medfield High School
 * @version 1.0.0
 */
final class Program implements IProgram
{
	private final static double[] INPUT = new double[] { 3.9, 7.8, 2.0, 0.1, 11.0, 10.0, -1.0, 0.001, 7.0, 1.0 };

	/**
	 * @see com.earth2me.school.arraysproject.IInitializable#initialize()
	 */
	@Override
	public final void initialize()
	{
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public final void run()
	{
		// Get a local alias to the constant, in case we want to use something
		// more dynamic in the future.
		final double[] set = INPUT;
		
		// Perform calculations.
		final double average = getAverage(set);
		final Double[] greater = getGreaterThan(set, average);
		
		// Report the average.
		Console.writeLine("Approximate Average: %.3f", average);
		
		// Report the numbers greater than the average:
		{
			Console.writeLine("Set Values Greater than Average:");
			
			// This will hold the string format; looks like "%f %f %f %f"
			StringBuilder format = new StringBuilder();
			
			// Build the format.
			for (int i = 0; i < greater.length; i++)
			{
				// Don't append a space to the first %f.
				if (i > 0)
				{
					format.append(' ');
				}
				
				// Floating-point format.
				format.append("%f");
			}
			
			// This is why we needed the object array, not the primitive
			// double array.
			Console.writeLine(format.toString(), (Object[])greater);
		}
	}

	/**
	 * Calculates the average of a set of numbers.
	 * 
	 * @param set
	 *            The set of numbers.
	 * @return The average of the set of numbers.
	 */
	private final double getAverage(final double[] set)
	{
		double sum = 0.0;

		// Calculate the sum.
		for (int i = 0; i < set.length; i++)
		{
			sum += set[i];
		}

		// Divide by the count to get the average.
		return sum / set.length;
	}

	/**
	 * Get all the numbers greater than a specified threshold.
	 * 
	 * @param set
	 *            The number set to use in the calculations.
	 * @param threshold
	 *            The threshold that numbers must exceed to be included in the
	 *            returned array.
	 * @return An array of all numbers exceeding the specified threshold.
	 */
	private final Double[] getGreaterThan(final double[] set, final double threshold)
	{
		// Find all the numbers in the set greater than the threshold.
		List<Double> greater = new ArrayList<Double>();
		for (int i = 0; i < set.length; i++)
		{
			if (set[i] > threshold)
			{
				greater.add(set[i]);
			}
		}
		
		// We'll need the object form later, not the primitive form.
		return greater.toArray(new Double[0]);
	}

	/**
	 * @see com.earth2me.school.arraysproject.IDisposable#dispose()
	 */
	@Override
	public final void dispose()
	{
	}
}

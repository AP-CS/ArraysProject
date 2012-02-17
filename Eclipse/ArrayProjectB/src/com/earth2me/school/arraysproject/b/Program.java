package com.earth2me.school.arraysproject.b;

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
	private final static int[] INPUT = { 1, 2, 3, 1, 2, 3, 4, 5, 6, 7 };

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
		// Make a local alias for our global constant in case we want to use
		// something more dynamic in the future.
		final int[] set = INPUT;

		// Calculate the mode.
		final int[] mode = getMode(set);
		
		// Report the mode.
		Console.writeLine("Set: " + toString(set));
		Console.writeLine("Mode: " + toString(mode));
	}
	
	/**
	 * Converts a set to its string representation.
	 * @param set The set to convert.
	 * @return The string representation of the set.
	 */
	private static String toString(final int[] set)
	{
		StringBuilder builder = new StringBuilder("{");
		for (int i = 0; i < set.length; i++)
		{
			builder.append(' ').append(set[i]);
		}
		return builder.append(" }").toString();
	}

	/**
	 * Calculate the mode for a set of integers.
	 * 
	 * @param set
	 *            The set of integers to analyze.
	 * @return The mode of the set. This could be multiple numbers. For example,
	 *         if each number only appears once, the mode will be the entire set
	 *         of numbers.
	 */
	private static int[] getMode(final int[] set)
	{
		// Stores how many times each number number appears, by index.
		// Parallel to set.
		int[] count = new int[set.length];
		
		// Count the occurrences of each number.
		for (int i = 0; i < count.length; i++)
		{
			// Skip cases where we have already counted a number.
			if (count[i] < 0)
			{
				continue;
			}
			
			// We already have one occurrence: the current number.
			count[i] = 1;
			
			// Count the number of times the number appears in the set.
			// Start at the next number in the set.
			for (int c = i + 1; c < set.length; c++)
			{
				if (set[c] == set[i])
				{
					// We found a match.
					count[i]++;
					
					// Mark it as non-countable in the future so we don't count it
					// the same number multiple times.
					count[c] = -1;
				}
			}
		}
		
		// Find the highest occurrence count, and determine the size of the mode
		// set.
		int max = 0;
		int modeCount = 0;
		for (int i = 0; i < count.length; i++)
		{
			if (count[i] > max)
			{
				max = count[i];
				modeCount = 1;
			}
			else if (count[i] == max)
			{
				modeCount++;
			}
		}
		
		// If max == 1, just return the current set, since all the numbers appear
		// only once. (Shortcut--this would happen anyway.)
		if (max == 1)
		{
			return set;
		}
		
		// Fill the mode set.
		int[] modeSet = new int[modeCount];
		for (int i = 0, m = 0; i < count.length; i++)
		{
			if (count[i] == max)
			{
				// We found an element in the mode set.
				modeSet[m] = set[i];
				m++;
			}
		}
		
		// Return the mode set.
		return modeSet;
	}

	/**
	 * @see com.earth2me.school.arraysproject.IDisposable#dispose()
	 */
	@Override
	public final void dispose()
	{
	}
}

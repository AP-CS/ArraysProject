package com.earth2me.school.arraysproject.c;

import java.util.ArrayList;
import java.util.Random;

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
	/**
	 * @see com.earth2me.school.arraysproject.IInitializable#initialize()
	 */
	@Override
	public final void initialize()
	{
		// Preset number of columns/rows.
		final int rows = 5; // Must be less than 10.
		final int columns = 4; // Must be less than 10.

		// Initialize arrays to hold totals and our matrix of randoms numbers.
		final int[] totalsX = new int[columns];
		final int[] totalsY = new int[rows];
		final int[][] matrix = new int[rows][columns]; // Note it's [y][x]!

		// Generate the data and calculate sums.
		generate(matrix, totalsX, totalsY);

		// Generate the row format, the column total format, and the divider.
		String rowFormat;
		String divider;
		String columnTotalFormat;
		{
			StringBuilder rowFormatBuilder = new StringBuilder();
			StringBuilder dividerBuilder = new StringBuilder();
			StringBuilder columnTotalFormatBuilder = new StringBuilder();
			for (int x = 0; x < columns; x++)
			{
				rowFormatBuilder.append("%02d ");
				dividerBuilder.append("---");
				columnTotalFormatBuilder.append("%02d ");
			}
			rowFormat = rowFormatBuilder.append("| %02d").toString();
			divider = dividerBuilder.append("+---").toString();
			columnTotalFormat = columnTotalFormatBuilder.append('|').toString();
		}

		// Create our argument matrix to pass to the row output format.
		final Integer[][] rowArgs = new Integer[rows][columns + 1];
		for (int y = 0; y < rows; y++)
		{
			for (int x = 0; x < columns; x++)
			{
				rowArgs[y][x] = matrix[y][x];
			}

			// The last argument is the total.
			rowArgs[y][columns] = totalsX[y];
		}

		// Create our argument array to pass to the column total format.
		// Essentially, convert from a primitive array to an object array.
		final Integer[] columnTotalArgs = new Integer[columns];
		for (int x = 0; x < columns; x++)
		{
			columnTotalArgs[x] = totalsY[x];
		}

		// Output time!
		{
			// Output rows.
			for (int y = 0; y < rows; y++)
			{
				// Be sure to cast to Object[] to get the correct result.
				Console.writeLine(rowFormat, (Object[])rowArgs[y]);
			}

			// Output divider.
			Console.writeLine(divider);

			// Output column totals.
			// Again, be sure to cast to Object[].
			Console.writeLine(columnTotalFormat, (Object[])columnTotalArgs);
		}
	}

	/**
	 * Generate a matrix of random integers from 1 to 10 inclusive and total its
	 * rows/columns.
	 * 
	 * @param matrix
	 *            The matrix of random integers to be filled.
	 * @param totalsX
	 *            To be filled with the total of each row.
	 * @param totalsY
	 *            To be filled with the total of each column.
	 */
	private static void generate(final int[][] matrix, final int[] totalsX, final int[] totalsY)
	{
		final int rows = totalsY.length;
		final int columns = totalsX.length;

		final Random random = new Random();

		// Iterate through the matrix.
		for (int y = 0; y < rows; y++)
		{
			for (int x = 0; x < columns; x++)
			{
				// Calculate a random value.
				final int value = random.nextInt(9) + 1;

				// Add it to the matrix at the current coordinates.
				matrix[y][x] = value;

				// Add to our totals. Note that x and y are swapped!
				totalsX[y] += value;
				totalsY[x] += value;
			}
		}
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public final void run()
	{
	}

	/**
	 * @see com.earth2me.school.arraysproject.IDisposable#dispose()
	 */
	@Override
	public final void dispose()
	{
	}
}

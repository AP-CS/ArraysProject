package com.earth2me.school.arraysproject;

/**
 * Lightly wraps stdin, stdout, and stderr.
 * 
 * @author Paul Buonopane
 * @category APCS
 * @school Medfield High School
 * @version 1.0.0
 */
public final class Console
{
	/**
	 * Prevents type from being instantiated. Do not use. Do not remove.
	 * 
	 * @deprecated
	 */
	private Console()
	{
		// Intentionally blank.
	}

	/**
	 * Writes a line to stdout.
	 * 
	 * @param text
	 *            The text to write.
	 */
	public static void writeLine(final String text)
	{
		System.out.println(text);
	}

	/**
	 * Writes a formatted line to stdout.
	 * 
	 * @param format
	 *            The format to use.
	 * @param args
	 *            The arguments to pass to the format.
	 */
	public static void writeLine(final String format, final Object... args)
	{
		System.out.println(String.format(format, args));
	}

	/**
	 * Writes a line to stderr.
	 * 
	 * @param text
	 *            The text to write.
	 */
	public static void writeError(final String text)
	{
		System.out.println(text);
	}

	/**
	 * Writes a formatted line to stderr.
	 * 
	 * @param format
	 *            The format to use.
	 * @param args
	 *            The arguments to pass to the format.
	 */
	public static void writeError(final String format, final Object... args)
	{
		System.out.println(String.format(format, args));
	}
}

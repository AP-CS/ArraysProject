package com.earth2me.school.arraysproject.b;

import com.earth2me.school.arraysproject.Application;

/**
 * Contains the main entry point for the application
 * 
 * @author Paul Buonopane
 * @category APCS
 * @school Medfield High School
 * @version 1.0.0
 */
public final class Main
{
	/**
	 * Prevents static class from being instantiated. Do not use. Do not remove.
	 * 
	 * @deprecated
	 */
	private Main()
	{
		// Intentionally blank.
	}

	/**
	 * Main entry point.
	 * 
	 * @param args
	 *            Command-line arguments.
	 */
	public static void main(String[] args)
	{
		Application.run(new Program());
	}
}
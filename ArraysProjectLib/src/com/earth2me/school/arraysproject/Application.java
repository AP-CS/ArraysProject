package com.earth2me.school.arraysproject;

/**
 * Executes programs as primary applications.  Cannot be instantiated.
 * @author Paul Buonopane
 * @category APCS
 * @school Medfield High School
 * @version 1.0.0
 */
public final class Application
{
	/**
	 * Prevents type from being instantiated. Do not use. Do not remove.
	 * 
	 * @deprecated
	 */
	private Application()
	{
		// Intentionally blank.
	}
	
	public static void run(IProgram program)
	{
		try
		{
			program.initialize();
			program.run();
		}
		catch (Throwable ex)
		{
			Console.writeError("Program encountered an error:");
			ex.printStackTrace();
		}
		finally
		{
			program.dispose();
		}
	}
}

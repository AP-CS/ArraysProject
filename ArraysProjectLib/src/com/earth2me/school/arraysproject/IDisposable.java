package com.earth2me.school.arraysproject;

/**
 * Must explicitly free resources.
 * 
 * @author Paul Buonopane
 * @category APCS
 * @school Medfield High School
 * @version 1.0.0
 */
public interface IDisposable
{
	/**
	 * Explicitly free resources held by the object. Leaves the object in an
	 * unusable state.
	 */
	void dispose();
}

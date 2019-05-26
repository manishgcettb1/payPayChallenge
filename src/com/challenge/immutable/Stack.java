/**
 * 
 */
package com.challenge.immutable;

/**
 * @author manishkumar
 * @param <T> generic type 
 */
public interface Stack<T> {
	
	/**
	 * @param t generic type  to push the stack
	 * @return new Stack<T> 
	 */
	
	public Stack<T> push(T t);
	
	/**
	 * 
	 * @return the stack after pop operation from stack 
	 */
	public Stack<T> pop() throws Exception;
	
	 /** 
     * @return the start node (end) element of the stack
     * @throws it will throw  Exception when stack is empty
     */
	
	public T head() throws Exception;
	/**
	 * 
	 * @return boolean if stack is empty
	 */
	public boolean isEmpty();

}

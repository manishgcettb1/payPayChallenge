/**
 * 
 */
package com.challenge.immutable;

/**
 * @author manishkumar
 * @param <T> create generic type of queue
 */
public interface Queue<T> {
	/**
	 * 
	 * @param t of generic type
	 * @return Queue of generic type T after insertion of t of Type T
	 */
	public Queue<T> enQueue(T t);
	
	
	/**
	 * 
	 * @return Queue<T> after removing element from queue
	 * @throws Exception if try to remove when queue is empty
	 */
	public Queue<T> deQueue() throws Exception;
	
	/**
	 * 
	 * @return T first/root element of queue
	 * @throws Exception if not available
	 */
	public T head() throws Exception;
	
	/**
	 * 
	 * @return boolean if queue is empty
	 */
	public boolean isEmpty();

}

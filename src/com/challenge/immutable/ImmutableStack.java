package com.challenge.immutable;

/**
 * @author manishkumar
 *
 * @param <T>
 */
public final class ImmutableStack<T> implements Stack<T> {
	private final T head;
	private final Stack<T> tail;
	
	private ImmutableStack(T head, Stack<T> tail){
		this.head = head;
		this.tail = tail;
	}
	
	public final Stack<T> push(T t){		
		return new ImmutableStack<T>(t, this);
	}
	
	public final Stack<T> pop(){
		return tail;
	}
	
	public final T head(){
		return head;
	}
	
	public final boolean isEmpty(){
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public final static Stack getEmptyStack(){
		return EmptyStack.getInstance();
	}
	
	
	private static final class EmptyStack<T> implements Stack<T>{
		
		@SuppressWarnings("rawtypes")
		private final static EmptyStack emptyStack = new EmptyStack();
		
		@SuppressWarnings("rawtypes")
		public final static EmptyStack getInstance(){
			return emptyStack;
		}
		
		public final Stack<T> push(T t){			
			return new ImmutableStack<T>(t, this);
		}
		
		public final Stack<T> pop() throws Exception{
			throw new Exception("size of Stack is zero.");
		}
		
		public final T head() throws Exception{
			throw new Exception("size of Stack is zero.");
		}
		
		public final boolean isEmpty(){
			return true;
		}
	}

}

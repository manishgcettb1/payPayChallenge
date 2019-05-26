package com.challenge.immutable;

public final class ImmutableQueue<T> implements Queue<T> {

	
	private final Stack<T> backwardStack;
    private final Stack<T> forwardStack;
    
    private ImmutableQueue(Stack<T> forwardStack, Stack<T> backwardStack)
    {
        this.forwardStack = forwardStack;
        this.backwardStack = backwardStack;
    }
    /**
     * 
     * @param stack
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Stack reverseStack(Stack stack) throws Exception
    {
        Stack s = ImmutableStack.getEmptyStack();
        while(!stack.isEmpty()){
        	s = s.push(stack.head());   
        	stack = stack.pop();
        }
      
        return s;
    }
    
    
    @SuppressWarnings("rawtypes")
	public final static Queue getEmptyQueue(){
		return EmptyQueue.getInstance();
	}
    
    
	@Override
	public Queue<T> enQueue(T t) {
		// TODO Auto-generated method stub
		return new ImmutableQueue<T>(forwardStack, backwardStack.push(t));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Queue<T> deQueue() throws Exception {
		Stack<T> f = forwardStack.pop();
        if (!f.isEmpty()){
            return new ImmutableQueue<T>(f, backwardStack);
        }
        else if (backwardStack.isEmpty()){
            return ImmutableQueue.getEmptyQueue();
        }
        else {
            return new ImmutableQueue<T>(ImmutableQueue.reverseStack(backwardStack), ImmutableStack.getEmptyStack());
        }
	}

	@Override
	public T head() throws Exception {
		// TODO Auto-generated method stub
		return forwardStack.head();

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * creating a singleton class to get empty queue
	 * @author manishkumar
	 *
	 * @param <T>
	 */
	private static final class EmptyQueue<T> implements Queue<T>{
		
		
		@SuppressWarnings("rawtypes")
		private final static EmptyQueue emptyQueue = new EmptyQueue();
		
		@SuppressWarnings("rawtypes")
		public final static EmptyQueue getInstance(){
			return emptyQueue;
		}
		
		@SuppressWarnings("unchecked")
		public final Queue<T> enQueue(T t){
			return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(t), ImmutableStack.getEmptyStack());
		}
		
		public final Queue<T> deQueue() throws Exception{
			throw new Exception("Queue is empty.");
		}
		
		public final T head() throws Exception{
			throw new Exception("Queue is empty.");
		}
		
		public final boolean isEmpty(){
			return true;
		}
	}

}



package org.swarnim;

public class ImmutableQueue<T> implements Queue<T> {
    private final Stack<T> dequeueStack;
    private final Stack<T> enqueueStack;

    public ImmutableQueue(Stack<T> dequeueStack, Stack<T> enqueueStack) {
        this.dequeueStack = dequeueStack;
        this.enqueueStack = enqueueStack;
    }

    public static Queue getEmptyQueue() {
        return EmptyQueue.getInstance();
    }

    @Override
    public Queue<T> enQueue(T t) {
        return new ImmutableQueue<T>(this.dequeueStack, this.enqueueStack.push(t));
    }

    @Override
    public Queue<T> deQueue() {
        Stack<T> newDequeueStack = this.dequeueStack.pop();
        if (!newDequeueStack.isEmpty())
            return new ImmutableQueue<T>(newDequeueStack, this.enqueueStack);
        else if (this.enqueueStack.isEmpty())
            return ImmutableQueue.getEmptyQueue();
        else
            return new ImmutableQueue<T>(StackUtils.reverseStack(this.enqueueStack), ImmutableStack.getEmptyStack());
    }

    @Override
    public T head() {
        return dequeueStack.head();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private static class EmptyQueue<T> implements Queue<T> {
        private final static EmptyQueue emptyQueue = new EmptyQueue();

        public static EmptyQueue getInstance() {
            return emptyQueue;
        }

        @Override
        public Queue<T> enQueue(T t) {
            return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(t), ImmutableStack.getEmptyStack());
        }

        @Override
        public Queue<T> deQueue() {
            throw new RuntimeException("Queue is empty");
        }

        @Override
        public T head() {
            throw new RuntimeException("Queue is empty");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }
}

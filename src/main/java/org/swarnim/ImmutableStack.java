package org.swarnim;

public class ImmutableStack<T> implements Stack<T> {
    private final T head;
    private final Stack<T> tail;

    public ImmutableStack(T head, Stack<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public static Stack getEmptyStack() {
        return EmptyStack.getInstance();
    }

    @Override
    public Stack<T> push(T t) {
        return new ImmutableStack<T>(t, this);
    }

    @Override
    public Stack<T> pop() {
        return this.tail;
    }

    @Override
    public T head() {
        return this.head;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private static class EmptyStack<T> implements Stack<T> {
        private final static EmptyStack emptyStack = new EmptyStack();

        public static EmptyStack getInstance() {
            return emptyStack;
        }

        @Override
        public Stack<T> push(T t) {
            return new ImmutableStack<>(t, this);
        }

        @Override
        public Stack<T> pop() {
            throw new RuntimeException("Stack is empty");
        }

        @Override
        public T head() {
            throw new RuntimeException("Stack is empty");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }
}

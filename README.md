# ImmutableQueue

In object-oriented and functional programming, an immutable object is an object whose state cannot be modified after it is created. This is in contrast to a mutable object which can be modified after it is created.

Classes should be immutable unless there's a very good reason to make them mutable. If a class cannot be made immutable, limit its mutability as much as possible. The JDK contains many immutable classes, including String, the boxed primitive classes, and BigInteger and etc. Basically the immutable classes are less prone to error.

The project implements an immutable queue with the following api:

public interface Queue[T] {

    public Queue<T> enQueue(T t);
    #Removes the element at the beginning of the immutable queue, and returns the new queue.
    public Queue<T> deQueue();
    public T head();
    public boolean isEmpty();
}

The implementation uses 2 immutable stacks for dequeue and enqueue operations. The dequeuStack is however used to enqueue the very first element of the queue so that dequeue operation always happens from the dequeueStack.

Time complexity-  
enQueue- O(1)  
deQueue- O(n) in worst case else O(1)  
head- O(1)  
isEmpty- O(1)  

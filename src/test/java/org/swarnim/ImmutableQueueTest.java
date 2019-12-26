package org.swarnim;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ImmutableQueueTest {
    private static Queue q0;

    @BeforeClass
    public static void setUp() {
        q0 = ImmutableQueue.getEmptyQueue();
        q0 = q0.enQueue(1);
        q0 = q0.enQueue(2);
        q0 = q0.enQueue(3);
    }

    @Test
    public void testQueueBehaviour() {
        Queue q1 = ImmutableQueue.getEmptyQueue();
        q1 = q1.enQueue("a");
        q1 = q1.enQueue("b");
        q1 = q1.enQueue("c");
        Assert.assertEquals("a", q1.head());
        q1 = q1.deQueue();
        Assert.assertEquals("b", q1.head());
        q1 = q1.deQueue();
        Assert.assertEquals("c", q1.head());
        q1 = q1.deQueue();
        Assert.assertEquals(q1, ImmutableQueue.getEmptyQueue());
    }

    @Test
    public void testEnqueueImmutability() {
        Queue q1 = q0.enQueue(4);
        //Object's equals() method gets called which compares memory reference that must differ before and after enqueue
        Assert.assertNotEquals(q0, q1);
    }

    @Test
    public void testDequeueImmutability() {
        Queue q2 = q0.deQueue();
        //Object's equals() method gets called which compares memory reference that must differ before and after dequeue
        Assert.assertNotEquals(q0, q2);
    }
}
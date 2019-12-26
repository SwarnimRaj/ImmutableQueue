package org.swarnim;

public class StackUtils {
    public static Stack reverseStack(Stack stack) {
        Stack reversed = ImmutableStack.getEmptyStack();
        while (!stack.isEmpty()) {
            reversed = reversed.push(stack.head());
            stack = stack.pop();
        }
        return reversed;
    }
}

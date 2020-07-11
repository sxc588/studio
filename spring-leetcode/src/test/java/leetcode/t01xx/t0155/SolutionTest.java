package leetcode.t01xx.t0155;

import org.junit.Test;



//155. Min Stack
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.
// 
//
//Example 1:
//
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
public class SolutionTest {

	@Test
	public void test() {

		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		int parm1 = minStack.getMin(); // return -3
		minStack.pop();
		int parm2 = minStack.top(); // return 0
		int parm3 = minStack.getMin(); // return -2

		System.out.println(parm1);
		System.out.println(parm2);
		System.out.println(parm3);
	}
}

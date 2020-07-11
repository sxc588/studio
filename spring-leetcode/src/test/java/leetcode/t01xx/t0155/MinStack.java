package leetcode.t01xx.t0155;

class MinStack {

	int stack[] = new int[99999];
	int mval[] = new int[99999];
	int top = -1;

	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int x) {

		top++;
		stack[top] = x;

		if (top == 0 || x < mval[top - 1])
			mval[top] = x;
		else {
			mval[top] = mval[top - 1];
		}

	}

	public void pop() {
		top--;
	}

	public int top() {
		return stack[top];

	}

	public int getMin() {
		return mval[top];
	}
}
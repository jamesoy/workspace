package my.interview.questions;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericStack<E> implements Iterable<E> {

	private int N;
	private E[] array;

	@SuppressWarnings("unchecked")
	public GenericStack(int capacity) {
		array = (E[]) new Object[capacity];
	}

	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<E> {

		private int i = N - 1;

		@Override
		public boolean hasNext() {
			return i >= 0;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return array[i--];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public void push(E item) {
		if (isFull()) {
			throw new RuntimeException("Stack overflow");
		}
		array[N++] = item;
	}

	public E pop() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		E item = array[--N];
		array[N] = null;	// otherwise cause memory leak here
		return item;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public boolean isFull() {
		return N == array.length;
	}

	public E peek() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		return array[N - 1];
	}

	public static void main(String[] args) {
		GenericStack<Integer> s = new GenericStack<>(10000);
		for (int i = 0; i < 10000; i++) {
			s.push(i);
		}

		while (!s.isEmpty()) {
			s.pop();
		}

		while (true) {
		}
	}
}

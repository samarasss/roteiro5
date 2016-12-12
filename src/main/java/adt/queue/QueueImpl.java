package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;
	public int size;
	public int head;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
		this.size = size;
		this.head = -1;
		
	}

	@Override
	public T head() throws QueueUnderflowException {
		if(this.isEmpty()){
			throw new QueueUnderflowException();
		}
		return this.array[head];
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return this.array.length== -1;
	}

	private void shiftLeft() {
		for (int i = 0; i < array.length -1; i++) {
			array[i] = array[i +1];
			
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		if(isEmpty()){
			this.head = 0;
			this.tail = 0;
			this.array[0] = element;
		}
		else{
			tail += 1;
			this.array[tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		T value = array[head];
		if(this.head == this.tail){
			this.head = -1;
			this.tail = -1;
		}
		else{
			this.head = (this.head + 1) % size;
		}
		return value;
	}

}

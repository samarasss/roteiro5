package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;
	private int size;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
		this.size = size;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		this.elements += 1;
		if(isEmpty()){
			this.head = 0;
			this.tail = 0;
			this.array[0] = element;
		}
		else{
			tail = (tail + 1) % size;
			this.array[tail] = element;
			
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		this.elements -=1;
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

	@Override
	public T head() throws QueueUnderflowException {
		if(this.isEmpty()){
			throw new QueueUnderflowException();
		}
		return this.array[head];
	}

	@Override
	public boolean isEmpty() {
		return (this.head == -1 && this.tail == -1);
	}

	@Override
	public boolean isFull() {
		return (this.array.length == this.elements);
	}

}

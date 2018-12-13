public class MyLinkedList {
    private int size;
    private Node start, end;
    public MyLinkedList(Node first, Node last) {
	start = first;
	end = last;
	size = 2;
    }
    public int size() {
	return size;
    }
    public boolean add(int value) {
	//creating a new end
       	Node temp = new Node(value, end, null);
	//creating a link between the old end and new end
	end.setNext(temp);
	//replacing the old end 
       	end = temp;
	size++;
	return true;
    }
    public String toString() {
	String output = "";
	Node current = start;
	for(int i = 0; i < size; i++) {
	    if (i == size - 1) {
		output += current.get();
	    }
	    else {
		output += current.get() + ",";
		current = current.getNext();
	    }
	}
	return output;
    }
    public static void main(String[]args) {
	Node a, b;
	a = new Node(0);
	b = new Node(1);
	a.setNext(b);
	b.setPrev(a);
        MyLinkedList c = new MyLinkedList(a, b);
	//	System.out.println(c);
	c.add(2);
	//	System.out.println(c);
    }
}

class Node {
    private int data;
    private Node next, prev;
    public Node(int input, Node before, Node after) {
    	data = input;
    	prev = before;
    	next = after;
    }
    public Node(int input) {
	data = input;
    }
    public Node(Node input) {
	data = input.get();
	next = input.getNext();
	prev = input.getPrev();
    }
    public int get() {
	return data;
    }
    public Node getNext() {
	return next;
    }
    public Node getPrev() {
	return prev;
    }
    public void setNext(Node after) {
	next = new Node(after);
    }
    public void setPrev(Node before) {
	prev = new Node(before);
    }
}

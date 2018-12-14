public class MyLinkedList {
    private int size;
    private Node start, end;
    public MyLinkedList(Node first, Node last) {
	start = first;
	end = last;
	size = 2;
    }
    public MyLinkedList() {
	size = 0;
    }
    public MyLinkedList(Node value) {
	start = value;
    }
    public int size() {
	return size;
    }
    public boolean add(int value) {
	if (size == 0) {
	    start = new Node(value);
	}
	if (size == 1) {
	    end = new Node(value, start, null);
	    start.setNext(end);
	}
	if (size == 2) {
	    Node temp = new Node(value, end, null);
	    end.setNext(temp);
	    start.setNext(end);
	    end = temp;
	}
	else {
	    Node temp = new Node(value, end, null);
	    end.setNext(temp);
	    end = temp;
	}
	size++;
	return true;
    }
    public String toString() {
	String output = "";
	Node current = start;
	while (current != null) {
	    if (current.getNext() == null) {
	    	output += current.getData();
	    }
	    else {
	    	output += current.getData() + ",";
	    }
     	    current = current.getNext();
	    System.out.println(current);
	    System.out.println(current.getNext());
	}
	return output;
    }
    private Node getNthNode(int index) {
	//exception: index out of bounds
	Node current = start; 
	for(int i = 0; i <= index; i++) {
	    current = current.getNext();
	}
	return current;
    }
    public static void main(String[]args) {
	Node a, b;
	a = new Node(0);
	b = new Node(1);
	a.setNext(b);
	b.setPrev(a);
        MyLinkedList c = new MyLinkedList(a, b);
	//System.out.println(c);
	c.add(2);
	c.add(3);
	c.add(4);
	c.add(5);
	System.out.println(c);
    }
}

class Node {
    private Integer data;
    private Node next, prev;
    public Node(Integer input, Node before, Node after) {
    	data = input;
    	prev = before;
    	next = after;
    }
    public Node(Integer input) {
	data = input;
    }
    public Node(Node input) {
	data = input.getData();
	next = input.getNext();
	prev = input.getPrev();
    }
    public Integer getData() {
	return data;
    }
    public Node getNext() {
	return next;
    }
    public Node getPrev() {
	return prev;
    }
    public Integer setData(Integer value) {
	int temp = data;
	data = value;
        return temp;
    }
    public void setNext(Node after) {
	next = new Node(after);
    }
    public void setPrev(Node before) {
	prev = new Node(before);
    }
    public String toString() {
	return data + "";
    }
}

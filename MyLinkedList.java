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
	//adding to the start
	if (size == 0) {
	    start = new Node(value);
	}
	//initializing end if there is only one value
	else if (size == 1) {
	    end = new Node(value, start, null);
	    start.setNext(end);
	}
	else {
	    //creating a new end
	    Node temp = new Node(value, end, null);
	    //creating a link between the old end and new end
	    end.setNext(temp);
	    //setting the end to the new end
	    end = temp;
	}
	size++;
	return true;
    }
    public String toString() {
	String output = "";
	Node current = start;
	int i = 0;
	while (current != null) {
	    if (current.getNext() == null) {
	    	output += current.getData();
	    }
	    else {
	    	output += current.getData() + ",";
	    }
	    current = current.getNext();
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
    public Integer get(int index) {
	return getNthNode(index).getData();
    }
    public Integer set(int index, Integer value) {
	//exception: index out of bounds
	Node change = getNthNode(index);
	Integer old = change.getData();
	change.setData(value);
	return old;
    }
    public boolean contains(Integer value) {
	Node current = start;
	while(current != null) {
	    if (current.getData().equals(value)) {
		return true;
	    }
	    current = current.next();
	}
	return false;
    }
    public int indexOf(Intger value) {
	//exception : index out of bounds
	Node current = start;
	for(int i = 0; i < size; i++) {
	    if (current.getData().equals(value)) {
		    return i;
	    }
	    current = current.next();
	}
	return -1;
    }
    public void add (int index, Integer value) {
	if (index == 0) {
	    Node temp = new Node(value, null, start);
	    start.setPrev(temp);
	    start = temp;
	}
	if (index == size - 1) {
	    add(value);
	}
	else {
	    Node after = getNthNode(index);
	    Node before = after.getPrev();
	    Node wedge = new Node(value, before, after);
	    after.setPrev(wedge);
	    before.setNext(wedge);
	}
    }
    public Integer remove(int index) {
	//exception
	Node current = getNthNode(index);
	if (index == 0) {
	    start = start.getNext();
	}
	if (index == size - 1) {
	    end = end.getPrev();
	}
	else {
	    Node after = current.getNext();
	    Node before = current.getPrev();
	    after.setPrev(before);
	    before.setNext(after);
	}
	return current.getData();
    }
    public boolean remove(Integer value) {
	//exception
	int i = indexOf(value);
	if (i >= -1) {
	    remove(i, value);
	}
    }
	    
    public static void main(String[]args) {
	Node a, b;
        MyLinkedList c = new MyLinkedList();
	//System.out.println(c);
	c.add(0);
	c.add(1);
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
	next = after;
    }
    public void setPrev(Node before) {
	prev = before;
    }
    public String toString() {
	return data + "";
    }
}

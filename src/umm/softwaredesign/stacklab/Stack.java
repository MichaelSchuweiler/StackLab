//Michael Schuweiler
//Henry Fellows

package umm.softwaredesign.stacklab;

import java.util.List;

import umm.softwaredesign.stacklab.StackIF;

/**
 * Implementation of the StackIF interface for a basic stack.
 * 
 * @author Nic McPhee, last changed by $Author: prodgera $ on $Date: 2006/01/25
 *         19:26:03 $
 * @version $Revision: 1.16 $
 */
public class Stack<T> implements StackIF<T> {
	/**
	 * Construct an empty stack.
	 */

	//Variables
	private Node head;

	//Constructors
	public Stack(List<T> items) {
		for(int i = 0; i < items.size(); i++){
			this.push(items.get(i));
		}
	}
	public Stack(T items) {
		this.push(items);	
	}

	public Stack()
	{

	}

	//Push - pushes an item to the TOP of the stack
	public void push(T item)
	{
		Node newNode = new Node(item);
		newNode.next = head;
		head = newNode;
	}

	//Pop - removes an item from the TOP of the stack.
	public T pop()
	{
		if (null != head) {
			Node top = head;
			head = top.next;
			return (T) top.data;
		} else {
			throw new StackUnderflowException();
		}
	}

	//Top - returns the item at the top of the stack without removing it.
	public T top()
	{
		if (null == head) {
			throw new StackUnderflowException();
		}
		return (T) head.data;
	}

	//Reverse - reverses the order of the stack.
	public void reverse()
	{
		Stack<T> temp = new Stack<T>();
		while (head != null) {
			temp.push(this.pop());
		}
		head = temp.head;
	}
	
	//Returns the size of the stack.
	public int size()
	{
		if (null == head) {
			return 0;
		}
		Node current = head;
		int i = 1;
		while (null != current.next) {
			i++;
			current = current.next;
		}
		return i;
	}

	
	public boolean isEmpty()
	{
		return (null == head);
	}

	//hasElements checks to see if the stack is the same as the list.
	//note, the list is given in reverse order relative to the stack.
	public boolean hasElements(List<T> list)
	{	
		if (this.size() != list.size()){
			System.out.print("NO");
			return false;
		}

		//ugly matching code
		reverse();
		Node<T> current = head;
		for (int i = 0; i < this.size(); i++)
		{    		
			System.out.print(current.data.toString());
			if (current.data.equals((list.get(i)))){
				current = current.next;
			}else{
				reverse();
				return false;
			}
		}
		reverse();
		return true;
	}
	
	//toString returns a string in the form "stack[item1.toString, item2.toString, itemN.toString]
	public String toString()
	{ 
		Node temp = head;
		String aString = "";
		while (null != temp) {
			aString = (temp.data + aString);
			if (null != temp.next){
				aString = ", " + aString;
			}
			temp = temp.next;
		}

		return "Stack[" + aString + "]";
	}

	
	//the Node class, which has a T, data, and another node, next.
	//next points to the next node in the list.
	private class Node<T> {

		T data;
		Node next;

		Node()
		{
		}

		Node(T item)
		{
			data = item;
		}
	}
}






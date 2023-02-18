package com.js.singlelinkedlist;

public class SinglyLinkedListDriverClass {

	// To insert on the head/ from start.....................................Time
	// complexity=O(1)
	public static Node insertionStart(Node head, int data) {

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		return head;
	}

	// To insert at last.....................................................Time
	// complexity=O(n)
	public static Node insertionLast(Node head, int data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return head;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return head;
	}

	// To insert at a
	// position...................................................Time complexity
	// =O(n)
	public static Node insertAtPosition(Node head, int data, int pos) {
		int size = calcSize(head);
		if (pos == 0)
			return insertionStart(head, data);
		if (pos < 1 || pos > size) {
			System.out.println("Cannot insert," + pos + " is not a valid position");
		} else {
			Node newNode = new Node(data);
			Node temp = head;
			while (--pos > 0) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
		return head;

	}

	public static int calcSize(Node node) {
		int size = 0;
		while (node != null) {
			node = node.next;
			size++;
		}
		return size;
	}

	public static void display(Node node) {

		while (node != null) {
			System.out.print(node.data + "---->");
			node = node.next;
		}
		System.out.println("null");

	}

	public static void main(String[] args) {
		Node head = null;

		/*
		 * head = insertionStart(head, 10); head = insertionStart(head, 20); head =
		 * insertionStart(head, 30); display(head);
		 */
		/*
		 * head = insertionLast(head, 10); head = insertionLast(head, 20);
		 * display(head);
		 */
		head = insertAtPosition(head, 10, 0);
		display(head);
		head = insertAtPosition(head, 20, 1);
		display(head);
		head = insertAtPosition(head, 15, 1);
		display(head);

	}

}

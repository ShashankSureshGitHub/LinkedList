package com.js.doublylinkedlist;

public class DoublyLinkedListInsertion {
// Time complexity is O(1)
	public static Node insertAtStart(Node head, int data) {

		Node newNode = new Node(data);
		newNode.next = head;
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		return newNode;
	}

// Time complexity is O(n)
	public static Node insertAtEnd(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return head;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		newNode.prev = temp;
		temp.next = newNode;
		return head;

	}

	public static Node display(Node head) {
		if (head == null) {
			System.out.println("Empty linked list");
			return head;
		}
		Node temp = head;
		Node end = null;
		System.out.println("Displaying in the forward direction/ from Head");
		while (temp != null) {
			System.out.print(temp.data + "---->");
			end = temp;
			temp = temp.next;
		}
		System.out.println("null");

		System.out.println("Displaying in the backward direction/ from tail");
		while (end != null) {
			System.out.print(end.data + "---->");
			end = end.prev;
		}
		System.out.println("null");
		return head;
	}

	public static void main(String[] args) {

		Node head = null;
		head = insertAtEnd(head, 10);
		head = insertAtStart(head, 5);
		head = insertAtEnd(head, 20);
		head = display(head);

	}

}

package com.js.circularlinkedlist;

public class InsertAtEndOptimisedApproach {

	public static Node insertAtEnd(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			newNode.next = newNode;
			head = newNode;
			return head;
		}

		newNode.next = head.next;
		head.next = newNode;

		int temp = head.data;
		head.data = newNode.data;
		newNode.data = temp;

		head = newNode;
		return head;

	}

	public static Node display(Node head) {
		if (head == null) {
			System.out.println("Empty Linked List");
			return head;
		}
		Node temp = head;
		while (temp.next != head) {
			System.out.print(temp.data + "--->");
			temp = temp.next;
		}
		System.out.println(temp.data + "---->" + head.data);
		return head;
	}

	public static void main(String[] args) {
		Node head = null;
		head = insertAtEnd(head, 10);
		head = display(head);
		head = insertAtEnd(head, 20);
		head = display(head);
		head = insertAtEnd(head, 30);
		head = display(head);
	}

}

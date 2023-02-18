package com.js.circularlinkedlist;

// Time Complexity is O(n)
public class InsertAtEndNaiveApproach {

	public static Node insertAtEnd(Node head, int data) {

		Node newNode = new Node(data);
		if (head == null) {
			newNode.next = newNode;
			head = newNode;
			return head;
		}
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.next = head;
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
	}

}

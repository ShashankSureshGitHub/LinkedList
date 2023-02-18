package com.js.circularlinkedlist;

public class InsertAtStartNaiveApproach {

	// Time Complexity is O(n) as it has to traverse the entire linked list to
	// change the link of the last node

	public static Node insertAtStart(Node head, int data) {
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
		head = insertAtStart(head, 10);
		head = display(head);
		head = insertAtStart(head, 20);
		head = insertAtStart(head, 30);
		System.out.println(head.data);
		head = display(head);

	}

}

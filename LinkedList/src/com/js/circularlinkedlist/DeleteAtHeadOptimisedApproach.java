package com.js.circularlinkedlist;

public class DeleteAtHeadOptimisedApproach {

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

	public static Node deleteAtHead(Node head) {
		Node temp = head;

		if (temp == null) {
			System.out.println("Linked List is empty");
			return head;
		}
		if (temp.next == head) {
			System.out.println(temp.data + " deleted successfully");
			head = null;
			return head;
		}

		temp.data = temp.next.data;
		temp.next = temp.next.next;
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
		head = insertAtStart(head, 20);
		head = insertAtStart(head, 30);
		head = display(head);

		head = deleteAtHead(head);
		head = display(head);
		head = deleteAtHead(head);
		head = display(head);
		head = deleteAtHead(head);
		head = display(head);
		head = deleteAtHead(head);
		head = display(head);

	}

}

package com.js.circularlinkedlist;

public class DeleteByPosition {

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

	public static Node deleteByPosition(Node head, int pos) {
		Node temp = head;
		Node prevTemp = null;
		int size = calcSize(temp);
		// case 1 and case 3
		if (pos < 1 || pos > size) {
			System.out.println(pos + " is not a valid position");
			return head;
		} else if (pos == 1) {
			return deleteAtHead(head);
		} else {
			while (--pos > 0) {
				prevTemp = temp;
				temp = temp.next;
			}
			prevTemp.next = temp.next;
		}
		return head;
	}

	public static int calcSize(Node head) {
		Node temp = head;
		int size = 0;
		if (temp == null) {
			return size;
		} else {
			size = 1;
			while (temp.next != head) {
				temp = temp.next;
				size++;
			}
			return size;
		}

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
		System.out.println(head.data);
		head = deleteByPosition(head, 0); // case 2;
		head = display(head);
		head = deleteByPosition(head, 7); // case 3
		head = deleteByPosition(head, 3); // case 4
		head = display(head);
		head = deleteByPosition(head, 1);
		head = display(head);

	}

}

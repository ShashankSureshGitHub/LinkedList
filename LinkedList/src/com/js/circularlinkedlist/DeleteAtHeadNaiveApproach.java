package com.js.circularlinkedlist;

public class DeleteAtHeadNaiveApproach {

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

	public static Node deleteAtHead(Node head, int delValue) {
		Node temp = head;
		Node prevTemp = null;

		if (temp == null) {
			System.out.println("Linked List is empty");
			return head;
		} else if (temp != null && temp.data == delValue) {
			System.out.println(delValue + " deleted successfully");
			if (temp.next == head) {
				head = null;
				return head;
			}
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			head = temp.next.next;
			return head;
		} else {
			while (temp.next != head && temp.data != delValue) {
				prevTemp = temp;
				temp = temp.next;
			}
			if (temp.next == head) {
				System.out.println("Node not found");
			} else {
				System.out.println(delValue + " deleted successfully");
				prevTemp.next = temp.next;
			}
			return head;
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

		head = deleteAtHead(head, 20); // case 4
		head = display(head);
		head = deleteAtHead(head, 10); // case 4
		head = display(head);
		head = deleteAtHead(head, 30); // case 2
		head = display(head);
		head = deleteAtHead(head, 10); // case 1
		head = display(head);

	}

}

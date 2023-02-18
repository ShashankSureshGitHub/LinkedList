package com.js.singlelinkedlist;

public class SinglyLinkedListDeletion {

	// To insert on the head/ from start
	public static Node insertStart(Node head, int data) {

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		return head;
	}

	// to display the nodes in the linked list
	public static void display(Node node) {

		while (node != null) {
			System.out.print(node.data + "---->");
			node = node.next;
		}
		System.out.println("null");

	}

	public static Node deleteNode(Node head, int data) {

		Node temp = head;
		Node prev = null;

		// case 1: when the linked list is empty
		if (head == null) {
			System.out.println("Linked list is empty");
		}

		// case 2: when the node to be deleted is the current head itself
		else if (temp != null && temp.data == data) {
			System.out.println("Node " + data + " deleted successfully"); // Time complexity = O(1)...deleting from head
			head = temp.next;

		}
		// case 3 and 4: traversing the linked list to find the required node
		else {
			while (temp != null && temp.data != data) { // Time complexity otherwise O(n) .....because we need to
														// traverse the list
				prev = temp;
				temp = temp.next;
			}
			// case 3: when the node is not found after traversing the entire list
			if (temp == null) {
				System.out.println("Node " + data + " not found in the linked list");

			}
			// case 4: when the node is found
			else {
				System.out.println("Node " + data + " deleted successfully");
				prev.next = temp.next;
			}
		}
		return head;

	}

	public static Node deleteAtPosition(Node head, int pos) {
		int size = calcSize(head);

		Node temp = head;
		Node prev = null;

		if (pos < 1 || pos > size) {
			System.out.println(pos + " is not a valid position");
			return head;
		} else if (pos == 1) {
			System.out.println(temp.data + " deleted successfully at position " + pos);
			head = temp.next;
			return head;
		} else {
			while (--pos > 0) {
				prev = temp;
				temp = temp.next;
			}
			System.out.println(temp.data + " deleted successfully at position " + pos);
			prev.next = temp.next;
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

	public static void main(String[] args) {

		Node head = null;
		head = insertStart(head, 10);
		head = insertStart(head, 20);
		head = insertStart(head, 30);
		head = insertStart(head, 40);
		head = insertStart(head, 50);
		display(head);
		head = deleteNode(head, 50); // case 2
		display(head);
		head = deleteNode(head, 5); // case 3
		display(head);
		head = deleteNode(head, 20); // case 4
		display(head);
		head = deleteNode(head, 40);
		head = deleteNode(head, 30);
		head = deleteNode(head, 10);
		head = deleteNode(head, 10); // case 1

		head = insertStart(head, 10);
		head = insertStart(head, 20);
		head = insertStart(head, 30);
		display(head);
		head = deleteAtPosition(head, 0);
		head = deleteAtPosition(head, 4);
		head = deleteAtPosition(head, 1);
		display(head);
		head = insertStart(head, 30);
		head = deleteAtPosition(head, 2);
		display(head);

	}

}

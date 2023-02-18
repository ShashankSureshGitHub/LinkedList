package com.js.doublylinkedlist;

public class DoublyLinkedListDeletion {

	public static Node insertAtStart(Node head, int data) {

		Node newNode = new Node(data);
		newNode.next = head;
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		return newNode;
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

	public static Node deleteByValue(Node head, int delValue) {

		Node temp = head; // traversing node
		Node prevTemp = null; // to keep track of the previous node of traversing node
		Node nextTemp = null; // ---------''--------------next node of traversing node
		// case 1 when there is no node
		if (temp == null) {
			System.out.println("Empty linked list");

		}
		// case 2 deleted item is the first node itself
		else if (temp != null && temp.data == delValue) {
			System.out.println(delValue + " deleted successfully");
			nextTemp = temp.next;
			if (nextTemp != null) {
				nextTemp.prev = null;
			}
			head = nextTemp;

		}
		// case 3 and 4... traversing to find the item
		else {
			while (temp != null && temp.data != delValue) {
				prevTemp = temp;
				temp = temp.next;
			}
			// case 3 // item not found even after traversing the entire list
			if (temp == null) {
				System.out.println(delValue + " not found in the linked list");

			}
			// case 4: Item found
			else {
				System.out.println(delValue + " deleted successfully");
				nextTemp = temp.next;
				prevTemp.next = nextTemp;
				nextTemp.prev = prevTemp;
			}

		}
		return head;

	}

	public static Node deleteByPosition(Node head, int pos) {

		Node temp = head; // traversing node
		Node prevTemp = null; // to keep track of the previous node of traversing node
		Node nextTemp = null; // ---------''--------------next node of traversing node
		int size = calcSize(temp);
		// Case 1 and case 3 Merged
		if (pos < 1 || pos > size) {
			System.out.println("Invalid");
		}
		// case 2 when position ==1
		else if (pos == 1) {
			System.out.println("deleted successfully");
			nextTemp = temp.next;
			if (nextTemp != null) {
				nextTemp.prev = null;
			}
			head = nextTemp;
		}
		// case 4 otherwise
		else {
			while (--pos > 0) {
				prevTemp = temp;
				temp = temp.next;
			}
			System.out.println("Deleted successfully");
			nextTemp = temp.next;
			if (nextTemp != null) {
				nextTemp.prev = prevTemp;
			}
			prevTemp.next = nextTemp;
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

		head = insertAtStart(head, 10);
		head = insertAtStart(head, 20);
		head = insertAtStart(head, 30);
		head = display(head);

		head = deleteByValue(head, 20);// case 4; head = display(head); head =
		deleteByValue(head, 50); // case 3; head = display(head); head =
		deleteByValue(head, 30);
		head = display(head);
		head = deleteByValue(head, 10);
		head = display(head);
		head = deleteByValue(head, 10);
		head = display(head);
// --------------------This is for delete at kth position---------------------------
		head = insertAtStart(head, 10);
		head = insertAtStart(head, 20);
		head = insertAtStart(head, 30);
		head = display(head);
		head = deleteByPosition(head, 0);
		System.out.println(head.data);
		head = display(head);
		head = deleteByPosition(head, 2);
		head = display(head);

	}

}

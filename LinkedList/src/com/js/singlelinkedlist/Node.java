package com.js.singlelinkedlist;

public class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}

}


                      //     _________________
                      //    |          |      |
                      //    | data     | next |------>//null
                      //    |__________|______|
                      // next stores the Node type references
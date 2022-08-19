class DLLNode {
  constructor(value) {
    this.next = null;
    this.prev = null;
    this.value = value;
  }
}

class DoublyLinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
  }
  
  isEmpty() {
    return this.head === null;
  }

  // Creates a new node and
  // adds it at the front of this list.
  insertAtFront(data) {
    const newNode = new DLLNode(data);
    if (this.isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.head.prev = newNode;
      newNode.next = this.head;
      this.head = newNode;
    }
    return this;
  }

  // Creates a new node and
  // adds it at the back of this list.
  insertAtBack(data) {
    const newNode = new DLLNode(data);
    if (this.isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      newNode.prev = this.tail;
      this.tail = newNode;
    }
    return this;
  }
  
  // Adds all the given items to the back of this list.
  insertAtBackMany(items = []) {
    items.forEach((item) => this.insertAtBack(item));
    return this;
  }

  // EXTRA:

  // Removes the middle node in this list
  // and returns its value.
  removeMiddleNode() {
    if (this.isEmpty()) {
      console.log('This list is empty.');
      return null;
    }

    if (this.head.next == null) {
      const temp = this.head;
      this.head = null;
      this.tail = null;
      return temp.value;
    }

    let forwardRunner = this.head;
    let backwardRunner = this.tail;

    while (forwardRunner != backwardRunner) {
      if (forwardRunner.prev == backwardRunner) {
        return null;
      }
      forwardRunner = forwardRunner.next;
      backwardRunner = backwardRunner.prev;
    }

    const midNode = forwardRunner;
    midNode.prev.next = midNode.next;
    midNode.next.prev = midNode.prev;
    return midNode.value;
  }

  printValues() {
    let output = '< ';
    let runner = this.head;
    while (runner.next) {
      output += `${runner.value} >< `
      runner = runner.next;
    }
    output += `${runner.value} >`
    console.log(output);
    return this;
  }

}

const dll = new DoublyLinkedList();
dll.insertAtBackMany([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]).insertAtBack(11).printValues();
console.log(dll.removeMiddleNode());
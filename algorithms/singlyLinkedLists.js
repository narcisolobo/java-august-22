/*
 * A class to represent a single node of a SinglyLinkedList that can be
 * linked to other Node instances to form a list of linked nodes.
*/

class ListNode {
  constructor (data) {
    this.data = data;
    this.next = null;
  }
}

/*
 * This class keeps track of the start (head) of the list and to store all the
 * functionality (methods) that each list should have.
*/

class SinglyLinkedList {
  constructor () {
    this.head = null;
  }

  addToFront(data) {
    // add a new node to the front of the list
    const newHead = new ListNode(data);
    newHead.next = this.head;
    this.head = newHead;
    return this;
  }

  printValues() {
    // print all values in the list
    let runner = this.head;
    let output = '';
    while (runner) {
      output += `${runner.data} > `
      runner = runner.next;
    }
    console.log(output);
    return this;
  }

  isEmpty() {
    // return true if empty, false if not
    return this.head == null;
  }

  insertAtBack(data) {
    // add a new node to the back of the list
    const newBack = new ListNode(data);
    let runner = this.head;

    if (runner === null) {
      this.head = newBack
    } else {
      while (runner.next) {
        runner = runner.next;
      }
      runner.next = newBack;
    }
    return this;
  }

  insertAtBackMany(arr) {
    // add each val from an array
    for (let i = 0; i < arr.length; i++) {
      this.insertAtBack(arr[i]);
    }
    return this;
  }

  toArray() {
    // return an array containing all vals
    const newArr = [];
    let runner = this.head;
    while (runner) {
      newArr.push(runner.data);
      runner = runner.next;
    }
    return newArr;
  }

  // Bonus:
  /*
   * Creates a new node with the given data and inserts it at the back of
   * this list.
   * - Time: O(?).
   * - Space: O(?).
   * @param {any} data The data to be added to the new node.
   * @param {?ListNode} runner The current node during the traversal of this list
   *    or null when the end of the list has been reached.
   * @returns {SinglyLinkedList} This list.
  */
  insertAtBackRecursive(data, runner = this.head) {
    if (!runner.next) {
      runner.next = new ListNode(data);
      return this;
    }
    return this.insertAtBackRecursive(data, runner.next);
  }

}

const newList = new SinglyLinkedList();
// newList.addToFront(5).addToFront(1).addToFront(7).addToFront(3).addToFront(2).printValues();
newList.insertAtBack(54).insertAtBack(23).insertAtBack(11).insertAtBack(2).insertAtBackRecursive(62).printValues();
// newList.insertAtBackMany([1, 5, 9, 8, 4, 2, 7, 3, 6]).printValues();
console.log(newList.toArray());
// console.log(newList.isEmpty());
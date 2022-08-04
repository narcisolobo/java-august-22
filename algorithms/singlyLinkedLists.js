/*
 * A class to represent a single node of a SinglyLinkedList that can be
 * linked to other Node instances to form a list of linked nodes.
 */

class ListNode {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

/*
 * This class keeps track of the start (head) of the list and to store all the
 * functionality (methods) that each list should have.
 */

class SinglyLinkedList {
  constructor() {
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
    let output = "";
    while (runner) {
      output += `${runner.data} > `;
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
      this.head = newBack;
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

  // TUESDAY, August 2
  removeHead() {
    if (this.isEmpty()) return this;
    this.head = this.head.next;
    return this;
  }

  average() {
    let total = 0;
    let counter = 0;
    let current = this.head;

    while (current) {
      total += current.data;
      counter++;
      current = current.next;
    }
    console.log('hello world')
    return total / counter;
  }

  calcAverage() {
    if (this.isEmpty()) return this;
    let count = 0;
    let sum = 0;
    let runner = this.head;

    while (runner) {
      count += 1;
      sum += runner.data;
      runner = runner.next;
    }

    const average = sum / count;
    return average;
  }

  removeBack() {
    // Remove the last node of the list.
    let runner = this.head;
    if (this.isEmpty) return this.head;
    if (runner.next == null) {
      this.head = null;
      return this;
    }
    while (runner.next.next) {
      runner = runner.next;
    }
    runner.next = null;
    return this;
  }

  hasValue(val) {
    // Return true if val exists in list, false if not.
    if (this.head == null) return false;
    let runner = this.head;
    while (runner) {
      if (runner.data == val) return true;
      runner = runner.next;
    }
    return false;
  }

  // BONUS:
  hasValueRecursive(val, current = this.head) {
    // Implement hasValue recursively.
  }

  // Thursday, August 4:
  findMax() {
    // Find and return the max value in the list.
    if (this.isEmpty()) {
      console.log("This list is empty.");
      return this;
    } else if (this.head.next == null) {
      return this.head.data;
    }

    let max = this.head;
    let runner = this.head.next
    while (runner) {
      if (runner.data > max.data) {
        max = runner;
      }
      runner = runner.next;
    }

    return max.data;
  }

  secondToLast() {
    // Return the data of the second-to-last node in this list or null if node does not exist.
    if (this.isEmpty() || !this.head.next) {
      console.log("There are not enough nodes in this list.");
      return null;
    }
    let runner = this.head;
    while (runner.next.next) {
      runner = runner.next;
    }
    return runner.data;
  }

  removeVal(val) {
    // Remove the node that has the matching given val as it's data.
    // Return a boolean indicating if a node was removed or not.
    if (this.isEmpty()) {
      console.log("This list is empty.");
      return false;
    }

    if (!this.head.next && this.head.data === val) {
      this.head = null;
      return true;
    }

    let prev = null;
    let runner = this.head;

    while (runner) {
      if (runner.data === val && runner.next) {
        this.head = runner.next;
        return true;
      }
      if (runner.data === val) {
        prev.next = runner.next;
        return true;
      }
      prev = runner;
      runner = runner.next;
    }

    return false;
  }

  // BONUS:
  prepend(newVal, targetVal) {
    // Insert a new node before a node that has the given targetVal as its data.
    // Return a boolean indicating whether the node was pre-pended or not.
  }
}

const newList = new SinglyLinkedList();
newList.insertAtBackMany([1, 5, 9, 8, 4, 2, 7, 3, 6]);
const onlyOne = new SinglyLinkedList();
onlyOne.addToFront(3);
const emptyList = new SinglyLinkedList();
// newList.addToFront(5).addToFront(1).addToFront(7).addToFront(3).addToFront(2).printValues();
// newList.insertAtBack(54).insertAtBack(23).insertAtBack(11).insertAtBack(2).insertAtBackRecursive(62).printValues();
// newList.removeHead().printValues();

// console.log(newList.average());

console.log(newList.removeVal(1));
newList.printValues();
console.log(onlyOne.removeVal(3));
onlyOne.printValues();
console.log(emptyList.removeVal(4));
emptyList.printValues();
// newList.removeBack().printValues();
// console.log(newList.isEmpty());

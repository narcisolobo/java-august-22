/**
 * Class to represent a queue using an array to store the queued items.
 * Follows a FIFO (First In First Out) order where new items are added to the
 * back and items are removed from the front.
 */
class Queue {
  constructor() {
    this.items = [];
  }

  // Add a new given item to the back of this queue.
  // Return the new size of this queue.
  enqueue(item) {
    this.items.push(item);
    return this.size();
  }

  // Remove and return the first item of this queue.
  dequeue() {
    return this.items.shift();
  }

  // Retrieve the first item without removing it.
  // Return the first item or undefined if empty.
  front() {
    return this.items[0];
  }

  isEmpty() {
    return this.items === 0;
  }

  size() {
    return this.items.length;
  }
}

const myQ = new Queue();
console.log(myQ.dequeue());
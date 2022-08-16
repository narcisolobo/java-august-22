class MinHeap {
  constructor() {
    this.heap = [];
  }

  getParentIdx(childIdx) {
    return Math.floor((childIdx - 1) / 2);
  }

  getLeftChildIdx(parentIdx) {
    return (parentIdx + 1) * 2 - 1;
  }

  getRightChildIdx(parentIdx) {
    return parentIdx * 2 + 1;
  }

  getParentValue(childIdx) {
    return this.heap[this.getParentIdx(childIdx)];
  }

  getLeftChildValue(parentIdx) {
    return this.heap[this.getLeftChildIdx(parentIdx)];
  }

  getRightChildValue(parentIdx) {
    return this.heap[this.getRightChildIdx(parentIdx)];
  }

  isEmpty() {
    return this.heap.length == 0;
  }

  hasParent(idx) {
    return this.getParentIdx(idx) >= 0;
  }

  hasLeftChild(parentIdx) {
    return this.getLeftChildIdx(parentIdx) < this.heap.length;
  }

  hasRightChild(parentIdx) {
    return this.getRightChildIdx(parentIdx) < this.heap.length;
  }

  swap(idxA, idxB) {
    let temp = this.heap[idxA];
    this.heap[idxA] = this.heap[idxB];
    this.heap[idxB] = temp;
  }

  insert(value) {
    this.heap.push(value);
    let idx = this.heap.length - 1;
    while (this.hasParent(idx) && this.getParentValue(idx) > this.heap[idx]) {
      this.swap(idx, this.getParentIdx(idx));
      idx = this.getParentIdx(idx);
    }
    return this;
  }

  // Remove and return the min number
  // from the heap. Return null if empty.

  // Heap must be reordered following removal.
  // It must remain a minHeap.

  // ALGO
  //  1. Save the first node to a temp var.
  //  2. Pop last node off and set idx0 equal to the popped value.
  //  3. Iteratively swap the old last node that is now at idx0 with it's
  //  *  smallest child IF the smallest child is smaller than it.
  //  4. Return temp var.

  /*   extract() {
    if (this.isEmpty()) return null;
    const minNode = this.heap[0];
    this.heap[0] = this.heap[this.heap.length];
    let idx = 0;
    while (this.hasLeftChild(idx)) {
      let smallerChildIdx = this.getLeftChildIdx(idx);
      if (this.hasRightChild(idx) && this.getRightChildValue(idx) < this.getLeftChildValue(idx)) {
        smallerChildIdx = this.getRightChildIdx(idx);
      }
      if (this.heap[idx] < this.heap[smallerChildIdx]) {
        break;
      } else {
        this.swap(idx, smallerChildIdx);
      }
      idx = smallerChildIdx;
    }
    return minNode;
  } */

  extract() {
    if (this.heap.length == 0) return null;
    let temp = this.heap[0];
    this.swap(0, this.heap.length - 1);
    this.heap.pop();
    let currIdx = 0;
    while (this.hasLeftChild(currIdx)) {
      if (!this.hasRightChild(currIdx)) {
        if (this.heap[this.getLeftChildIdx(currIdx)] < this.heap[currIdx]) {
          this.swap(this.getLeftChildIdx(currIdx), currIdx);
        }
        return temp;
      }
      let minIdx = currIdx;
      if (this.heap[this.getLeftChildIdx(currIdx)] < this.heap[currIdx]) {
        minIdx = this.getLeftChildIdx(currIdx);
      }
      if (this.heap[this.getRightChildIdx(currIdx)] < this.heap[currIdx]) {
        minIdx = this.getRightChildIdx(currIdx);
      }
      if (minIdx == currIdx) {
        return temp;
      } else {
        this.swap(currIdx, minIdx);
        currIdx = minIdx;
      }
    }

    return temp;
  }

  insertMany(arr) {
    arr.forEach((value) => {
      this.insert(value);
    });
    return this;
  }
}

const myMinHeap = new MinHeap();
myMinHeap.insertMany([5, 4, 7, 2, 3, 1, 9, 8, 10, 6]);
console.log(myMinHeap.heap);
console.log(myMinHeap.extract());
console.log(myMinHeap.heap);

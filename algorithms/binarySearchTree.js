class BSTNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class BinarySearchTree {
  constructor() {
    this.root = null;
  }

  isEmpty() {
    // return true if tree is empty
    // false if not
    return this.root == null;
  }

  findMin() {
    // find and return the minimum value
    if (this.isEmpty) return null;
    let current = this.root;
    while (current.left) {
      current = current.left;
    }
    return current.value;
  }

  findMinRecursive(current = this.root) {
    if (this.isEmpty) return null;
    else if (current.left == null) {
      return current.value;
    } else return this.findMinRecursive(current.left);
  }

  findMax() {
    // find and return the maximum value
    if (this.isEmpty) return null;
    let current = this.root;
    while (current.right) {
      current = current.right;
    }
    return current.value;
  }

  findMaxRecursive(current = this.root) {
    if (this.isEmpty) return null;
    else if (current.right == null) {
      return current.value;
    } else return this.findMinRecursive(current.right);
  }

  contains(searchVal) {
    if (this.isEmpty()) {
      console.log('This BST is empty.');
      return this;
    }

    let current = this.root;
    while (current) {
      if (searchVal === current.value) {
        return true;
      }

      if (searchVal < current.value) {
        current = current.left;
      }

      if (searchVal > current.value) {
        current = current.right;
      }
    }

    return false;

  }

  containsRecursive(searchVal, current = this.root) {
    if (current == null) {
      return false;
    }

    if (searchVal === current.value) {
      return true;
    }

    if (searchVal < current.value) {
      return this.containsRecursive(searchVal, current.left);
    } else {
      return this.containsRecursive(searchVal, current.right);
    }
  }

  range() {
    // calculate and return the range (max - min) of the tree
    let max = this.root;
    let min = this.root;

    while(max.right) {
      max = max.right;
    }

    while(min.left) {
      min = min.left;
    }

    return max.value - min.value;
  }
}

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

  insert(value) {
    let newNode = new BSTNode(value);
    if (this.isEmpty()) {
      this.root = newNode;
      return this;
    }

    let current = this.root;

    while (current) {
      if (newNode.value < current.value ) {
        if (!current.left) {
          current.left = newNode;
          return this;
        }
        current = current.left;
      } else {
        if (!current.right) {
          current.right = newNode;
          return this;
        }
        current = current.right;
      }
    }
  }

  insertRecursive(value, current = this.root) {
    if (this.isEmpty()) {
      this.root = new BSTNode(value);
    }

    if (value < current.value) {
      if (current.left == null) {
        current.left = new BSTNode(value);
        return this;
      } else {
        return insertRecursive(value, current.left);
      }
    } else {
      if (current.right == null) {
        current.right = new BSTNode(value);
        return this;
      } else {
        return insertRecursive(value, current.right);
      }
    }
  }
  
  toArrPreOrder(node = this.root, vals = []) {
    if (!node) return;
    vals.push(node.value);
    this.toArrPreOrder(node.left, vals);
    this.toArrPreOrder(node.right, vals);
    return vals;
  }

  toArrInOrder(node = this.root, vals = []) {
    if (!node) return;
    this.toArrInOrder(node.left, vals);
    vals.push(node.value);
    this.toArrInOrder(node.right, vals);
    return vals;
  }
  
  toArrPostOrder(node = this.root, vals = []) {
    if (!node) return;
    this.toArrPostOrder(node.left, vals);
    this.toArrPostOrder(node.right, vals);
    vals.push(node.value);
    return vals;
  }

  insertMany(arr) {
    arr.forEach(item => {
      this.insert(item);
    });
  }

  toArrLevelOrder() {
    let queue = [];
    let output = [];

    queue.push(this.root);
    while (queue.length) {
      let node = queue.shift();
      output.push(node.value);
      if (node.left) queue.push(node.left);
      if (node.right) queue.push(node.right);
    }

    return output;
  }

  size(current = this.root) {
    if (!current) return 0;
    let leftSize = this.size(root.left);
    let rightSize = this.size(root.right);
    return Math.max(leftSize, rightSize) + 1;
  }

  height(root = this.root) {
    if (!root) return -1;

    let leftHeight = this.height(root.left);
    let rightHeight = this.height(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }
}

const myTree = new BinarySearchTree();
myTree.insertMany([30, 20, 50, 15, 25, 35, 45, 12, 17, 36, 32]);
console.log(myTree.height());
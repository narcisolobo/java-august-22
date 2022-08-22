class Stack {
  constructor() {
    this.items = [];
  }

  //  Add a new given item to the top / back of this stack.
  //  Return the new length of this stack.
  push(item) {
    this.items.push(item);
    return this.items.length;
  }

  //  Remove the top / last item from this stack.
  //  Return the removed item or undefined if this stack was empty.
  pop() {
    if (this.isEmpty()) return undefined;
    return this.items.pop();
  }

  //  Retrieve the top / last item from this stack without removing it.
  //  Return the top / last item of this stack.
  peek() {
    return this.items[this.items.length];
  }

  // Return whether or not this stack is empty.
  isEmpty() {
    return this.items === 0;
  }

  // Return the size of this stack.
  size() {
    return this.items.length;
  }
}
package datastructures.recursion.rBinarysearchtree;

public class RecursiveBTS {
    private Node root;

    public RecursiveBTS() {
    }

    public boolean contains(int value) {
        if (root == null) {
            return false;
        }

        Node temp = root;
        while (temp != null) {
            if (temp.getValue() == value) return true;
            if (value < temp.getValue()) {
                temp = temp.getLeft();
            } else if (value > temp.getValue()) {
                temp = temp.getRight();
            }
        }
        return false;
    }

    private boolean recursiveContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.getValue() == value) return true;

        if (value < currentNode.getValue()) {
            return recursiveContains(currentNode.getLeft(), value);
        } else if (value > currentNode.getValue()) {
            return recursiveContains(currentNode.getRight(), value);
        }

        return false;
    }

    public boolean recursiveContains(int value) {
        return recursiveContains(root, value);
    }

    public Node recursiveInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);
        if (value < currentNode.getValue()) {
            currentNode.setLeft(recursiveInsert(currentNode.getLeft(), value));
        } else if (value > currentNode.getValue()) {
            currentNode.setRight(recursiveInsert(currentNode.getRight(), value));
        }
        return currentNode;

    }

    public void recursiveInsert(int value) {
        if (root == null) root = new Node(value);
        recursiveInsert(root, value);
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (newNode.getValue() == temp.getValue()) return false;
            if (newNode.getValue() < temp.getValue()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    return true;
                }
                temp = temp.getLeft();
            } else if (newNode.getValue() > temp.getValue()) {
                if (temp.getRight() == null) {
                    temp.setRight(newNode);
                    return true;
                }
                temp = temp.getRight();
            }

        }
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;
        if (value < currentNode.getValue()) {
            currentNode.setLeft(deleteNode(currentNode.getLeft(), value));
        } else if (value > currentNode.getValue()) {
            currentNode.setRight(deleteNode(currentNode.getRight(), value));
        } else {
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                return null;
            } else if (currentNode.getLeft() == null) {
                currentNode = currentNode.getRight();
            } else if (currentNode.getRight() == null) {
                currentNode = currentNode.getLeft();
            } else {
                int subTreeMin = minValue(currentNode.getRight());
                currentNode.setValue(subTreeMin);
                currentNode.setRight(deleteNode(currentNode.getRight(),subTreeMin));
            }
        }
        return currentNode;
    }

    public int minValue(Node currentNode) {
        while (currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }

        return currentNode.getValue();
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

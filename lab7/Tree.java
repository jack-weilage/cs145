// Exercise 21.25: Tree.java
// TreeNode and Tree class declarations for a binary search tree.

package lab7;

// class TreeNode definition
class TreeNode<T extends Comparable<T>> {
    // package access members
    TreeNode<T> leftNode; // left node
    T data; // node value
    TreeNode<T> rightNode; // right node

    // constructor initializes data and makes this a leaf node
    public TreeNode(T nodeData) {
        data = nodeData;
        leftNode = rightNode = null; // node has no children
    }

    // locate insertion point and insert new node; ignore duplicate values
    public void insert(T insertValue) {
        // insert in left subtree
        if (insertValue.compareTo(data) < 0) {
            // insert new TreeNode
            if (leftNode == null) {
                leftNode = new TreeNode<>(insertValue);
            } else { // continue traversing left subtree recursively
                leftNode.insert(insertValue);
            }
        }
        // insert in right subtree
        else if (insertValue.compareTo(data) > 0) {
            // insert new TreeNode
            if (rightNode == null) {
                rightNode = new TreeNode<>(insertValue);
            } else { // continue traversing right subtree recursively
                rightNode.insert(insertValue);
            }
        }
    }

    public TreeNode<T> delete(T deleteValue) {
        int comparison = data.compareTo(deleteValue);

        if (comparison > 0 && leftNode != null) {
            leftNode = leftNode.delete(deleteValue);
        } else if (comparison < 0 && rightNode != null) {
            rightNode = rightNode.delete(deleteValue);
        } else if (comparison == 0) {
            // If the node has no children or only a right node. In either of these cases,
            // the rightNode can be returned.
            if (leftNode == null) {
                return rightNode;
            }
            // If rightNode is null here, there must only be a leftNode, so it can be
            // returned.
            if (rightNode == null) {
                return leftNode;
            }

            // Search from the right-most node, finding the smallest value.
            TreeNode<T> successor = rightNode;
            while (successor != null && successor.leftNode != null) {
                successor = successor.leftNode;
            }

            // Assign the value, then remove the node from the tree.
            data = successor.data;
            rightNode = rightNode.delete(data);

        }

        return this;
    }

    public TreeNode<T> search(T searchValue) {
        int comparison = data.compareTo(searchValue);

        if (comparison == 0) {
            return this;
        } else if (comparison > 0) {
            // If there's a left node, we should search it, otherwise the value isn't in the
            // tree.
            if (leftNode != null) {
                return leftNode.search(searchValue);
            } else {
                return null;
            }
        } else {
            // If there's a right node, we should search it, otherwise the value isn't in
            // the tree.
            if (rightNode != null) {
                return rightNode.search(searchValue);
            } else {
                return null;
            }
        }

    }
}

// class Tree definition
public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    // constructor initializes an empty Tree of integers
    public Tree() {
        root = null;
    }

    // insert a new node in the binary search tree
    public void insertNode(T insertValue) {
        if (root == null) {
            root = new TreeNode<>(insertValue); // create root node
        } else {
            root.insert(insertValue); // call the insert method
        }
    }

    public void deleteNode(T deleteValue) {
        if (root == null) {
            return;
        }

        root.delete(deleteValue);
    }

    public TreeNode<T> searchNode(T searchValue) {
        if (root == null) {
            return null;
        }

        return root.search(searchValue);
    }

    // begin preorder traversal
    public void preorderTraversal() {
        preorderHelper(root);
        System.out.println();
    }

    // recursive method to perform preorder traversal
    private void preorderHelper(TreeNode<T> node) {
        if (node == null) {
            return;
        }

        System.out.printf("%s ", node.data); // output node data
        preorderHelper(node.leftNode); // traverse left subtree
        preorderHelper(node.rightNode); // traverse right subtree
    }

    // begin inorder traversal
    public void inorderTraversal() {
        inorderHelper(root);
        System.out.println();
    }

    // recursive method to perform inorder traversal
    private void inorderHelper(TreeNode<T> node) {
        if (node == null) {
            return;
        }

        inorderHelper(node.leftNode); // traverse left subtree
        System.out.printf("%s ", node.data); // output node data
        inorderHelper(node.rightNode); // traverse right subtree
    }

    // begin postorder traversal
    public void postorderTraversal() {
        postorderHelper(root);
        System.out.println();
    }

    // recursive method to perform postorder traversal
    private void postorderHelper(TreeNode<T> node) {
        if (node == null) {
            return;
        }

        postorderHelper(node.leftNode); // traverse left subtree
        postorderHelper(node.rightNode); // traverse right subtree
        System.out.printf("%s ", node.data); // output node data
    }

    // begin printing tree
    public void outputTree(int totalSpace) {
        outputTreeHelper(root, totalSpace >= 0 ? totalSpace : 0);
    }

    // recursive method to print tree
    private void outputTreeHelper(TreeNode<T> currentNode, int spaces) {
        // recursively print right branch, then left
        if (currentNode != null) {
            outputTreeHelper(currentNode.rightNode, spaces + 5);

            for (int k = 0; k < spaces; k++) {
                System.out.print(" ");
            }

            System.out.println(currentNode.data);
            outputTreeHelper(currentNode.leftNode, spaces + 5);
        }
    }
}

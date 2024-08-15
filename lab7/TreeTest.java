package lab7;

import java.security.SecureRandom;

/**
 * TreeTest
 */
public class TreeTest {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();
        SecureRandom rnd = new SecureRandom();

        System.out.println("Inserting the following values:");
        for (int i = 0; i < 5; i++) {
            int v = rnd.nextInt(100);
            System.out.printf("%d ", v);
            tree.insertNode(v);
        }
        tree.insertNode(50);
        for (int i = 0; i < 5; i++) {
            int v = rnd.nextInt(100);
            System.out.printf("%d ", v);
            tree.insertNode(v);
        }

        System.out.println();

        System.out.println("Preorder traversal");
        tree.preorderTraversal();

        System.out.println("Inorder traversal");
        tree.inorderTraversal();

        System.out.println("Postorder traversal");
        tree.postorderTraversal();

        System.out.println("Before deleting");
        tree.outputTree(0);

        tree.deleteNode(50);

        System.out.println("After deleting");
        tree.outputTree(0);

        System.out.println("Search values:");
        for (int i = 0; i < 100; i++) {
            if (tree.searchNode(i) != null) {
                System.out.printf("%d is in the tree%n", i);
            }
        }
    }
}

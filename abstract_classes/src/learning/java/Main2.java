package learning.java;

public class Main2 {

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree(null);
        tree.traverse();

        String stringData = "5 7 3 9 8 2 1 0 5 4 6";
        String[] data = stringData.split(" ");
        for (String s : data) {
            tree.addItem(new MyNode(s));
        }

        tree.traverse();
        tree.removeItem(new MyNode("3"));
        tree.traverse();

        tree.removeItem(new MyNode("5"));
        tree.traverse();

        tree.removeItem(new MyNode("0"));
        tree.removeItem(new MyNode("4"));
        tree.removeItem(new MyNode("2"));
        tree.traverse();

        tree.removeItem(new MyNode("9"));
        tree.traverse();

        tree.removeItem(new MyNode("8"));
        tree.traverse();

        tree.removeItem(new MyNode("6"));
        tree.traverse();

        tree.removeItem(tree.getRoot());
        tree.traverse();

        tree.removeItem(tree.getRoot());
        tree.traverse();
    }

}

package learning.java;

public class Main {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());
        String stringData = "5 7 3 9 8 2 1 0 4 6";

        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new MyNode(s));
        }

        list.traverse();

        list.removeItem(new MyNode("3"));
        list.traverse();

        list.removeItem(new MyNode("5"));
        list.traverse();

        list.removeItem(new MyNode("0"));
        list.removeItem(new MyNode("4"));
        list.removeItem(new MyNode("2"));
        list.traverse();

        list.removeItem(new MyNode("9"));
        list.traverse();

        list.removeItem(new MyNode("8"));
        list.traverse();

        list.removeItem(new MyNode("6"));
        list.traverse();

        list.removeItem(list.getRoot());
        list.traverse();

        list.removeItem(list.getRoot());
        list.traverse();
    }
}

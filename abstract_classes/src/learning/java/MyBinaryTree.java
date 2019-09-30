package learning.java;

public class MyBinaryTree implements NodeList {

    private ListItem root = null;

    public MyBinaryTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        // tree is empty - item is new root
        if (this.root == null) {
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison > 0) {
                // new item is less than current item - move left
                if (currentItem.hasLeft()) {
                    currentItem = currentItem.left();
                } else {
                    currentItem.setLeft(newItem);
                    return true;
                }
            } else if (comparison < 0) {
                // new item is greater than current item - move right
                if (currentItem.hasRight()) {
                    currentItem = currentItem.right();
                } else {
                    currentItem.setRight(newItem);
                    return true;
                }
            } else {
                System.out.println(newItem.getValue() + " present in binary tree");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.left();
            } else if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.right();
            } else {
                performRemoval(currentItem, parentItem);
                return true;
            }

        }
        return false;
    }


    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if (!item.hasRight()) {
            // no right tree, make parent to point left tree
            if (parent.right() == item) {
                // item is right child of it's parent
                parent.setRight(item.left());
            } else if (parent.left() == item) {
                // item is left child of it's parent
                parent.setLeft(item.left());
            } else {
                // parent must be item, delete root of tree
                this.root = item.left();
            }
        } else if (!item.hasLeft()) {
            // no left tree, make parent point to right tree
            if (parent.right() == item) {
                //item is right child of it's parent
                parent.setRight(item.right());
            } else if (parent.left() == item) {
                // item is left child of it's parent
                parent.setLeft(item.right());
            } else {
                // parent must be item, delete root of tree
                this.root = item.right();
            }
        } else {
            // left and right tree is not empty
            // find left-most child of right tree
            ListItem current = item.right();
            ListItem leftmostParent = item;
            while (current.hasLeft()) {
                leftmostParent = current;
                current = current.left();
            }
            // put smallest value into node to be deleted
            item.setValue(current.getValue());
            // delete smallest value
            if (leftmostParent == item) {
                item.setRight(current.right());
            } else {
                leftmostParent.setLeft(current.right());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.left());
            System.out.println(root.getValue());
            traverse(root.right());
        }
    }

    public void traverse() {
        traverse(this.root);
    }
}

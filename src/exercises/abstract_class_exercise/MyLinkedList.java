package exercises.abstract_class_exercise;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        // list empty - item is new root
        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                // item is greater than current, move to right if possible
                if (currentItem.hasRight()) {
                    currentItem = currentItem.right();
                } else {
                    // no right item, insert at the end of list
                    currentItem.setRight(newItem).setLeft(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                //item is less, insert before
                if (currentItem.hasLeft()) {
                    currentItem.left().setRight(newItem).setLeft(currentItem.left());
                    newItem.setRight(currentItem).setLeft(newItem);
                } else {
                    //no previous node, insert at start of list
                    this.root = newItem.setRight(currentItem).setLeft(newItem);
                }
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present, not added");
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
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                // found item  = delete
                if (currentItem == this.root) {
                    this.root = currentItem.right();
                } else {
                    currentItem.left().setRight(currentItem.right());
                    if (currentItem.hasRight()) {
                        currentItem.right().setLeft(currentItem.left());
                    }
                }
                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.right();
            } else {
                // item greater than one to be deleted
                // item not on list
                return false;
            }
        }
        // end of list, item not found
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.right();
            }
        }
    }

    public void traverse() {
        traverse(this.root);
    }
}

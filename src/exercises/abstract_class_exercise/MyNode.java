package exercises.abstract_class_exercise;

public class MyNode extends ListItem {

    public MyNode(Object value) {
        super(value);
    }

    @Override
    public ListItem right() {
        return this.rightNode;
    }

    @Override
    public boolean hasRight() {
        return (this.rightNode != null);
    }

    @Override
    ListItem setRight(ListItem item) {
        this.rightNode = item;
        return this.rightNode;
    }


    @Override
    public ListItem left() {
        return this.leftNode;
    }

    @Override
    public boolean hasLeft() {
        return (this.leftNode != null);
    }

    @Override
    ListItem setLeft(ListItem item) {
        this.leftNode = item;
        return this.leftNode;
    }


    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }
}

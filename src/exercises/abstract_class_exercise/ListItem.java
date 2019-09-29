package exercises.abstract_class_exercise;

public abstract class ListItem {

    Object value;
    ListItem rightNode = null;
    ListItem leftNode = null;

    public ListItem(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    abstract ListItem right();
    abstract boolean hasRight();
    abstract ListItem setRight(ListItem item);

    abstract ListItem left();
    abstract boolean hasLeft();
    abstract ListItem setLeft(ListItem item);

    abstract int compareTo(ListItem item);

}


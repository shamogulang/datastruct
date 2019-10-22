package tree.binary.avl;

/**
 * @author chenjianhui on 2019/10/22
 */
public class AvlTree {

    private AvlTree left;
    private AvlTree right;
    private int data;
    private int height;

    public AvlTree(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public AvlTree getLeft() {
        return left;
    }

    public void setLeft(AvlTree left) {
        this.left = left;
    }

    public AvlTree getRight() {
        return right;
    }

    public void setRight(AvlTree right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

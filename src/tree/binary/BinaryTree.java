package tree.binary;

/**
 * @author chenjianhui on 2019/10/15
 */
public class BinaryTree {

    private BinaryTree left;
    private BinaryTree right;
    /**
     * 为了方便就是使用String类型的数据
     */
    private String data;

    public BinaryTree() {
    }

    public BinaryTree(String data) {
        this.data = data;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

package tree.binary.avl;

/**
 * @author chenjianhui on 2019/10/22
 */
public class Client {
    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree(10);
        avlTree = AvlUtils.insert(avlTree,14);
        avlTree = AvlUtils.insert(avlTree,16);
        avlTree = AvlUtils.insert(avlTree,18);
        avlTree = AvlUtils.insert(avlTree,24);
        avlTree = AvlUtils.insert(avlTree,15);
        avlTree = AvlUtils.insert(avlTree,25);

        avlTree = AvlUtils.remove(avlTree,10);
        avlTree = AvlUtils.remove(avlTree,14);
        avlTree = AvlUtils.remove(avlTree,15);
        System.out.println();
    }
}

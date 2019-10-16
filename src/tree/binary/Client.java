package tree.binary;

import tree.binary.utils.BinaryTreeUtils;

/**
 * @author chenjianhui on 2019/10/15
 */
public class Client {

    public static void main(String[] args) {
        BinaryTree binaryTree =  BinaryTreeUtils.buildConcreteTree();

        //获取两个节点最近的祖先节点
        //binaryTree = BinaryTreeUtils.getLCA(binaryTree,"F","E");
        //删除节点和其子节点
        //binaryTree = BinaryTreeUtils.clearAllEqualsData(binaryTree,"A");

        ///打印一个节点的所有祖先节点
        //BinaryTreeUtils.printAllAncestor(binaryTree,"E");

        //String[] nlr = {"A","B","D","C"};
        //String[] lnr = {"D","B","A","C"};
        //binaryTree = BinaryTreeUtils.buildBinaryTreeByLNRAndNLR(nlr,0,3,lnr,0,3);

        //判断二叉树是不是完全二叉树
        //System.out.println(BinaryTreeUtils.isTotalBinaryTree(binaryTree));

        //后序遍历
        //BinaryTreeUtils.LRNRecurse(binaryTree);
        //先序遍历
        //BinaryTreeUtils.NLRBinaryTree(binaryTree);

        //中序序遍历
        //BinaryTreeUtils.LNRBinaryTree(binaryTree);

        //层次遍历二叉树
        //BinaryTreeUtils.levelBinaryTree(binaryTree);

        //反转二叉树
        //BinaryTreeUtils.invertBinaryTreeRecurse(binaryTree);

        //计算二叉树的高度
        //System.out.println(BinaryTreeUtils.getBinaryTreeHighRecurse(binaryTree));

        //计算二叉树的节点个数
        //System.out.println(BinaryTreeUtils.countBinaryTreeRecurse(binaryTree));

        //后序遍历
        //BinaryTreeUtils.LRNRecurse(binaryTree);

        //中序遍历
        //BinaryTreeUtils.LNRRecurse(binaryTree);

        //先序遍历
        //BinaryTreeUtils.NLROrderRecurse(binaryTree);
    }
}

package tree.binary.utils;

import tree.binary.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author chenjianhui on 2019/10/15
 */
public class BinaryTreeUtils {

    /**
     * 查找两个节点的最近公共祖先
     */
    public static BinaryTree getLCA(BinaryTree root,String data0,String data1){
        if(root == null){
            return  null;
        }

        if(root.getData().equals(data0) || root.getData().equals(data1)){
            return root;
        }

        BinaryTree left = getLCA(root.getLeft(),data0,data1);
        BinaryTree right = getLCA(root.getRight(),data0,data1);

        if(left != null && right != null){
            return root;
        }else if(left != null &&  right == null){
            return left;
        }else if(right != null && left == null){
            return right;
        }
        return null;
    }

    /**
     * 删除跟data相等的节点和其子节点
     */
    public static BinaryTree clearAllEqualsData(BinaryTree binaryTree,String data){
        if(binaryTree == null){
            return binaryTree;
        }
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree p = binaryTree;
        while (p != null || !stack.isEmpty()){
            if(p != null){
                if(p.getData().equals(data)){
                    deleteAll(p);
                    p = null;
                }else{
                    stack.push(p);
                    p = p.getLeft();
                }
            }else{
                p = stack.pop();
                p = p.getRight();
            }
        }
        return binaryTree;
    }

    /**
     * 模拟c语言释放一个节点和其所有子节点
     */
    public static void deleteAll(BinaryTree binaryTree){
       if(binaryTree == null){
           return;
       }
       deleteAll(binaryTree.getLeft());
       deleteAll(binaryTree.getRight());
       binaryTree = null;
    }

    /**
     * 打印某个节点所有的祖先节点
     */
    public static void printAllAncestor(BinaryTree binaryTree,String data){
         if(binaryTree == null){
             return;
         }
         Stack<BinaryTree> stack = new Stack<>();
         BinaryTree p = binaryTree;
         BinaryTree last = null;
         while(p != null || !stack.isEmpty()){
             if(p != null){
                 if(p.getData().equals(data)){
                     break;
                 }
                 stack.push(p);
                 p = p.getLeft();
             }else{
                 p = stack.peek();
                 if(p.getRight() != null && p.getRight() != last){
                     p = p.getRight();
                 }else {
                     p = stack.pop();
                     last = p;
                     p = null;
                 }
             }
         }
         while (!stack.isEmpty()){
             System.out.println(stack.pop().getData());
         }
    }

    /**
     * 通过先序遍历和中序遍历构造二叉树
     * @return
     */
    public static BinaryTree buildBinaryTreeByLNRAndNLR(String[] nLR,int nLRStart,int nLREnd, String[] lNR,int lNRStart,int lNREnd){
        BinaryTree binaryTree = new BinaryTree();
        if(nLR ==  null || lNR==null ){
             return null;
        }

        String data = nLR[nLRStart];
        binaryTree.setData(data);
        int position =  getIndex(data,lNR);

        int llent = position-lNRStart;
        int rlent = lNREnd-position;

        if(llent > 0){
            binaryTree.setLeft(buildBinaryTreeByLNRAndNLR(nLR,nLRStart+1,nLRStart+llent,lNR,lNRStart,lNRStart+llent-1));
        }

        if(rlent > 0){
            binaryTree.setRight(buildBinaryTreeByLNRAndNLR(nLR,nLREnd-rlent+1,nLREnd,lNR,lNREnd-rlent+1,lNREnd));
        }

        return binaryTree;
    }

    private static int getIndex(String data,String[] lNR){
        for(int i = 0; i < lNR.length;i++){
            if(lNR[i].equals(data)){
                return i;
            }
        }
        return -1;
    }


    /**
     * 判断这个树是不是完全二叉树
     * @param binaryTree
     * @return
     */
    public static boolean isTotalBinaryTree(BinaryTree binaryTree){
        if(binaryTree ==  null){
            return true;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        BinaryTree p = binaryTree;
        queue.add(p);
        while (!queue.isEmpty()){
            p = queue.poll();
            if(p != null){
                queue.add(p.getLeft());
                queue.add(p.getRight());
            }else{
                while(!queue.isEmpty()){
                    p = queue.poll();
                    if(p != null){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 非递归版本的后序遍历
     * @param binaryTree
     */
    public static void LRNBinaryTree(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree p = binaryTree;
        BinaryTree lastAccess = null;
        while (p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.getLeft();
            }else{
                p = stack.peek();
                if(p.getRight() != null && p.getRight() != lastAccess){
                    p = p.getRight();
                }else{
                    p = stack.pop();
                    System.out.println(p.getData());
                    lastAccess = p;
                    p = null;
                }
            }
        }
    }

    /**
     * 非递归版本的先序遍历
     * @param binaryTree
     */
    public static void NLRBinaryTree(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree p = binaryTree;
        while (p != null || !stack.isEmpty()){
             if(p != null){
                 System.out.println(p.getData());
                 stack.push(p);
                 p = p.getLeft();
             }else{
                 p = stack.pop();
                 p = p.getRight();
             }

        }
    }

    /**
     * 非递归版本中序遍历
     * @param binaryTree
     */
    public static void LNRBinaryTree(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        Stack<BinaryTree> binaryTreeStack = new Stack<>();
        BinaryTree p = binaryTree;
        while (p != null || !binaryTreeStack.isEmpty()){
             if(p != null){
                 binaryTreeStack.push(p);
                 p = p.getLeft();
             }else{
                 p = binaryTreeStack.pop();
                 System.out.println(p.getData());
                 p = p.getRight();
             }
        }
    }

    /**
     * 层次遍历
     * @param binaryTree
     */
    public static void levelBinaryTree(BinaryTree binaryTree){
        Queue<BinaryTree> queue = new LinkedList();
        if(binaryTree != null){
            queue.add(binaryTree);
        }
        while (!queue.isEmpty()){
            BinaryTree temp = queue.poll();
            System.out.println(temp.getData());
            if(temp.getLeft() != null){
                queue.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.add(temp.getRight());
            }
        }
    }

    /**
     * 递归反转二叉树
     * @param binaryTree
     */
    public static void invertBinaryTreeRecurse(BinaryTree binaryTree){

        if(binaryTree != null){
           BinaryTree left = binaryTree.getLeft();
           BinaryTree right = binaryTree.getRight();
           binaryTree.setRight(left);
           binaryTree.setLeft(right);
           invertBinaryTreeRecurse(binaryTree.getLeft());
           invertBinaryTreeRecurse(binaryTree.getRight());
        }
    }
    /**
     * 递归方式获取二叉树的高度
     * @param binaryTree
     * @return
     */
    public static int getBinaryTreeHighRecurse(BinaryTree binaryTree){
        if(binaryTree == null){
            return 0;
        }
        int left = getBinaryTreeHighRecurse(binaryTree.getLeft());
        int right = getBinaryTreeHighRecurse(binaryTree.getRight());
        return left > right ? left+1 : right+1;
    }

    /**
     * 统计二叉树的个数，递归方法
     * @param binaryTree
     * @return
     */
    public static int countBinaryTreeRecurse(BinaryTree binaryTree){
        if(binaryTree == null){
            return 0;
        }
        return 1+countBinaryTreeRecurse(binaryTree.getLeft())+countBinaryTreeRecurse(binaryTree.getRight());
    }

    /**
     * 构造一棵简单的树
     *               A
     *           B      C
     *        D    E  F     G
     * @return
     */
    public static  BinaryTree buildConcreteTree(){
        BinaryTree root = new BinaryTree();
        root.setData("A");
        root.setLeft(new BinaryTree("B"));
        root.setRight(new BinaryTree("C"));

        BinaryTree left = root.getLeft();
        left.setLeft(new BinaryTree("D"));
        left.setRight(new BinaryTree("E"));
        BinaryTree right = root.getRight();
        right.setLeft(new BinaryTree("F"));
        right.setRight(new BinaryTree("G"));
        return root;
    }

    /**
     * 先序遍历递归版本
     * @param binaryTree
     */
    public static void NLROrderRecurse(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        System.out.println(binaryTree.getData());
        NLROrderRecurse(binaryTree.getLeft());
        NLROrderRecurse(binaryTree.getRight());
    }

    /**
     * 中序遍历递归版本
     * @param binaryTree
     */
    public static void LNRRecurse(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        LNRRecurse(binaryTree.getLeft());
        System.out.println(binaryTree.getData());
        LNRRecurse(binaryTree.getRight());
    }

    /**
     * 后续序遍历递归版本
     * @param binaryTree
     */
    public static void LRNRecurse(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        LRNRecurse(binaryTree.getLeft());
        LRNRecurse(binaryTree.getRight());
        System.out.println(binaryTree.getData());
    }
}

package tree.binary.avl;

/**
 * @author chenjianhui on 2019/10/22
 */
public class AvlUtils {

    /**
     * 获取树的高度
     * @param avlTree
     * @return
     */
    public static int getHeight(AvlTree avlTree){
        if(avlTree == null){
            return 0;
        }
        return Math.max(getHeight(avlTree.getLeft()),getHeight(avlTree.getRight()))+1;
    }

    /**
     * 获取某个节点的平衡因子
     * @param avlTree
     * @return
     */
    public static int getBalanceVal(AvlTree avlTree){
        if(avlTree==null){
            return 0;
        }
        if(avlTree.getLeft() != null && avlTree.getRight()!=null){
            return avlTree.getLeft().getHeight()-avlTree.getRight().getHeight();
        }
        if(avlTree.getLeft() != null){
            return avlTree.getLeft().getHeight();
        }
        if(avlTree.getRight() != null){
            return -avlTree.getRight().getHeight();
        }
        return 0;
    }

    public static AvlTree llRotate(AvlTree avlTree){
         AvlTree left = avlTree.getLeft();
         avlTree.setLeft(left.getRight());
         left.setRight(avlTree);
         left.setHeight(getHeight(left));
         avlTree.setHeight(getHeight(avlTree));
         return left;
    }

    public static  AvlTree rrRotate(AvlTree avlTree){
        AvlTree right = avlTree.getRight();
        avlTree.setRight(right.getLeft());
        right.setLeft(avlTree);
        right.setHeight(getHeight(right));
        avlTree.setHeight(getHeight(avlTree));
        return right;
    }

    public static AvlTree lrRotate(AvlTree avlTree){
        avlTree.setLeft(rrRotate(avlTree.getRight()));
        return llRotate(avlTree);
    }

    public static AvlTree  rlRotate(AvlTree avlTree){
        avlTree.setRight(llRotate(avlTree.getRight()));
        return rrRotate(avlTree);
    }

    public static AvlTree reBalance(AvlTree avlTree){
        int balanceVal = getBalanceVal(avlTree);
        if(balanceVal > 1 && getBalanceVal(avlTree.getLeft()) > 0){
            avlTree = llRotate(avlTree);
        }else if(balanceVal > 1 && getBalanceVal(avlTree.getLeft()) <=0){
            avlTree = lrRotate(avlTree);
        }else if(balanceVal < -1 && getBalanceVal(avlTree.getRight()) > 0){
            avlTree = rlRotate(avlTree);
        }else if(balanceVal < -1 && getBalanceVal(avlTree.getRight()) <=0){
            avlTree = rrRotate(avlTree);
        }
        return avlTree;
    }

    public static AvlTree insert(AvlTree avlTree,int data){
        if(avlTree == null){
            avlTree = new AvlTree(data);
        }else if(avlTree.getData() > data){
            avlTree.setLeft(insert(avlTree.getLeft(),data));
        }else if(data > avlTree.getData()){
            avlTree.setRight(insert(avlTree.getRight(),data));
        }else{
            System.out.println("不能插入相同元素");
        }
        avlTree.setHeight(getHeight(avlTree));
        avlTree = reBalance(avlTree);
        return avlTree;
    }

    /**
     * 删除，返回根节点
     * @param avlTree
     * @param data
     * @return
     */
    public static  AvlTree remove(AvlTree avlTree,int data){
        if(avlTree == null){
            return avlTree;
        }else{
            if(data < avlTree.getData()){
                avlTree.setLeft(remove(avlTree.getLeft(),data));
            }else if(data > avlTree.getData()){
                avlTree.setRight(remove(avlTree.getRight(),data));
            }else {
                if(avlTree.getLeft() != null && avlTree.getRight() != null){
                    AvlTree maxAvlTree =  getMax(avlTree.getLeft());
                    avlTree.setData(maxAvlTree.getData());
                    avlTree.setLeft(remove(avlTree.getLeft(),maxAvlTree.getData()));
                }else {
                    if(avlTree.getLeft() != null){
                        avlTree =  avlTree.getLeft();
                    }else{
                        avlTree = avlTree.getRight();
                    }
                }
            }
        }
        //重新平衡
        avlTree = reBalance(avlTree);
        return avlTree;
    }

    public static AvlTree getMax(AvlTree avlTree){
        if(avlTree.getRight() == null){
            return avlTree;
        }else {
            avlTree = getMax(avlTree.getRight());
        }
        return avlTree;
    }
}

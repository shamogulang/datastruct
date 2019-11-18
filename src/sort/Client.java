package sort;

/**
 * @author chenjianhui on 2019/11/12
 */
public class Client {

    public static void main(String[] args) {
        int[] arrs = {13,2,3,6,8,1};
        SortUtils sortUtils = new SortUtils();
        sortUtils.heapSort(arrs);
        sortUtils.printArrs(arrs);
    }
}

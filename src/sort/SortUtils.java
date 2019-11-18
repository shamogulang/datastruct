package sort;

/**
 * @author chenjianhui on 2019/11/12
 */
public class SortUtils {

    /**
     * 归并排序
     *
     * @param arrs
     */
    public void mergeSort(int[] arrs) {
        if (arrs == null || arrs.length <= 0) {
            return;
        }

        int high = arrs.length - 1;
        int low = 0;
        mergeSort(low, high, arrs);
    }

    public void merging(int low,int high,int mid,int[] arrs){
        int[] temp = new int[high-low+1];
        int lleft = low;
        int lright = mid;
        int rleft = mid+1;
        int rright = high;
        int index = 0;
        while (lleft <= lright && rleft <= rright){
            if(arrs[lleft] < arrs[rleft]){
                temp[index++] = arrs[lleft++];
            }else{
                temp[index++] = arrs[rleft++];
            }
        }

        while (lleft <= lright){
            temp[index++] = arrs[lleft++];
        }

        while (rleft <= rright){
            temp[index++] = arrs[rleft++];
        }

        for(int i=0;i<temp.length;i++){
            arrs[low++] = temp[i];
        }
    }

    private void mergeSort(int low, int high, int[] arrs) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSort(low, mid,arrs);
            mergeSort(mid+1,high,arrs);
            merging(low,high,mid,arrs);
        }
    }


    /**
     * 希尔排序
     *
     * @param arrs
     */
    public void shearSort(int[] arrs) {
        if (arrs == null || arrs.length <= 0) {
            return;
        }
        int lent = arrs.length;
        for (int gap = lent / 2; gap > 0; gap = gap / 2) {
            for(int i = gap; i < lent; i++){
               while (i-gap >= 0 && arrs[i] < arrs[i-gap]){
                    swap(i,i-gap,arrs);
                    i = i - gap;
               }
            }
        }

    }

    /**
     * 选择排序
     *
     * @param arrs
     */
    public void selectSort(int[] arrs) {
        if (arrs == null || arrs.length <= 0) {
            return;
        }
        int lent = arrs.length;
        for (int i = 0; i < lent; i++) {
            int min = i;
            for (int j = i + 1; j < lent; j++) {
                if (arrs[min] > arrs[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(min, i, arrs);
            }
        }
    }

    /**
     * 堆排序，从小到大，所以要小根堆
     *
     * @param arrs
     */
    public void heapSort(int[] arrs) {
        if (arrs == null || arrs.length <= 0) {
            return;
        }

        int lent = arrs.length;
        int heapSize = 1;
        //第一个算是已经配好的
        for (int i = 1; i < lent; i++) {
            heapInsert(i, arrs);
            heapSize++;
        }

        for (; heapSize > 0; ) {
            swap(--heapSize, 0, arrs);
            heapify(0, heapSize, arrs);
        }
    }

    private void heapify(int index, int heapSize, int[] arrs) {
        int letf = 2 * index + 1;
        if (letf >= heapSize) {
            return;
        }
        int right = letf + 1;
        int max = letf;
        if (right < heapSize && arrs[max] < arrs[right]) {
            max = right;
        }
        if (arrs[index] < arrs[max]) {
            swap(index, max, arrs);
            heapify(max, heapSize, arrs);
        }
    }

    private void heapInsert(int index, int[] arrs) {
        int parent = (index - 1) / 2;
        while (arrs[parent] > arrs[index]) {
            swap(parent, index, arrs);
            index = parent;
            parent = (parent - 1) / 2;
        }
    }

    /**
     * 快速排序
     *
     * @param arrs
     */
    public void quickSort(int[] arrs) {
        if (arrs == null || arrs.length <= 0) {
            return;
        }
        int low = 0;
        int high = arrs.length - 1;
        quickSort(low, high, arrs);
    }

    public void quickSort(int low, int high, int[] arrs) {
        if (low < high) {
            int less = low - 1;
            int more = high + 1;
            int current = low;
            int num = arrs[low];
            while (current < more) {
                if (arrs[current] < num) {
                    swap(current++, ++less, arrs);
                } else if (arrs[current] == num) {
                    current++;
                } else {
                    swap(current, --more, arrs);
                }
            }

            quickSort(low, less, arrs);
            quickSort(more, high, arrs);
        }
    }


    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] arrs) {
        if (arrs == null || arrs.length <= 0) {
            return;
        }
        int lent = arrs.length;
        for (int i = 0; i < lent - 1; i++) {
            int temp = 0;
            for (int j = 1; j < lent - i; j++) {
                if (arrs[temp] > arrs[j]) {
                    swap(temp, j, arrs);
                }
                temp = j;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arrs
     */
    public void insertSort(int[] arrs) {
        if (arrs == null || arrs.length <= 0) {
            return;
        }
        int lent = arrs.length;
        for (int i = 1; i < lent; i++) {
            int temp = i;
            for (int j = temp - 1; j >= 0; j--) {
                if (arrs[temp] < arrs[j]) {
                    swap(temp, j, arrs);
                    temp = j;
                }
            }
        }
    }

    private void swap(int i, int j, int[] arrs) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    public void printArrs(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + ", ");
        }
    }
}

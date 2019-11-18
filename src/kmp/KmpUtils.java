package kmp;

/**
 * @author chenjianhui on 2019/11/18
 */
public class KmpUtils {


    public int kmpIndexOf(String str0,String str){
        if (str0 == null || str0.length() <= 0 || str == null || str.length() <= 0 || str.length() < str0.length()) {
            return -1;
        }
        int lent0 = str0.length();
        int lent = str.length();
        int i = 0;
        int j = 0;
        int[] next = getNext(str0);
        while (i < lent0 && j < lent) {
            //i=-1时，说明对于0的那个数页比较了
            if (i == -1 || str0.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            } else {
                i = next[i];
            }
        }

        return i == lent0  ? j - i : -1;
    }

    //求解的next数组求的是某个字符串开始，前面的字串，比如a,没有前串，则约定为-1
    public int[] getNext(String str){
        if(str == null && str.length() <= 0){
            return null;
        }
        int lent = str.length();
        int[] next = new int[lent];
        next[0] = -1;
        int i = 1;
        int j = -1;
        while (i < lent){
          if(j == -1 || str.charAt(i-1) == str.charAt(j)){
              next[i++] = ++j;
          }else{
              j = next[j];
          }
        }
        return next;
    }

    public int indexOf(String str0, String str) {
        if (str0 == null || str0.length() <= 0 || str == null || str.length() <= 0 || str.length() < str0.length()) {
            return -1;
        }
        int lent0 = str0.length();
        int lent = str.length();
        int i = 0;
        int j = 0;
        while (i < lent0 && j < lent) {
            if (str0.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            } else {
                j = j - i + 1;
                i = 0;
            }
        }

        return i == lent0  ? j - i : -1;
    }

}

package kmp;


/**
 * @author chenjianhui on 2019/11/18
 */
public class Client {

    public static void main(String[] args) {
        KmpUtils kmpUtils = new KmpUtils();
        System.out.println(kmpUtils.indexOf("cda","abcabcda"));

        System.out.println(kmpUtils.kmpIndexOf("bca","abcabcda"));
    }
}

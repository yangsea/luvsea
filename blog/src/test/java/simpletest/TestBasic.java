package simpletest;
/*二分查找：前提，该数组已经是一个有序数组，必须先排序，再查找。*/
public class TestBasic {
    
    public static void main(String[] args) {
        
//        int a = 32 >>> 2;
//        System.out.println(a);
        Integer[] arr = new Integer[]{1,2,4,6,7,10,12,16,20};
        binarySearch(arr, 16);
    }
    
    public static int binarySearch(Integer[] srcArray, int des) {
        int low = 0;
        int high = srcArray.length - 1;
     
        while ((low <= high) && (low <= srcArray.length - 1)
                && (high <= srcArray.length - 1)) {
            int middle = (high + low) >> 1;
            if (des == srcArray[middle]) {
                System.out.println(middle);
                return middle;
            } else if (des < srcArray[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

}

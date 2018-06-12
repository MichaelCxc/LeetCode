import apple.laf.JRSUIUtils;


import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) {
        int[] nums = {5,32,62345,23,456,2,345,62,1,3,5,6,7,5};
        quickSort(nums,0,nums.length-1);
        for(int i : nums){
            System.out.println(i);
        }


    }

    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    private static void quickSort(int[] nums, int left, int right){
        if (left >= right || nums == null || nums.length <= 1) {
            return;
        }
        int i = left, j = right;
        int pivotal = nums[left + (right -left)/2];
        //int pivotal = nums[left];
        while(i <= j){
            while(nums[i] < pivotal ){
                i++;
            }
            while(nums[j] > pivotal){
                j--;
            }
            if(i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }else if(i == j){
                i++;
            }

        }
        quickSort(nums,left,j);
        quickSort(nums,i,right);

    }

    public static String shortestPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(j>=0){
            if(s.charAt(i)==s.charAt(j)){
                i++;
            }
            j--;
        }

        if(i==s.length())
            return s;

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix+mid+suffix;
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointer = new int[primes.length];
        //Arrays.fill(pointer,1);
        int[] res = new int[n+1];
        res[0] = 1;
        for(int i = 1;i < n; i++){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int j = 0; j < primes.length;j++){  //find the min of these produce of prime
                if(primes[j]*res[pointer[j]]<min){
                    min = Math.min(min,primes[j]*res[pointer[j]]);
                    index = j;
                }else if(primes[j]*res[pointer[j]]==min){
                    pointer[j]++;
                }
            }
            res[i] = min;
            pointer[index]++;

        }
        return res[n-1];
    }

    private static void swap(String[] str, int left, int right){
        String tmp = str[left];
        str[left] = str[right];
        str[right] = tmp;
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        // handle the first and last element in num[]
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        int left = 1, right = n - 2;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }





    private static ArrayList<String> stringToCharArray(String s) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            System.out.println(i);
            System.out.println(j);

            if (s.charAt(j) < '0' || s.charAt(j) > '9') {
                Character tmp = s.charAt(j);
                System.out.println("字符tmp="+tmp);
                res.add(tmp.toString());
            } else {
                StringBuilder sb = new StringBuilder();

                while (s.charAt(j) >= '0' && s.charAt(j) <= '9'&&j<s.length()) {
                    Character tmp = s.charAt(j);
                    System.out.println("tmp="+tmp);
                    sb.append(tmp.toString());
                    System.out.println("sb="+sb);
                    j++;
                    if(j>s.length()) {
                        System.out.println("j=" + j);
                        break;
                    }
                }
                res.add(sb.toString());
                if(j<s.length()){
                    i = j;
                }else{
                    break;
                }
                System.out.println("最终i="+i);
                System.out.println("最终j="+j);
            }
        }
        return res;
    }

    private static ListNode merge(ListNode head, ListNode secHead){
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while(head != null && secHead != null){
            if(head.val >= secHead.val) {
                pre.next = secHead;
                secHead = secHead.next;
            }else{
                pre.next = head;
                head = head.next;
            }
            pre = pre.next;
        }
        if(head != null){
            pre.next = head;
        }
        if(secHead != null){
            pre.next = secHead;
        }
        return dummy.next;
    }

    private static String reverse(String s){

        StringBuilder sb = new StringBuilder();
        for(int j = s.length()-1;j>=0;j--){
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }

    private static ListNode rotateOne(ListNode head){
        ListNode pre = head;
        while(pre.next.next != null){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        pre.next = null;
        cur.next = head;
        return cur;
    }

}

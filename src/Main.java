import apple.laf.JRSUIUtils;


import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {


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

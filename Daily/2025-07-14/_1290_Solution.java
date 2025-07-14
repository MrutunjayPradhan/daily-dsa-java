class _1290_Solution {
    public int getDecimalValue(ListNode head) {
        int num =0;
        while(head !=null){
            num = num<<1;
            if(head.val==1){
                num +=1;
            }
            head = head.next;
        }
        return num;
    }
}
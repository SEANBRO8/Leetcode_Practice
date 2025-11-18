package TwoPointer;

public class SlowAndFast {
    public ListNode listNodeFindM (ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkCircle(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }

    public ListNode startOfCircle(ListNode head){
       
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(fast != null && fast.next != null) return null;
        fast = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public int removeDuplicates(int[] nums) {
        /**
        
        0,0,1,1,1,2,2,3,3,4
          s
            f
        0 1 2 3 4
        */

        int s = 1;
        int n = nums.length; 

        for(int f = 1; f < n; f++){
            if(nums[f - 1] != nums[f]){
                nums[s] = nums[f]; 
                s++;
            }
        }
        return s;
    }

    public void moveZeroes(int[] nums) {
        /**
        
        
            0 1 0 3 12
            s
            f
         */
        int s = 0, f = 0, n = nums.length;
        while(f < n){
            if(nums[f] != 0){
                nums[s++] = nums[f];
            }
            f++;
        }

        while(s < n){
            
            nums[s++] = 0;
            
        }
    }

    // if (i > start && nums[i] == nums[i - 1]) continue; move duplicate 去重永远是：检测当前元素是否和“同层”前一个一样。


    
}


class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }

}
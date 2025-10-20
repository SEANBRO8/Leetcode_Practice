class Solution{

    public void reverseString(char[] s){
        // TC: n / 2 SC: n /2
        int n = s.length;
        int start = 0, end = s.length - 1;

        while(start < n /2){

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }


}

class Solution{

    public String longestPalindrome(String str){

        String ans = "";

        int n = str.length();
        // set i as the center
        for(int i = 0; i < n ; i++){
            String s1 = isPalindrome(str, i, i);
            String s2 = isPalindrome(str, i, i + 1);

            if(ans.length() < s1.length()) ans = s1;
            if(ans.length() < s2.length()) ans = s2;
        }
        return ans;

    }

    public String isPalindrome(String str, int left, int right){
        int n = str.length();
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }

        return str.substring(left + 1, right);

    }


    // public String longestPalindromicSubString(String str){
        
    //     // TC: N * N * N SC :1
    //     if(str == null || str.length() == 0) return "";
    //     String ans = str.substring(0,1);
    //     int n = str.length();
        
        
    //     for(int i = 0; i < n; i++){
    //         for(int j = i + 1; j <= n; j++){
    //             String temp = str.substring(i, j);
    //             if(isPalindromic(temp) && temp.length() > ans.length()){
    //                 ans = temp;
    //             }
    //         }
    //     }

    //     return ans;


    // }

    // public boolean isPalindromic(String str){

    //     int left = 0, n = str.length(), right = str.length()-1;

    //     while(left < n /2){

    //         if(str.charAt(left++) != str.charAt(right--)){
    //             return false;
    //         }
    //     }

    //     return true;


    // }

}

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) return 1;

        int res = 1;  
        int ans = 1;  
        int flag = 0;  

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1] && flag == 0) {
                ans++;  
                flag = 1;  
            } else if (arr[i] > arr[i + 1] && flag == 1) {
                ans++; 
                flag = 0;  
            } else {
                res = Math.max(res, ans); 
                ans = (arr[i] != arr[i + 1]) ? 2 : 1; 
                flag = (arr[i] < arr[i + 1]) ? 1 : 0;  
            }
        }
        res = Math.max(res, ans);  

        ans = 1; 
        flag = 0;  

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1] && flag == 0) {
                ans++; 
                flag = 1;  
            } else if (arr[i] < arr[i + 1] && flag == 1) {
                ans++;  
                flag = 0; 
            } else {
                res = Math.max(res, ans);  
                ans = (arr[i] != arr[i + 1]) ? 2 : 1;  
                flag = (arr[i] > arr[i + 1]) ? 1 : 0; 
            }
        }
        res = Math.max(res, ans); 

        return res;
    }
}

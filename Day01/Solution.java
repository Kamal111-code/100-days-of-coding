class Solution {

  //Sliding window Approach
    public int lengthOfLongestSubstring(String s) {
         
       
            int maxLen=0;

            int l =0,r=0;
        
            Map<Character,Integer> map=new HashMap<>();
            while(r<s.length()){
                map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);

                        if(map.size()==r-l+1){
                            maxLen=Math.max(maxLen,r-l+1);
                            r++;
                        }else if(map.size()<r-l+1){
                            while(map.size()<r-l+1){
                                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                                if(map.get(s.charAt(l))==0){
                                    map.remove(s.charAt(l));
                                }
                                l++; 
                        }
                    r++;
                }
                
            }
        return maxLen;
    
    }
}

        
    


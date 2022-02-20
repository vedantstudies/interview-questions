// Mock Interview link : https://www.youtube.com/watch?v=rw4s4M3hFfs
// Time Complexity: O(BlockLength * ReqsLength)
// Space Complexity: O(BlockLength * ReqsLength)

public class Main {
    public static void main(String[] args) {
        
        boolean[][] blocks = {{false, true, false},
                             {true, false, false},
                             {true, true, false},
                              {false, true, false},
                             {false, true, true}};
        
        String[] reqs = {"gym", "school", "store"};
        
        // int gymDist = 0, schoolDist = 0, 
        
        List<List<Integer>> dp = new ArrayList<>();
        
        for(int i = 0; i < blocks.length; i++){
            List<Integer> temp = new ArrayList<>();
            
            for(int j = 0; j < reqs.length; j++) temp.add(Integer.MAX_VALUE);
            dp.add(temp);
        }
        
        for(int i = 0; i < reqs.length; i++)
            if(blocks[0][i]) dp.get(0).set(i, 0);
        
          System.out.println(dp);
        System.out.println("........");
        
        for(int i = 1; i < blocks.length; i++){
            for(int j = 0; j < reqs.length; j++){
                if(blocks[i][j])
                    dp.get(i).set(j, 0);
                else{
                    if(dp.get(i - 1).get(j) != Integer.MAX_VALUE)
                        dp.get(i).set(j,Math.min( dp.get(i).get(j),  dp.get(i - 1).get(j) + 1));
                }
                
            }
        }
    System.out.println(dp);
        System.out.println("........");
    
     for(int i = blocks.length - 2; i >= 0; i--){ 
            for(int j = 0; j < reqs.length; j++){
                if(blocks[i][j])
                    dp.get(i).set(j, 0);
                else{
                    if(dp.get(i + 1).get(j) != Integer.MAX_VALUE)
                        dp.get(i).set(j, Math.min( dp.get(i).get(j),  dp.get(i + 1).get(j) + 1));
                }
                
            }
        }
        
        System.out.println(dp);
        System.out.println("........");
        
        List<Integer> maxDists = new ArrayList<>();
        
        for(List<Integer> i: dp){
            maxDists.add(Collections.max(i));
        }
    
        int minVal = Integer.MAX_VALUE, minInd = Integer.MAX_VALUE;
    for(int i = 0; i < maxDists.size(); i++){
        if(maxDists.get(i) < minVal){
            minVal = maxDists.get(i);
            minInd = i;
        }
    }
        
        System.out.println(minInd);
    }
}

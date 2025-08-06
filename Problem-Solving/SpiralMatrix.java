import java.util.ArrayList;

class SpiralMatrix {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        int n= mat.length;
        int m = mat[0].length;
        
        
        
        int top= 0;
        int right = m -1;
        int bottom = n-1; 
        int left = 0;
        while(res.size() < m*n){
            for(int i = left; i<=right; i++){
                res.add(mat[top][i]);
          
            }
            top++;
            if(left > right || top > bottom) return res;
            for(int i = top; i<=bottom; i++){
                res.add(mat[i][right]);
           
            }
            right--;
            
            if(left > right || top > bottom) return res;
            for(int i = right; i>=left; i--) {
                res.add(mat[bottom][i]);
      
            }
            bottom--;
            
            if(left > right || top > bottom) return res;
            for(int i = bottom; i>= top; i--){
                res.add(mat[i][left]);

            }
            left++;
            if(left > right || top > bottom) return res;
            
        }   
        return res;
    }
}


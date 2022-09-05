class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int target = image[sr][sc];
        color(image, sr, sc, newColor, target);
        return image;
        
    }
    
    private void color(int[][] image, int i, int j, int newColor, int target){
        if(i>=image.length || j>=image[0].length || i<0 || j<0 || image[i][j]!=target)
            return;
        
        image[i][j] = newColor;
        
        color(image, i+1, j, newColor, target);
        color(image, i, j+1, newColor, target);
        color(image, i-1, j, newColor, target);
        color(image, i, j-1, newColor, target);
    }
}
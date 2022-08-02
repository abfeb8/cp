class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        return Arrays.stream(matrix)
            .flatMapToInt(arr -> Arrays.stream(arr))
            .sorted()
            // .peek(e -> System.out.println(e))
            .skip(k-1)
            .findFirst()
            .orElse(0);
        
        
    }
}

/*
1 3 5
2 5 7
4 6 8

1 2 
*/
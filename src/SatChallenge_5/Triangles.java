package SatChallenge_5;


/*
 * We have triangle made of blocks.
 * The topmost row has 1 block, the next row down has 2 blocks,
 * the next row has 3 blocks, and so on.
 * 
 * Compute recursively the total number of blocks in such a trangle with the given number of rows
 * 
 * triangle(0) -> 0
 * triangle(1) -> 1
 * triangle(2) -> 3
 * 
 *              1
 *            2    3
 *         4     5    6
 *      7     8    9    10
 *   11    12    13   14    15
 */

public class Triangles {
     public static void main(String[] args) {
        
        System.out.println(getTriangles(2));
     }

     public static int getTriangles(int n) {
        if(n == 0) return 0;

        return n + getTriangles(n - 1);        
     }

}

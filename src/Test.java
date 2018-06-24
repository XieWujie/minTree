public class Test {
    public static void main(String[] args) {
        int[][] treeArray = new int[11][11]; //数组大小为点的数量
       treeArray[0][1] = 1;  //数组下标为点的序号，值为权
       treeArray[1][2] = 2;
       treeArray[2][3] = 3;
       treeArray[3][4] = 4;
       treeArray[4][0] = 5;
       treeArray[5][2] = 6;
       treeArray[5][6] = 7;
       treeArray[6][7] = 8;
       treeArray[7][8] = 9;
       treeArray[8][9] = 10;
       treeArray[9][10] = 11;
       treeArray[10][3] = 6;
        System.out.println("Kruskal算法");
        new MinTreeOfKruskal(treeArray).printWeight();
        System.out.println("Prim算法");
        new MinTreeOfPrim(treeArray).printWeight();
    }
}

import java.util.*;

public class MinTreeOfKruskal {
    private int[][] treeArray;
    private TreeSet<E> treeSet;  //用于对边进行排序的集合
    private HashSet<Integer> hashSet;  //不能放置重复的点
    private HashSet<E> points;      //满足条件的边集

    public MinTreeOfKruskal(int[][] treeArray) {
        this.treeArray = treeArray;
        this.treeSet = new TreeSet<>();
        hashSet = new HashSet<>();
        points = new HashSet<>();
        sort();
        addToTree();
    }

    /*
    *将数组转化到treeSet集合中，集合自动排序
     */
    private void sort(){
       for (int i = 0;i<treeArray.length;i++){
           for (int j = 0;j<treeArray[i].length;j++){
              if (treeArray[i][j]!=0){
                  treeSet.add(new E(i,j,treeArray[i][j]));
              }
           }
       }
    }

    /*
    *将边添加到树中
     */
    private void addToTree(){
    for (E e :treeSet){
        int start = e.getStartE();
        int end = e.getEndE();
            if (isHavaCircle(start,end)){  //判断新添加的边是否会与原有的边构成环
                continue;
            }else {
                if (!(points.size()==treeArray.length-1)){
                   points.add(e);
                }else {
                    return;
                }
            }
        }
        System.out.println(points.toString());
    }

    /*
    *判断新添加的边是否会与原有的边构成环
     */

    private boolean isHavaCircle(int start,int end){
        int size = hashSet.size();
        if (!hashSet.contains(start)){
            size++;
        }
        if (!hashSet.contains(end)){
            size++;
        }
        if (size == points.size()+1){
            return true;
        }else {
            hashSet.add(start);
            hashSet.add(end);
            return false;
        }
    }

    public void printWeight(){
        int weight = 0;
        for (E e:points){
            weight+=e.getWeight();
        }
        System.out.println("最小权值为"+weight);
    }
}

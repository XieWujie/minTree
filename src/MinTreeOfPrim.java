import java.util.*;

public class MinTreeOfPrim {
    private HashMap<Integer,V> vMap; //点的集合
    private int[][] treeArray;
    private HashSet<Integer> hashSet; //此集和不能添加重复的点，用于判断是否有环
    private HashSet<E> points;         //最终满足的边集

    public MinTreeOfPrim(int[][] treeArray) {
        this.treeArray = treeArray;
        points = new HashSet<>();
        vMap = new HashMap<>();
        hashSet = new HashSet<>();
        initV();
        addToTree(getBeginkey());
    }


    /*
    *将数组转化成点集
     */
    private void initV() {
        for (int i = 0; i < treeArray.length; i++) {
            for (int j = 0; j < treeArray[i].length; j++) {
                if (treeArray[i][j] != 0) {
                    V v = vMap.get(i);
                    if (v==null){
                        v = new V(i);
                    }
                   v.getEs().add(new E(i,j,treeArray[i][j]));
                    vMap.put(i,v);
                    v = vMap.get(j);
                    if (v==null){
                        v = new V(j);
                    }
                    v.getEs().add(new E(j,i,treeArray[i][j]));
                    vMap.put(j,v);
                }
            }
        }
    }

    private void addToTree(int key) {
        TreeSet<E> eTreeSet = new TreeSet<>();
        points = new HashSet<>();
        for (int i = 0; i < vMap.size() - 1; i++) { //遍历点集
            List<E> eList = vMap.get(key).getEs();
            for (E e : eList) {               //遍历点集，把边添加到待添加边的集合dTreeSet中
                if (points.contains(e)) {     //如果遇到已添加的边，则continue
                    continue;
                }
                eTreeSet.add(e); //添加到可排序的集合中自动排序
            }
            for (E e:eTreeSet) {
                int start = e.getStartE();
                int end = e.getEndE();
                if (isHavaCircle(start, end)) { //有环不满足，continue
                    continue;
                } else {
                    points.add(e);
                    key = end;                 //以添加的边的另外一点的作为key
                    eTreeSet.remove(e);        //添加的边就从待添加的边的集合中移除
                    break;                       //跳出eTreeSet遍历
                }
            }
        }
        System.out.println(points.toString());
    }

    /*
    *判断新添加的边是否与原有的边构成环
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

    /*
    *利用随机数选定开始的点
     */

    private int getBeginkey(){
       Set<Integer> set = vMap.keySet();
       Iterator<Integer> iterator = set.iterator();
       int[] keys = new int[vMap.size()];
       int i = 0;
       if (iterator.hasNext()){
           keys[i] = iterator.next();
       }
       Random random = new Random();
       int select = random.nextInt(keys.length-1);
       return keys[select];
    }

    public void printWeight(){
        int weight = 0;
        for (E e:points){
            weight+=e.getWeight();
        }
        System.out.println("最小权值为"+weight);
    }
}

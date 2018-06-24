public class E implements Comparable<E>{
    private int startE;
    private int endE;
    private int weight;

    public E(int startE, int endE, int weight) {
        this.startE = startE;
        this.endE = endE;
        this.weight = weight;
    }

    /*
    *排序规则
     */

    @Override
    public int compareTo(E e) {
        if (this.weight> e.weight){
            return 1;
        }else if (this.weight< e.weight){
            return -1;
        }else {
            if (startE> e.startE){
                return 1;
            }else if (startE< e.startE){
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return startE+"\t"+endE+"\t"+weight;
    }

    public int getStartE() {
        return startE;
    }

    public void setStartE(int startE) {
        this.startE = startE;
    }

    public int getEndE() {
        return endE;
    }

    public void setEndE(int endE) {
        this.endE = endE;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
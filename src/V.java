import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class V {
 private List<E> es;
 private int values;

  public int getValues() {
    return values;
  }

  public void setValues(int values) {
    this.values = values;
  }


  public V(int values){
    this.values = values;
    es = new ArrayList<>();
  }

  public List<E> getEs() {
    return es;
  }

  public void setEs(List<E> es) {
    this.es = es;
  }

  @Override
  public String toString() {
    return es.toString();
  }
}

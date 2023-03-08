import java.util.ArrayList;
import java.util.List;

public class Filter {

    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> list = new ArrayList<>();
        int f = 0;
        for (int i : source) {
            if (i >= treshold) {
                logger.log("Элемент " + '"' + i + '"' + " проходит");
                list.add(i);
                f++;
            } else
                logger.log("Элемент " + '"' + i + '"' + " не проходит");
        }
        logger.log("Прошло фильтр " + f + " элемента из " + source.size());
        return list;
    }
}

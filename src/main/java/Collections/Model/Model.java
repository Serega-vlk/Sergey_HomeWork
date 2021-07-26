package Collections.Model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final ImmutableArrayList<Element> list;

    public Model(){
        list = new ImmutableArrayList<>();
    }

    public void addInt(int number){
        Element element = new Element(number);
        if (list.contains(element)) list.get(list.indexOf(element)).incrementCount();
        else list.add(element);
    }

    public ImmutableArrayList<Element> getList() {
        return list;
    }

    public List<String> getAllElements(){
        List<String> list = new ArrayList<>();
        for (Element element : this.list){
            list.add(element.toString());
        }
        return list;
    }
}

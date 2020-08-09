package ArrayPractice;

import java.util.*;

public class ArrayTwo extends ArrayMain {
    private String name;
    private int number;

    //String array initialization
    public String[] stringArray = new String[]{"box", "ace", "zebra", "yard", "ice"};
    //Cast string array to list of string
    public List<String> listArray = Arrays.asList(stringArray);

    //Constructors initialization
    public ArrayTwo() {
        super("");
        String classInfo = getClass().getName();
        System.out.printf("Новый пустой экземпляр класса <%s>\n", classInfo);
    }

    public ArrayTwo(String name, int number) {
        super(name);
        this.name = name;
        this.number = number;
    }

    /**
     * @param someString set list of string
     *                   printing each element of the list with whitespace
     */
    public void returnOtherArray(List<String> someString) {
        //Create inner and result variables
        List<String> arrayInner = someString;
        ArrayList<String> resultArray = new ArrayList<String>();

        //Sort of existing array
        Collections.sort(arrayInner);

        for (String s : arrayInner) {
            resultArray.add(s);
        }
        System.out.print(resultArray + " ");
    }
}

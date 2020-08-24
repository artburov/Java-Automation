package JavaStudy;

import static JavaStudy.StaticTest.SomeStatic.myName;

public class IfStudy {
    protected int modValue;

    public static void main(String[] args) {

        IfStudy calculation = new IfStudy();

        int calculationMod = calculation.modCalculation(100, 85);
        System.out.println("The result of mod operation is " + calculationMod);

        if (calculationMod > 0) {
            System.out.println("The number \"" + calculationMod + "\" is greater than zero");
        } else {
            System.out.println("The number \"" + calculationMod + "\" is equal zero");
        }

        calculation.makeEqual(0);
        calculation.makeCycle();

        //Static method
        myName("Arthur");
    }

    //Mod operation with two integers
    public int modCalculation(int a, int b) {
        modValue = a % b;
        return modValue;
    }

    public void makeEqual(int someValue) {
        String result = (someValue > 0 ? "Yes" : someValue < 0 ? "No" : "Value equal 0");
        System.out.println(result);
    }

    public void makeCycle() {
        int iterator = 0;
        while (true) {
            iterator = iterator + 1;
            if(iterator == 3) {
                continue;
            }
            System.out.println("Value of iterator = " + iterator);
            if (iterator > 5) {
                break;
            }
        }
    }
}

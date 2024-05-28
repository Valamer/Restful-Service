package Calculator;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Arguments count must be 3");
        }
        System.out.println(doMath(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]));
    }
    public static int doMath (int numOne, int numTwo, String operator) {
        switch (operator) {
            case "+"-> {return addition(numOne, numTwo);}
            case "-"-> {return subtraction(numOne, numTwo);}
            case "/"-> {return division(numOne, numTwo);}
            case "*"-> {return multiplication(numOne, numTwo);}
            default -> {throw new IllegalArgumentException("Third argument must contain \"+\", \"-\",\"/\" or \"*\"");}
        }
    }
    private static int addition (int a, int b) {
        return a+b;
    }
    private static int subtraction (int a, int b) {
        return a-b;
    }
    private static int division (int a, int b) {
        return a/b;
    }
    private static int multiplication (int a, int b) {
        return a*b;
    }

}
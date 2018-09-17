public class Test {
    public int addInt(int a, int b){
        int sum;
        sum = a + b;
        System.out.printf("%d + %d = %d", a, b, sum);
        return sum;
    }

    public int multInt(int a, int b) {
        int product;
        product = a*b;
        System.out.printf("%d * %d = %d", a, b, product);
        return product;
    }
    public static void main(String[] args){
        System.out.println("This is the main method");
    }
}
public class ArrayStudy<stctic> {

    public static void main(String[] args) {
        workWithArray();

    }

    int[] array = new int[4];
    int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7};
    static int[] array3 = {1, 2, 3, 4};

    public static void workWithArray() {
        for (int i : array3) {
            System.out.println(i);
        }           
    }

}

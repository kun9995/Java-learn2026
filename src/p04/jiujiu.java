package p04;

public class jiujiu {
    public static void main(String[] args) {
        for (int row = 1; row <= 9; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.printf("%d×%d=%-3d", col, row, col * row);
            }
            System.out.println();
    }
}
}

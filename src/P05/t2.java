package P05;

public class t2 {
    public static void main(String[] args) {
        int []a=new int[5];
        for(int i=0;i<a.length;i++){
            a[i]=i+1;
        }
        for(int i=0;i<a.length;i++){
            System.out.print("a[" + i + "] = "+a[i]);
        }
    }
}

package P05;

import java.util.Random;

public class Arraytext3 {
    public static void main(String[] args) {
        Random r=new Random();
        int []a=new int[5];
        for(int i=0;i<a.length;i++){
            a[i]=r.nextInt(100);
            //System.out.print("a[" + i + "] = "+a[i]);
            System.out.printf("a[%d] = %d",i,a[i]);
        }
        int max=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        System.out.printf("\n max =%d",max);
        int mini=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]<mini){
                mini=a[i];
            }
        }
        System.out.printf("\n mini =%d",mini);
    }
}


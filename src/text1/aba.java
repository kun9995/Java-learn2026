import java.util.Arrays;
import java.util.Scanner;
public class aba{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double[] productions=new double[n];
        for(int i=0;i<n;i++){
            productions[i]=sc.nextDouble();
        }
        double sum=0;
        for(double p:productions){
            sum+=p;
        }
        double average=sum/n;
        int belowCount=0;
        for(double p:productions){
            if(p<average){
                belowCount++;
            }
        }
        Arrays.sort(productions);
        System.out.printf("生产平均值=%.2f%n",average);
        System.out.printf("低于平均值%2.f的车间数量=%d%n",average,belowCount);
        System.out.print(Arrays.toString(productions));
    }
}
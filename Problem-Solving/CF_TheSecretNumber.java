import java.util.*;
public class CF_TheSecretNumber {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            
            ArrayList<Long> li = new ArrayList<>();
            long pow = 1;
            for(int i = 1 ; i<=18; i++){
                pow *= 10;
                long cur = pow + 1;
                if(n % cur == 0){
                    li.add(n/cur);
                }
            }
            int l = li.size();
            if( l < 1){
                System.out.println(0);
            }else{
                Collections.sort(li);
                System.out.println(l);
                for(long a : li){
                    System.out.print(a + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

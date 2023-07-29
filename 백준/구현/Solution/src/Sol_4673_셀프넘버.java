public class Sol_4673_셀프넘버 {

    public static int dn(int n) {

        int sum = n;
        while (true) {
            sum += n % 10;
            n /= 10;
            if(n == 0){
                break;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] arr = new int[10001];

        for(int i = 1; i <= 10000; i++){
            if(dn(i) <= 10000) {
                arr[dn(i)]++;
            }
        }

        for(int i = 1; i <= 10000; i++){
            if(arr[i] == 0){
                System.out.println(i);
            }
        }
    }
}

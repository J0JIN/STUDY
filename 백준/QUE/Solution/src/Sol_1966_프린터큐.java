import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_1966_프린터큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

//        LinkedList<int[]> queue = new LinkedList<>();

        for (int t = 0; t < tc; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            LinkedList<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                // {초기 위치, 중요도}
                queue.offer(new int[] { i, sc.nextInt() });
            }

            int count = 0;

            while(!queue.isEmpty()){

                int[] front = queue.poll();// 일단 출력하고
                boolean isMax = true;

                for(int i = 0; i < queue.size(); i++){

                    if(front[1] < queue.get(i)[1]){

                        queue.offer(front);// 일단 앞에것는 뒤로 보내고
                        for(int j = 0; j< i; j++){
                            queue.offer(queue.poll());
                        }// 큰거 앞에 있는것도 다 돌려보내는 작업

                        isMax = false;
                        break;

                    }//검사해서 큰게 있으면

                }//앞에 있는거 보다 큰거 있는지 찾아보기

                if(isMax == false) {
                    continue;
                }

                count++;
                if(front[0] == M){
                    queue.clear();
                    break;
                }

            }

            System.out.println(count);

        }
    }

}

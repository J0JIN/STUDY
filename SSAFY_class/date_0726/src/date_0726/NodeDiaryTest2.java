package date_0726;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class NodeDiaryTest2 {
    public static void main(String[] args) throws IOException {
        NodeDiaryTest2 st = new NodeDiaryTest2();
        st.writeDiary();
    }

    private void writeDiary() {
        File target = new File("c:" + File.separator + "Temp" + File.separator + "diary.txt");
        try (
        		Scanner scanner = new Scanner(System.in);
                FileWriter writer = new FileWriter(target, true);
                BufferedReader reader = new BufferedReader(new FileReader(target));) {

//            System.out.println("일기를 작성합니다. 그만두려면 x를 입력하세요.");
//            writer.write("\n오늘 날짜: - " + new Date() + "\n");
//            // TODO: Scanner를 통해서 읽은 내용을 writer를 통해서 파일에 출력하시오.
//            while(true) {
//            	String str = scanner.nextLine();
//            	if(str.equals("x")) {
//            		break;
//            	}else {
//            		writer.write(str +"\n");
//            	}
//            }
//            // END
//
//            System.out.println("일기 저장 완료!!");

            // TODO: reader를 이용해 diary의 내용을 읽은 후 콘솔에 출력하시오.
            
//            char[] buffer = new char[100];
//            int read = 0;
//            
//            while((read = reader.read(buffer))>0) {
//            	System.out.println(String.valueOf(buffer,0,read));
//            }
            
        	String line = null;
            while((line = reader.readLine()) != null) {
            	System.out.println(line);
            }

            // END
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

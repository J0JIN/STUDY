package Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
    public static void main(String[] args) {
        write();
        read();
    }

    private static File target = new File("c:/Temp/objPerson.dat");

    private static void write() {
        PersonSerialization person = new PersonSerialization("홍길동2", "pass1234", "123-456", "seoul");
        // TODO: person을 target에 저장하시오.
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(target))){
        	out.writeObject(person);
        	System.out.println("저장완료");
        } catch(IOException e) {
        	e.printStackTrace();
        }
        
        // END
    }

    private static void read() {
        // TODO: target에서 person을 읽어서 내용을 출력하시오.
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(target))){
        	Object obj = in.readObject();
        	if(obj != null && obj instanceof PersonSerialization) {
        		PersonSerialization p = (PersonSerialization)obj;
               	System.out.println("복구: "+p);
        	}
        } catch(IOException e) {
        	e.printStackTrace();
        }catch(ClassNotFoundException e) {
        	e.printStackTrace();
        }
        // END
    }
}

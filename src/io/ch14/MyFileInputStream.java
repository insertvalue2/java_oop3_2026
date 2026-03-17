package io.ch14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputStream {

    public static void main(String[] args) {

        // 파일을 바이트 단위로 읽어 들이는 스트림
        FileInputStream in = null;
        int readData;

        try {
            // 다른 코드 더 있다면 ...
            in = new FileInputStream("a.txt");
            // 첫 번째 바이트 읽기
            readData = in.read();
            System.out.println("radData : " + readData);
            System.out.println("radData : " + (char)readData);
            // 두 번째 바이트 읽기
            readData = in.read();
            System.out.println("radData : " + readData);
            System.out.println("radData : " + (char)readData);
            // 세번째 바이트 읽기
            readData = in.read();
            System.out.println("radData : " + readData);
            System.out.println("radData : " + (char)readData);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        // 주의 여시거 in.close() 를 하지 않으면
        // 즉, 스트림을 닫기 않으면 파일이 계속 여린 상태로 메모리 누수가 생깁니다.
    }

}

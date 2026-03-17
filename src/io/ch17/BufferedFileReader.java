package io.ch17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReader {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(start);

        // FileReader(기반 스트림)을 BufferedReader(보조 스트림)로 감쌈
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            // read() <-- 한글자 읽는 기능
            String line;
            // readLine() : 한 줄 전체를 String 읽음
            // 반환 값이 null 이면 파일 끝
            while ( (line = br.readLine()) != null ) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        // 종료시간 - 시작시간 == 남은 시간은 (수행시간)
        System.out.println(end - start);
    }

}

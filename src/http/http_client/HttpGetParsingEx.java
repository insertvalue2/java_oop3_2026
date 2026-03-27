package http.http_client;

import com.google.gson.Gson;
import generic.ch03.Powder;
import http.http_client.dtos.Post;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpGetParsingEx {

    public static void main(String[] args) {

        // 1. HttpClient와 Gson 준비
        HttpClient client = HttpClient.newHttpClient(); // new HttpClient
        Gson gson = new Gson();

        try {
            // 2.  HTTP 요청 메세지 생성 (요청 생성)
            // HttpRequest <--- 객체를 생성해주는 녀석
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                    .GET()
                    .build();

            // 3. 응답 받기
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. 응답 내용 확인 (로깅) -> HTTP 응답 메세지가 들어 옴
            System.out.println("response : " + response);
            System.out.println("response : " + response.body());

            // 5. 파싱 처리 하기 .
            Post post = gson.fromJson(response.body(), Post.class);
            System.out.println("====파싱완료======");
            System.out.println("게시글 ID " + post.getId());
            System.out.println("작성자 ID " + post.getUserId());
            System.out.println("게시글 제목 " + post.getTitle());
            System.out.println("게시글 본문 " + post.getBody());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } // end of main
}

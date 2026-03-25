package http.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {

    public static void main(String[] args) {
        String apiKey = "서비스키입력"; // 발급받은 API 키 입력
        String city = "Busan";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + apiKey + "&units=metric&lang=kr";

        try {
            // 1. URL 객체 생성 및 연결 설정
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000); // 연결 타임아웃 5초
            conn.setReadTimeout(5000);    // 읽기 타임아웃 5초

            // 2. 응답 코드 확인 (200 OK 인지 체크)
            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                // 3. 입력 스트림을 통해 데이터 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 4. 결과 출력
                System.out.println("응답 성공!");
                System.out.println(response.toString());

            } else {
                System.out.println("호출 실패. 응답 코드: " + responseCode);
            }

            conn.disconnect();

            // 도전 문제 1  -  json 파싱 처리 및 결과 출력

            // 출력 값
            // ▶ 상태: 실 비
            // ▶ 기온: 13.99°C
            // ▶ 습도: 42%
            // ▶ 풍속: 2.1m/s

            // --- 간단한 날씨 알림 로직 ---
            // 만약 25도 보다 크다면 오늘 덥다 ~
            // ...
            // 만약 10도 이하라면 날씨가 쌀쌀합니다
            // ▶ 💡 오늘은 날씨가 따뜻하네요. 산책하기 좋아요!

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

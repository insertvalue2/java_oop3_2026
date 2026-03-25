package http.api;

import lombok.Data;

import java.util.List;

@Data
public class WeatherDTO {
    private Response response;

    @Data
    public static class Response {
        private Header header;
        private Body body;
    } // end of inner Response class

    @Data
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Data
    public static class Body {
        private String dataType;
        private Items items;
    }

    @Data
    public static class Items {
        private List<Item> item;
    }

    @Data
    public static class Item {
        private String baseDate; // 발표 일자 (YYYYMMDD)
        private String baseTime;  // 발표 시각 (HHMM)
        private String category;  // 자료 구분 코드 (예: TMP, SKY, REH)
        private String obsrValue;
        private int nx;
        private int ny;
    }

} // end of outer class

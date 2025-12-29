package kiosk;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
public class ApplicationTest {
        public static void main(String[] args) {
            // 테스트할 입력 시나리오를 문자열로 만듭니다.
            // 1(햄버거) -> 1(와퍼) -> 1(햄버거) -> 1(와퍼) -> 2(사이드) -> 1(너겟킹)
            // -> 4(장바구니) -> 2(수량조절) -> 2(너겟킹선택) -> 10(10개로변경)
            // -> 4(장바구니) -> 3(삭제) -> 1(와퍼삭제) -> 1(확인) -> 5(종료)
            String input = "1\n1\n1\n1\n2\n1\n4\n2\n2\n10\n4\n3\n1\n1\n5\n";

            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            try {
                kiosk.Application.main(new String[]{});
                System.out.println("\n>>> 테스트가 성공적으로 완료되었습니다.");
            } catch (Exception e) {
                System.out.println("\n>>> 테스트 도중 오류 발생: " + e.getMessage());
                e.printStackTrace();
            }
        }

}

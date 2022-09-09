package exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	/* 400 BAD_REQUEST : 잘못된 요청 */
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
	
	/* 404 NOT_FOUND : Resource를 찾을 수 없음 */
    URL_INFO_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 URL의 ShortLink 정보를 찾을 수 없습니다."),
    
    /* 409 NOT_FOUND : 데이터가 이미 존재합니다. */
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "데이터가 이미 존재합니다."),
    
	/* 500 INTERNAL_SERVER_ERROR : 서버 에러 */
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error"),
	;
	
    private final HttpStatus httpStatus;
    private final String detail;
	
}

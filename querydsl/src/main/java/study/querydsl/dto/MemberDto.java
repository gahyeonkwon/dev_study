package study.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

    private String username;
    private int age;

    @QueryProjection  // @QueryProjection 를 사용하면 dto 도 Q 파일로 바로 생성됨
    public MemberDto(String username, int age) {
        this.username = username;
        this.age = age;
    }



}

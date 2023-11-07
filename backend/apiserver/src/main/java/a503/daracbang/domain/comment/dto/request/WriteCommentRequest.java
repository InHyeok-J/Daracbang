package a503.daracbang.domain.comment.dto.request;

import a503.daracbang.domain.comment.entity.Comment;
import a503.daracbang.domain.diary.dto.request.WriteDiaryRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
public class WriteCommentRequest {

    @NotBlank
    @Size(min=2, max=300)
    private String content;

    @Builder
    public WriteCommentRequest(Long diaryId, String content){
        this.content = content;
    }

    public Comment toEntity(Long memberId, Long diaryId){
        return Comment.builder()
                .memberId(memberId)
                .diaryId(diaryId)
                .content(this.content)
                .build();
    }

    public WriteCommentRequest(){
    }




}
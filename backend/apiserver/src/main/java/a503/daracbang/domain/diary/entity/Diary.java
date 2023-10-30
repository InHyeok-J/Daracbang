package a503.daracbang.domain.diary.entity;

import a503.daracbang.domain.comment.entity.Comment;
import a503.daracbang.domain.member.entity.Member;
import a503.daracbang.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @Column(columnDefinition = "TEXT", length = 1000, nullable = false)
    private String content; // 내용

    @OneToMany(mappedBy = "diary", cascade = CascadeType.ALL)
    private List<Comment> comments =new ArrayList<>(); // 댓글

    @Embedded
    private Sentiment diarySentiment; // 다이어리 감정 분석

}
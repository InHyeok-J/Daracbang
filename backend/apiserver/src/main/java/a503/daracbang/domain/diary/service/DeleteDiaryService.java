package a503.daracbang.domain.diary.service;

import a503.daracbang.domain.diary.entity.Diary;
import a503.daracbang.domain.diary.exception.DiaryErrorCode;
import a503.daracbang.domain.diary.exception.DiaryNotFoundException;
import a503.daracbang.domain.diary.exception.DiaryNotWriterException;
import a503.daracbang.domain.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteDiaryService {
    private final DiaryRepository diaryRepository;

    public void deleteDiary(long memberId, long diaryId) {
        Diary diary = diaryRepository.findById(diaryId)
                // 삭제 요청받은 다이어리가 존재하지 않는 경우
                .orElseThrow(() -> new DiaryNotFoundException(DiaryErrorCode.NOTFOUND_DIARY));
        long diaryMemberId = diary.getMemberId();
        // 삭제를 요청한 멤버 아이디와 다이어리의 멤버 아이디가 다른 경우
        if(diaryMemberId!= memberId)
            throw new DiaryNotWriterException(DiaryErrorCode.NOTWRITER_DIARY);
        diaryRepository.delete(diary);
    }
}

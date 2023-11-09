package a503.daracbang.domain.diary.exception;

import a503.daracbang.global.exception.CustomException;
import a503.daracbang.global.exception.ErrorCode;

public class DiaryNotFoundException extends CustomException {
    public DiaryNotFoundException(){
        super(DiaryErrorCode.NOTFOUND_DIARY);
    }
}

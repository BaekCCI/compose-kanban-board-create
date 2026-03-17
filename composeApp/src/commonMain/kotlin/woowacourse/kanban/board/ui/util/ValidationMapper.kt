package woowacourse.kanban.board.ui.util

import woowacourse.kanban.board.domain.model.Tag
import woowacourse.kanban.board.domain.model.Tags
import woowacourse.kanban.board.domain.validator.ValidationError

fun ValidationError.toMessage(): String = when (this) {
    ValidationError.TITLE_BLANK -> "제목을 입력해주세요."
    ValidationError.TAG_INVALID_FORMAT -> "태그 형식이 올바르지 않습니다."
    ValidationError.TAG_INVALID_LENGTH -> "태그는 ${Tag.MAX_TAG_LENGTH}자 이내로 ${Tags.MAX_TAG_SIZE}개까지만 등록할 수 있습니다"
    ValidationError.TAG_COUNT_EXCEEDED -> "태그는 ${Tag.MAX_TAG_LENGTH}자 이내로 ${Tags.MAX_TAG_SIZE}개까지만 등록할 수 있습니다"
}

package woowacourse.kanban.board.ui.util

import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.error_tag_count_exceeded
import kanbanboard.composeapp.generated.resources.error_tag_invalid_format
import kanbanboard.composeapp.generated.resources.error_tag_invalid_length
import kanbanboard.composeapp.generated.resources.error_title_blank
import org.jetbrains.compose.resources.StringResource
import woowacourse.kanban.board.domain.validator.ValidationError

fun ValidationError.toMessage(): StringResource = when (this) {
    ValidationError.TITLE_BLANK -> Res.string.error_title_blank
    ValidationError.TAG_INVALID_FORMAT -> Res.string.error_tag_invalid_format
    ValidationError.TAG_INVALID_LENGTH -> Res.string.error_tag_invalid_length
    ValidationError.TAG_COUNT_EXCEEDED -> Res.string.error_tag_count_exceeded
}

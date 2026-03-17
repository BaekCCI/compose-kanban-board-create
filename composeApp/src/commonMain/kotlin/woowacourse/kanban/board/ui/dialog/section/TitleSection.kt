package woowacourse.kanban.board.ui.dialog.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.domain.validator.ValidationResult
import woowacourse.kanban.board.ui.component.Label
import woowacourse.kanban.board.ui.component.SingleLineTextField
import woowacourse.kanban.board.ui.util.toMessage

@Composable
fun TitleSection(
    modifier: Modifier = Modifier,
    value: String,
    onTitleChange: (String) -> Unit,
    validation: ValidationResult = ValidationResult.Initial,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Label(
            "제목",
            true,
        )
        SingleLineTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onTitleChange,
            isError = validation is ValidationResult.Invalid,
            errorMessage = (validation as? ValidationResult.Invalid)?.error?.toMessage(),
            placeHolderMessage = "태스크 제목을 입력하세요.",
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun TitlePreview() {
    var title by remember { mutableStateOf("") }
    TitleSection(
        value = title,
        onTitleChange = { title = it },
    )
}

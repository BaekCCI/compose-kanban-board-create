package woowacourse.kanban.board.ui.dialog.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.component.Label
import woowacourse.kanban.board.ui.component.SingleLineTextField

@Composable
fun TagSection(
    modifier: Modifier = Modifier,
    value: String,
    onTagChange: (String) -> Unit,
    errorMessage: String? = null,
    isError: Boolean = false,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Label("태그")
        SingleLineTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = { onTagChange(it) },
            isError = isError,
            errorMessage = errorMessage,
            placeHolderMessage = "태그를 쉼표로 구분하여 입력하세요 (예: 버그,긴급)",
            supportingText = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다.",
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun TagPreview() {
    TagSection(
        value = "",
        onTagChange = {},
        isError = false,
        errorMessage = null,
    )
}

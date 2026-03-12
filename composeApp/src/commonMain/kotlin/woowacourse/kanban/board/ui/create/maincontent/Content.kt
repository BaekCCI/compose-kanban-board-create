package woowacourse.kanban.board.ui.create.maincontent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.component.Label
import woowacourse.kanban.board.ui.theme.Gray
import woowacourse.kanban.board.ui.theme.Gray500
import woowacourse.kanban.board.ui.theme.Red

@Composable
fun ContentArea(
    modifier: Modifier = Modifier,
    value: String,
    onContentChange: (String) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Label("설명")
        OutlinedTextField(
            value = value,
            onValueChange =  {
                onContentChange(it)
            },
            modifier = modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "태스크에 대한 자세한 설명을 입력하세요",
                    color = Gray,
                )
            },
            minLines = 6,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                unfocusedBorderColor = Gray500,
                errorBorderColor = Red,
            ),
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun ContentPreview() {
    ContentArea(
        value = "",
        onContentChange = {}
    )
}

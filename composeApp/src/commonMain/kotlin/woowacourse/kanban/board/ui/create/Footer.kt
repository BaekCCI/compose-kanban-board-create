package woowacourse.kanban.board.ui.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.theme.Blue
import woowacourse.kanban.board.ui.theme.Gray300
import woowacourse.kanban.board.ui.theme.Gray700

@Composable
fun Footer(
    modifier: Modifier = Modifier,
    onClickCancel: () -> Unit,
    onClickConfirm: () -> Unit,
    enabled: Boolean = true,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.End),
    ) {
        CancelButton(onClickCancel = onClickCancel)
        ConfirmButton(
            onClickConfirm = onClickConfirm,
            enabled = enabled
        )
    }
}

@Composable
fun CancelButton(
    modifier: Modifier = Modifier,
    onClickCancel: () -> Unit,
    enabled: Boolean = true,
) {
    Button(
        onClick = {
            onClickCancel()
        },
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp)
    ) {
        Text(
            text = "취소",
            color = Gray700
        )
    }
}

@Composable
fun ConfirmButton(
    modifier: Modifier = Modifier,
    onClickConfirm: () -> Unit,
    enabled: Boolean = true,
) {
    Button(
        onClick = {
            onClickConfirm()
        },
        enabled = enabled,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue,
            contentColor = Color.White,
            disabledContainerColor = Gray300,
            disabledContentColor = Color.White
        ),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp)
    ) {
        Text(
            text = "생성",
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun FooterPreview() {
    Footer(
        onClickCancel = {},
        onClickConfirm = {},
    )
}

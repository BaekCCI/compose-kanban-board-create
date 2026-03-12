package woowacourse.kanban.board.ui.create

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog

@Composable
fun KanbanDialog(
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        content = {
            KanbanCreateDialogContent(
                onDismiss = onDismissRequest
            )
        }
    )
}

@Composable
@Preview(showBackground = true)
private fun KanbanDialogPreview() {
    KanbanDialog(
        onDismissRequest = {}
    )
}
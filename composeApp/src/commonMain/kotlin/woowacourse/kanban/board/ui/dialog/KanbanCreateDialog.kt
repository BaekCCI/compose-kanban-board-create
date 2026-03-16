package woowacourse.kanban.board.ui.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog

@Composable
fun KanbanCreateDialog(onDismissRequest: () -> Unit) {
    Dialog(
        onDismissRequest = onDismissRequest,
        content = {
            KanbanCreateForm(
                onDismiss = onDismissRequest,
            )
        },
    )
}

@Composable
@Preview(showBackground = true)
private fun KanbanCreateDialogPreview() {
    KanbanCreateDialog(
        onDismissRequest = {},
    )
}

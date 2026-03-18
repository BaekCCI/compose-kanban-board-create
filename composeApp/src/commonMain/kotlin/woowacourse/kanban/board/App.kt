package woowacourse.kanban.board

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import woowacourse.kanban.board.ui.dialog.TaskCreateDialog

@Composable
@Preview
fun App() {
    var showDialog by remember { mutableStateOf(false) }

    MaterialTheme {
        if (showDialog) {
            TaskCreateDialog(
                onDismissRequest = { showDialog = false },
            )
        }
        Button(
            onClick = { showDialog = true },
            content = { Text("Show dialog") },
        )
    }
}

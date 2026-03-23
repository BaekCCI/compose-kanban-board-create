package woowacourse.kanban.board.ui.board

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import woowacourse.kanban.board.domain.TaskCreator
import woowacourse.kanban.board.ui.dialog.TaskCreateDialog

@Composable
fun KanbanBoardScreen() {
    val boardState = remember { TaskBoardState() }
    var showDialog by remember { mutableStateOf(false) }
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box {
        if (showDialog) {
            TaskCreateDialog(
                onDismissRequest = { showDialog = false },
                onConfirm = { title, description, tags, status, assignee ->

                    val result =
                        TaskCreator.create(title = title, description = description, tags = tags, assignee = assignee, status = status)

                    result.onSuccess { newTask ->
                        boardState.createTask(newTask)
                        showDialog = false
                        coroutineScope.launch { snackBarHostState.showSnackbar("새로운 태스크가 추가되었습니다.") }
                    }.onFailure { exception ->
                        coroutineScope.launch { snackBarHostState.showSnackbar(exception.message ?: "오류 발생") }
                    }
                },
            )
        }
        TaskBoard(
            uiState = boardState,
            onClickCreate = { showDialog = true },
        )
        SnackbarHost(
            hostState = snackBarHostState,
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}

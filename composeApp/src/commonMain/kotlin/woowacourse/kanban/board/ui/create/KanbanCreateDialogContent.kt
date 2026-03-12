package woowacourse.kanban.board.ui.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Status
import woowacourse.kanban.board.model.User
import woowacourse.kanban.board.ui.create.maincontent.ContentArea
import woowacourse.kanban.board.ui.create.maincontent.ManagerSelector
import woowacourse.kanban.board.ui.create.maincontent.StatusSelector
import woowacourse.kanban.board.ui.create.maincontent.TagArea
import woowacourse.kanban.board.ui.create.maincontent.TitleArea

@Composable
fun KanbanCreateDialogContent(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
) {
    val managers = listOf(
        User("디노"),
        User("제임스"),
    )

    var title by remember { mutableStateOf("") }
    var isTitleError by remember { mutableStateOf(false) }

    var content by remember { mutableStateOf("") }

    var tag by remember { mutableStateOf("") }
    var isTagError by remember { mutableStateOf(false) }
    var isTagErrorMessage: String? by remember { mutableStateOf(null) }

    var status by remember { mutableStateOf(Status.TODO) }
    var selectedUser by remember { mutableStateOf(managers.first()) }

    Column(
        modifier = modifier
    ) {
        Header(
            onDismiss = onDismiss
        )
        HorizontalDivider()
        LazyColumn(
            modifier = Modifier.padding(24.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            item {
                TitleArea(
                    value = title,
                    onTitleChange = {
                        title = it
                        isTitleError = title.isBlank()
                    },
                    isError = isTitleError,
                )
            }

            item {
                ContentArea(
                    value = content,
                    onContentChange = {
                        content = it
                    },
                )
            }

            item {
                TagArea(
                    value = tag,
                    onTagChange = {
                        tag = it
                        isTagErrorMessage = validateTag(it)
                        isTagError = isTagErrorMessage != null
                    },
                    errorMessage = isTagErrorMessage,
                    isError = isTagError,
                )
            }

            item {
                StatusSelector(
                    selectedStatus = status,
                    onStatusChange = {
                        status = it
                    },
                )
            }

            item {
                ManagerSelector(
                    managers = managers,
                    selectedUser = selectedUser,
                    onUserChange = {
                        selectedUser = it
                    },
                )
            }
        }
        HorizontalDivider()
        Footer(
            onClickCancel = onDismiss,
            onClickConfirm = {
                // 나중 기능 추가
            },
            enabled = !isTitleError && title.isNotBlank() &&!isTagError,
        )
    }
}

fun validateTag(tag: String): String? {
    val formatted = tag.split(",").map { it.trim() }
    if (formatted.any { it.isBlank() }) return "태그 형식이 올바르지 않습니다."
    if (formatted.any { it.length > 5 } || formatted.size > 5) return "태그는 5자 이내로 5개까지만 등록할 수 있습니다"
    return null
}


@Composable
@Preview(showBackground = true)
fun KanbanCreateDialogContentPreview() {
    KanbanCreateDialogContent(
        onDismiss = {},
    )
}

package woowacourse.kanban.board.ui.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.domain.model.User
import woowacourse.kanban.board.ui.dialog.section.AssigneeSection
import woowacourse.kanban.board.ui.dialog.section.DescriptionSection
import woowacourse.kanban.board.ui.dialog.section.Footer
import woowacourse.kanban.board.ui.dialog.section.Header
import woowacourse.kanban.board.ui.dialog.section.StatusSection
import woowacourse.kanban.board.ui.dialog.section.TagSection
import woowacourse.kanban.board.ui.dialog.section.TaskCreateFormState
import woowacourse.kanban.board.ui.dialog.section.TitleSection

@Composable
fun TaskCreateForm(modifier: Modifier = Modifier, onDismiss: () -> Unit, assignees: List<User>) {
    val uiState = remember { TaskCreateFormState(assignees) }

    Column(
        modifier = modifier,
    ) {
        Header(
            onDismiss = onDismiss,
        )
        HorizontalDivider()
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),

        ) {
            TitleSection(
                value = uiState.title,
                onTitleChange = {
                    uiState.updateTitle(it)
                },
                validation = uiState.titleValidation,
            )

            DescriptionSection(
                value = uiState.content,
                onContentChange = {
                    uiState.updateContent(it)
                },
            )

            TagSection(
                value = uiState.tag,
                onTagChange = {
                    uiState.updateTag(it)
                },
                validation = uiState.tagValidation,
            )

            StatusSection(
                selectedStatus = uiState.selectedStatus,
                onStatusChange = {
                    uiState.updateStatus(it)
                },
            )

            AssigneeSection(
                managers = uiState.assignees,
                selectedUser = uiState.selectedAssignee,
                onUserChange = {
                    uiState.updateAssignee(it)
                },
            )
        }
        HorizontalDivider()
        Footer(
            onClickCancel = onDismiss,
            onClickConfirm = {
                // TODO: 생성 기능 추가
            },
            enabled = uiState.canCreate,
        )
    }
}

// TODO: 삭제
fun validateTag(tag: String): String? {
    val formatted = tag.split(",").map { it.trim() }
    if (formatted.any { it.isBlank() }) return "태그 형식이 올바르지 않습니다."
    if (formatted.any { it.length > 5 } || formatted.size > 5) return "태그는 5자 이내로 5개까지만 등록할 수 있습니다"
    return null
}

@Composable
@Preview(showBackground = true)
fun TaskCreateFormPreview() {
    TaskCreateForm(
        onDismiss = {},
        assignees = listOf(User("다이노"), User("다이노소어"), User("우우우")),
    )
}

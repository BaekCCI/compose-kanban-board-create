package woowacourse.kanban.board.ui.dialog.section

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import woowacourse.kanban.board.domain.model.Status
import woowacourse.kanban.board.domain.model.User
import woowacourse.kanban.board.domain.validator.TaskValidator
import woowacourse.kanban.board.domain.validator.ValidationResult

class TaskCreateFormState(val assignees: List<User>) {
    var title by mutableStateOf("")
    var titleValidation: ValidationResult by mutableStateOf(ValidationResult.Initial)

    var content by mutableStateOf("")

    var tag by mutableStateOf("")
    var tagValidation: ValidationResult by mutableStateOf(ValidationResult.Initial)

    var selectedStatus by mutableStateOf(Status.TODO)
    var selectedAssignee by mutableStateOf(assignees.first())

    val canCreate get() = titleValidation is ValidationResult.Valid && tagValidation !is ValidationResult.Invalid

    fun updateTitle(input: String) {
        title = input
        titleValidation = TaskValidator.validateTitle(input)
    }

    fun updateContent(input: String) {
        content = input
    }

    fun updateTag(input: String) {
        tag = input
        tagValidation = TaskValidator.validateTags(input)
    }

    fun updateAssignee(user: User) {
        selectedAssignee = user
    }

    fun updateStatus(status: Status) {
        this.selectedStatus = status
    }
}

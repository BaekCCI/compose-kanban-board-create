package woowacourse.kanban.board.domain.model

enum class Status(val label: String) {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done"),
}

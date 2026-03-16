package woowacourse.kanban.board.model

data class Card(val title: String, val description: String? = null, val tags: Tags, val user: User, val status: Status) {
    init {
        require(title.isBlank()) { "제목이 비어있습니다." }
    }
}

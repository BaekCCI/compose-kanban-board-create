package woowacourse.kanban.board.create

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.ui.create.maincontent.TitleArea
import kotlin.test.Test


@OptIn(ExperimentalTestApi::class)
class TitleTextFieldTest {

    @Test
    fun `제목 입력 후 모든 문구 삭제 시 에러 문구 표시`() = runComposeUiTest {
        setContent {
            var title by remember { mutableStateOf("") }
            var isTitleError by remember { mutableStateOf(false) }

            TitleArea(
                value = title,
                onTitleChange = {
                    title = it
                    isTitleError = title.isBlank()
                },
                isError = isTitleError,
            )
        }

        onNodeWithText("제목을 입력해주세요.", useUnmergedTree = true)
            .assertDoesNotExist()

        onNode(hasSetTextAction())
            .performTextInput("할 일")

        onNode(hasSetTextAction())
            .performTextClearance()

        onNodeWithText("제목을 입력해주세요.", useUnmergedTree = true)
            .assertExists()
    }
}
package woowacourse.kanban.board.ui.create.maincontent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.User
import woowacourse.kanban.board.ui.UserProfile
import woowacourse.kanban.board.ui.component.Label

@Composable
fun ManagerSelector(
    modifier: Modifier = Modifier,
    managers: List<User>,
    selectedUser: User,
    onUserChange: (User) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Label("담당자", true)
        managers.chunked(3).forEach { users->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                users.forEach { manager ->
                    ManagerChip(
                        managers = manager,
                        selectedUser = manager == selectedUser,
                        onUserChange = { onUserChange(manager) },
                        modifier = Modifier.weight(1f),
                    )
                }
                repeat(3-users.size){
                    Spacer(modifier= Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun ManagerChip(
    managers: User,
    selectedUser: Boolean,
    onUserChange: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FilterChip(
        selected = selectedUser,
        onClick = onUserChange,
        label = {
            UserProfile(user = managers, Modifier.padding(vertical = 16.dp))
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = Color(0xffEFF6FF),
            selectedLabelColor = Color(0xff1447E6),
        ),
        modifier = modifier,
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = selectedUser,
            borderColor = Color.Gray,
            selectedBorderColor = Color.Blue,
            borderWidth = 1.dp,
            selectedBorderWidth = 1.dp,
        ),
    )
}

@Composable
@Preview(showBackground = true)
private fun ManagerPreview() {
    var selectedUser by remember { mutableStateOf(User("디노")) }

    val managers = listOf(
        User("디노"),
        User("제임스"),
        User("로미"),
        User("로미"),
        User("로미")
    )

    ManagerSelector(
        managers = managers,
        selectedUser = selectedUser,
        onUserChange = { },
    )
}

@Composable
@Preview(showBackground = true)
private fun ManagerChipPreview() {
    ManagerChip(
        managers = User("김철수"),
        selectedUser = true,
        onUserChange = {},
    )
}

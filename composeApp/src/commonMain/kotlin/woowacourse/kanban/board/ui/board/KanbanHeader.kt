package woowacourse.kanban.board.ui.board

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.ui.theme.Purple

@Composable
fun KanbanHeader(
    modifier: Modifier = Modifier,
    onClickCreate: () -> Unit = {},
    totalCount: Int,
    completeCount: Int,
    completeRatio: Float,
) {
    Column(
        modifier = modifier.fillMaxWidth().background(Color.White).border(width = 1.dp, color = Color(0xffE5E7EB))
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(text = "Compose Desktop 칸반 보드", color = Color(0xff101828), fontSize = 24.sp, fontWeight = FontWeight.Medium)
                Text("완료율: ${(completeRatio * 100).toInt()}% ($completeCount/$totalCount)")
            }

            Button(
                modifier = modifier,
                onClick = {
                    onClickCreate()
                },
                enabled = true,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple,
                    contentColor = Color.White,
                ),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add",
                )
                Text(
                    text = "새 태스크 생성",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
        KanbanProgressBar(completeRatio = completeRatio)
    }
}

@Composable
fun KanbanProgressBar(
    modifier: Modifier = Modifier,
    completeRatio: Float
) {
    LinearProgressIndicator(
        progress = { completeRatio },
        modifier = modifier
            .fillMaxWidth()
            .height(8.dp),
        color = Color(0xFF4F39F6),
        trackColor = Color(0xffE5E7EB),
        drawStopIndicator = {},
        gapSize = 0.dp,
    )
}

@Preview(showBackground = true, widthDp = 800)
@Composable
fun KanbanHeaderPreview() {
    KanbanHeader(
        totalCount = 30,
        completeCount = 20,
        completeRatio = 0.6f,
    )
}

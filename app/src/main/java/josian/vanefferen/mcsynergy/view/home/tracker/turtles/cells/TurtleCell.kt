package josian.vanefferen.mcsynergy.view.home.tracker.turtles.cells

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.SmartToy
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TurtleCell(

) {
    Row(modifier = Modifier
        .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Outlined.SmartToy,
            contentDescription = "Turtle Icon",
            tint = Color.White
        )

        Column {
            Row {
                Text(text = "Placeholder Turtle", color = Color.White)
                Text(text = "#69")
                Spacer(modifier = Modifier.fillMaxWidth())
            }
            Divider()

        }
    }
}
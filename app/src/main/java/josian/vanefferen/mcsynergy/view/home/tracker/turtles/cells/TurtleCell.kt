package josian.vanefferen.mcsynergy.view.home.tracker.turtles.cells

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SmartToy
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun TurtleCell(

) {
    Column(modifier = Modifier
        //.background(MaterialTheme.colorScheme.surface)
        .padding(top = 10.dp)
        .padding(horizontal = 10.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.SmartToy,
                contentDescription = "Turtle Icon",
                modifier = Modifier.size(40.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Placeholder Turtle", color = Color.White, fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "#69", color = Color.Gray)
                    Spacer(modifier = Modifier.fillMaxWidth())
                }
                Divider(modifier = Modifier.padding(vertical = 10.dp))

                Row {
                    Column {
                        Text(text = "Status", color = Color.Gray, fontSize = 15.sp)
                        Text(text = "Farming", color = Color.White, fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.width(30.dp))

                    Column {
                        Text(text = "Location", color = Color.Gray, fontSize = 15.sp)
                        Text(text = "9999/9999/9999", color = Color.White, fontSize = 20.sp)
                    }
                }

            }
        }
        LinearProgressIndicator(progress = 0.5f, modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
            color = Color.Green,
            trackColor = Color.DarkGray
        )
        Divider(modifier = Modifier.padding(top = 10.dp))
    }

}
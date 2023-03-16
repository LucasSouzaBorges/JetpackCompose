package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Surface
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.border
import androidx.compose.material.MaterialTheme
import android.content.res.Configuration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Text("Hello world!")
            Surface(modifier = Modifier.fillMaxSize()) {

                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }
}


data class Message(val author: String, val body: String)

@Composable
//fun MessageCard(name: String){
fun MessageCard(msg: com.example.composetutorial.Message) {
    //Text(text = "Hello $name!")
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                // Modifica o tamanho da imagem para 40 dp(pixel)
                .size(40.dp)
                // Modifica o formato da imagem para um aspecto circular
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        // Adiciona um espaço horizontal entre a imagem e a coluna
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2)
            // Adiciona um espaço vertical entre o autor e a mensagem de texto
            Spacer(modifier = Modifier.height(4.dp))
            
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2)
            }
        }
    }
}
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme() {
        Surface {
            MessageCard(msg = com.example.composetutorial.Message("Lucas", "Não se esqueça de estudar para a prova!"))
        }
    }
}
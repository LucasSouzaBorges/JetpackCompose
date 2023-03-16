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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Text("Hello world!")
            MessageCard(Message("Android", "Jetpack Compose"))
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
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Modifica o tamanho da imagem para 40 dp(pixel)
                .size(40.dp)
                // Modifica o formato da imagem para um aspecto circular
                .clip(CircleShape)
        )
        // Adiciona um espaço horizontal entre a imagem e a coluna
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = msg.author)
            // Adiciona um espaço vertical entre o autor e a mensagem de texto
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(msg = com.example.composetutorial.Message("Lucas", "Não se esqueça de estudar para a prova!"))
}
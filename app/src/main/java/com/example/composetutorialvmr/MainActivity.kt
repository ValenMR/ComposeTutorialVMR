package com.example.composetutorialvmr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorialvmr.ui.theme.ComposeTutorialVMRTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    //Añadiendo relleno alrededor de nuestro mensaje
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Tamaño de la imagen en 40 dp
                .size(40.dp)
                // poner la imagen en forman de círculo
                .clip(CircleShape)
        )

        // Añadiendo espacio horizontal entre la imagen y la column
        Spacer(modifier = Modifier.width(8.dp))

        Column{
            Text(text = msg.author)
            // Añadiendo espacio vertical entre el author y el message text
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }


}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(
        msg = Message("VALENTINA MR", "Hey, take a look at Jetpack Compose, it's great!")
    )

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTutorialVMRTheme {
        Greeting("Android")
    }
}
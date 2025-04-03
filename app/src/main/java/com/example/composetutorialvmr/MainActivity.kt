package com.example.composetutorialvmr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorialvmr.ui.theme.ComposeTutorialVMRTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource

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
    Row{
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture"
        )
        Column{
            Text(text = msg.author)
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
package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                EditTextAndList()
            }
        }
    }
}

@Composable
fun EditTextAndList(modifier: Modifier = Modifier) {
    var name by remember {
        mutableStateOf("")
    }

    var names by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { text -> name = text },
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = {
                if (name.isNotBlank()) {
                    names = names + name
                }
                name = ""
            }) {
                Text(
                    text = "Add to list"
                )
            }
        }

        LazyColumn {
            items(names) { currentName ->
                Text(
                    text = currentName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Divider()
            }
        }
    }
}

@Composable
fun State() {
    var count by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = count.toString(),
            fontSize = 40.sp
        )

        Button(onClick = {
            count += 2
        }) {
            Text(text = "Increase counter: $count")
        }

        Button(
            onClick = { count = 0 },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
        ) {
            Text(text = "Reset", color = Color.Green)
        }
    }
}

@Composable
fun List(name: String, modifier: Modifier = Modifier) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(14) { i ->

            Icon(
                imageVector = Icons.Default.Star, contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
        }
    }

    LazyRow {
        items(10) {
            Image(
                painter = painterResource(R.drawable.me), contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }
    }

}

@Composable
fun Images(name: String, modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(R.drawable.me),
        contentDescription = null,
        modifier = Modifier.background(Color.Red),
    )

    //Icon is same as image, but only for vectors
    Icon(imageVector = Icons.Default.Star, contentDescription = "")

    Column {
        for (i in 1..5) {

            Icon(imageVector = Icons.Default.Star, contentDescription = "")
        }
    }

}

@Composable
fun ComposeLayouts(name: String, modifier: Modifier = Modifier) {

    Column(
        modifier
            .background(Color.Black)
            .fillMaxSize(),
        //.size(500.dp),
        //.fillMaxHeight()
        //.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Hi $name!",
            color = Color.Magenta,
            fontSize = 22.sp

        )

        Text(
            text = "Hi $name!",
            color = Color.Magenta,
            fontSize = 22.sp

        )

        // Image(painter = Painter().)
    }

    Box(
        modifier
            .background(Color.Black)
            .fillMaxSize(),
        //.size(500.dp),
        //.fillMaxHeight()
        //.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "Hi $name!",
            color = Color.Magenta,
            fontSize = 22.sp,

            modifier = Modifier.align(Alignment.TopEnd)

        )

        Text(
            text = "Hi $name! Ileka",
            color = Color.Magenta,
            fontSize = 22.sp

        )

        // Image(painter = Painter().)
    }

    Row(
        modifier
            .background(Color.Black)
            .fillMaxSize(),
        //.size(500.dp),
        //.fillMaxHeight()
        //.fillMaxWidth(),
    ) {

        Text(
            text = "Hi $name!",
            color = Color.Magenta,
            fontSize = 22.sp

        )

        Text(
            text = "Hi $name!",
            color = Color.Magenta,
            fontSize = 22.sp

        )

    }

}

@Composable
fun SampleTextWithModifier(name: String) {

    Text(
        text = "Hello $name!",
        color = Color.Magenta,
        fontSize = 22.sp,
        modifier = Modifier
            .background(Color.Blue)
            .padding(10.dp, 20.dp, 14.dp, 16.dp)
            .background(Color.Green)

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTheme {
        EditTextAndList()
    }
}
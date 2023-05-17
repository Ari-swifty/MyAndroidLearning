package com.arigarasuthan.composedemoapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arigarasuthan.composedemoapp.ui.theme.ComposeDemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //BoxExample1()
            //BoxExample2()
            //BoxExample3()
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                ButtonDemo()
            }
        }
    }
}

@Composable
fun BoxExample1() {
    Box(
        modifier = Modifier
            .background(color = Color.Green)
            .size(180.dp, 300.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Yellow)
                .size(125.dp, 100.dp)
                .align(Alignment.TopEnd)
        ) {

        }

        Text(
            text = "Hi",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .background(color = Color.White)
                .size(90.dp, 50.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BoxExample2() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        Text(
            text = "Top Start",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopStart)
        )
        Text(
            text = "Top Center",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopCenter)
        )
        Text(
            text = "Top End",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopEnd)
        )
        Text(
            text = "Center Start",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.CenterStart)
        )
        Text(
            text = "Center",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.Center)
        )
        Text(
            text = "Center End",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.CenterEnd)
        )
        Text(
            text = "Bottom Start",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.BottomStart)
        )
        Text(
            text = "Bottom Center",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.BottomCenter)
        )
        Text(
            text = "Bottom End",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun BoxExample3() {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.beach_resort),
            contentDescription = "beach resort"
        )

        Text(
            text = "Beach Resort",
            style = MaterialTheme.typography.h4,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.BottomStart)
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.White,
                contentColor = Color.DarkGray
            ),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .border(5.dp, Color.DarkGray, RectangleShape)
        ) {
            Text(text = "Add to Cart")
        }
    }
}

@Composable
fun ButtonDemo() {
    val context = LocalContext.current
    Button(onClick = {
        Toast.makeText(context, "Clicked on a Button", Toast.LENGTH_LONG).show()
    }) {
        Text(text = "Add to Cart")

    }
    Button(
        onClick = {
            Toast.makeText(context, "Clicked on a Button", Toast.LENGTH_LONG).show()
        },
        enabled = false
    ) {
        Text(text = "Add to Cart")
    }

    TextButton(onClick = {
        Toast.makeText(context, "Clicked on a Text Button", Toast.LENGTH_LONG).show()
    }) {
        Text(text = "Add to Cart")

    }

    OutlinedButton(onClick = {
        Toast.makeText(context, "Clicked on a Outlined Button", Toast.LENGTH_LONG).show()
    }) {
        Text(text = "Add to Cart")

    }

    IconButton(onClick = {
        Toast.makeText(context, "Clicked on a Icon Button", Toast.LENGTH_LONG).show()
    }) {
        Icon(
            Icons.Filled.Refresh,
            contentDescription = "Refresh Button",
            tint = Color.DarkGray,
            modifier = Modifier.size(80.dp)
        )
    }

    Button(
        onClick = {
            Toast.makeText(context, "Clicked on a Button", Toast.LENGTH_LONG).show()
        },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp,Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
        ) {
        Text(
            text = "Add to Cart",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .padding(5.dp)
        )

    }

    Button(
        onClick = {
            Toast.makeText(context, "Clicked on a Button", Toast.LENGTH_LONG).show()
        },
        shape = CutCornerShape(10.dp),
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp,Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Add to Cart",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .padding(5.dp)
        )

    }

    Button(
        onClick = {
            Toast.makeText(context, "Clicked on a Button", Toast.LENGTH_LONG).show()
        },
        shape = CircleShape,
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp,Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Add to Cart",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .padding(5.dp)
        )

    }


}




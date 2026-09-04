package com.example.bienvenidoalcurso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

@Composable
fun BusinessCardApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFD2E8D4)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(1.dp))

            HeaderSection()

            ContactSection()
        }
    }
}

@Composable
fun HeaderSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color(0xFF073042)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Android,
                contentDescription = "Logo Android",
                tint = Color(0xFF3DDC84),
                modifier = Modifier.size(80.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Jennifer Doe",
            fontSize = 44.sp,
            fontWeight = FontWeight.Light,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006D3B)
        )
    }
}

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier.padding(bottom = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ContactRow(
            icon = Icons.Default.Phone,
            text = "+11 (123) 444 555 666"
        )
        ContactRow(
            icon = Icons.Default.Share,
            text = "@AndroidDev"
        )
        ContactRow(
            icon = Icons.Default.Email,
            text = "jen.doe@android.com"
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006D3B),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(24.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color(0xFF101D13)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEjercicio8() {
    BienvenidoAlCursoTheme {
        BusinessCardApp()
    }
}

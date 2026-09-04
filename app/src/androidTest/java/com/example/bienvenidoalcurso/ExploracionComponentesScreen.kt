package com.example.bienvenidoalcurso

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class, ExperimentalFoundationApi::class)
@Composable
fun ExploracionComponentesScreen() {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exploración de Componentes") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio") },
                    selected = true,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    label = { Text("Perfil") },
                    selected = false,
                    onClick = {}
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Mostrar Dialog")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(
                tonalElevation = 4.dp,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Contenedor Surface con Elevación",
                    modifier = Modifier.padding(16.dp)
                )
            }

            Text("LazyRow y FilterChip:", style = MaterialTheme.typography.titleMedium)
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(5) { index ->
                    FilterChip(
                        selected = index == 0,
                        onClick = {},
                        label = { Text("Chip $index") }
                    )
                }
            }

            Text("FlowRow:", style = MaterialTheme.typography.titleMedium)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(6) { index ->
                    AssistChip(
                        onClick = {},
                        label = { Text("Etiqueta $index") }
                    )
                }
            }

            HorizontalDivider()

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    var textValue by remember { mutableStateOf("") }
                    var checkedState by remember { mutableStateOf(true) }
                    var radioSelected by remember { mutableIntStateOf(0) }
                    var sliderValue by remember { mutableFloatStateOf(0.5f) }

                    OutlinedTextField(
                        value = textValue,
                        onValueChange = { textValue = it },
                        label = { Text("OutlinedTextField") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = checkedState,
                            onCheckedChange = { checkedState = it }
                        )
                        Text("Checkbox")
                        Spacer(modifier = Modifier.width(16.dp))
                        Switch(
                            checked = checkedState,
                            onCheckedChange = { checkedState = it }
                        )
                        Text("Switch")
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = radioSelected == 0,
                            onClick = { radioSelected = 0 }
                        )
                        Text("Opción 1")
                        RadioButton(
                            selected = radioSelected == 1,
                            onClick = { radioSelected = 1 }
                        )
                        Text("Opción 2")
                    }

                    Text("Slider: ${(sliderValue * 100).toInt()}%")
                    Slider(
                        value = sliderValue,
                        onValueChange = { sliderValue = it }
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(modifier = Modifier.size(32.dp))
                        LinearProgressIndicator(modifier = Modifier.weight(1f))
                    }

                    Icon(
                        imageVector = Icons.Default.School,
                        contentDescription = "Icono Escuela",
                        modifier = Modifier.size(48.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            HorizontalDivider()

            Text("TabRow y Pager:", style = MaterialTheme.typography.titleMedium)
            var selectedTab by remember { mutableIntStateOf(0) }
            TabRow(selectedTabIndex = selectedTab) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = { Text("Pestaña 1") }
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = { Text("Pestaña 2") }
                )
            }

            val pagerState = rememberPagerState(pageCount = { 2 })
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.height(80.dp)
            ) { page ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(if (page == 0) Color.LightGray else Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Vista Pager Página $page")
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("AlertDialog") },
            text = { Text("Este es un mensaje dentro de un diálogo emergente.") },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Aceptar")
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEjercicio7() {
    BienvenidoAlCursoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ExploracionComponentesScreen()
        }
    }
}
package com.example.learnacourse.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnACourse() {

    val courseList = remember {
        mutableStateListOf<String>()
    }

    var textValue  by  remember {
        mutableStateOf("")
    }

  Column(
      modifier = Modifier
          .fillMaxSize(1f)
          .padding(start = 6.dp, end = 6.dp)
  ) {

      Text(
          text = "List of Courses",
          modifier = Modifier.padding(top = 16.dp)
      )

      Spacer(modifier = Modifier.padding(8.dp))

     Row() {
         OutlinedTextField(
             value = textValue,
             onValueChange = { newTextValue ->
                 textValue =newTextValue

             } )
         OutlinedButton(
             onClick = {
             if (textValue.isNotEmpty()){
                 courseList.add(textValue)
             }
                 textValue =""
             })
         {
             Text(text = "ADD")
             
         }
     }

      Spacer(modifier = Modifier.padding(6.dp))
      LearnACourseList(courseList)
  }
}

@Preview
@Composable
fun LearnACoursePreview() {
    LearnACourse()
}


@Composable
fun LearnACourseList(courseTitle:List<String>) {

    LazyColumn(){

        items(courseTitle){ course ->
            CourseCard(course)

        }
    }
}

@Composable
fun CourseCard(courseTitle: String) {

    OutlinedCard() {
        Text(
            text = courseTitle,
            modifier = Modifier.padding(8.dp)

        )
    }
}
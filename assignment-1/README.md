# Assignment 1
**Due by 11:59pm on Monday, 4/24/2017**

**Demo due by 11:59pm on Monday, 5/8/2017**

In this assignment, we'll get our toes wet in the pond of Android development by writing the simple beginnings of weather app.  To do this, we'll start working with `RecyclerView`, which is the best way to write efficient and scalable dynamic user interfaces. The parts of the assignment are outlined below.

## 1. Sign up for Piazza

Use this link to sign up for the CS 496 Piazza with your ONID email address: https://piazza.com/oregonstate/spring2017/cs496.

We'll be using Piazza in this course for Q&A because it's geared towards students helping other students with the class.  Anyone can post or answer a question on Piazza, even anonymously, and the instructor and TAs can revise and endorse student answers, which means you can be confident in the quality of the response.

You are *strongly encouraged* to post any class-related questions to Piazza first instead of emailing the instructor or TAs.  You should also get in the habit of checking in to Piazza to answer other students' questions.  This will not only enable everyone to get help quickly, but it will also help you improve your understanding of the material, since teaching someone else is the best way to learn something.

As an incentive to use Piazza, extra credit will be awarded to the most active Piazza participants at the end of the class.

## 2. Write a basic app to display dummy weather data

This repository contains an initial template for an Android app.  Currently, the app contains one empty action.  Your job in this assignment is to modify this activity as follows:

  * Create an array of `String` objects and initialize it with some dummy weather forecast data.  Each string can look something like this:
    ```
    Wed April 12 - Sunny and Warm - 75F
    ```
    It's not super important how many weather strings you create, but it should be enough that, if you printed all of the strings on the screen (with some whitespace between), you'd have to scroll to see them all.

  * Use `RecyclerView` to display the strings in your weather forecast data array in a vertical list on the screen.  To accomplish this, you'll need to do the following:
    * Add a `RecyclerView` widget to the main activity's layout.
    * Create a new layout to represent a single day's weather forecast.  This can be simple, containing only a `TextView` to hold the weather forecast string.  You can also add a `View` to create a border between elements in the list.
    * Write a class that extends `RecyclerView.Adapter`.  Within this class, you will:
      * Implement an inner class that extends `RecyclerView.ViewHolder`.  Objects of this class will represent individual items in your forecast list.
      * Write methods to bind weather forecast strings from your array to your view holder objects.  These methods will be used to make sure the list stays up to date as the user scrolls.
    * Within your main activity's `onCreate()` method, create a new layout manager and connect it to the `RecyclerView`, and create a new object of your adapter class and attach that to the `RecyclerView`.

To approach this problem, it might make sense to first just get your weather forecast strings to display and scroll on the screen without the `RecyclerView`.  Then, once you get that working, start working on implementing the `RecyclerView`.

## Extra credit

For extra credit, you can start to handle user clicks:

  * Create a second array of `String` objects of the same length as your dummy forecast data array.  In this array, you should add slightly more detailed dummy weather forecast data matching the data in the first array.  The idea here is that these strings will be the detailed forecasts corresponding to the brief forecasts in the first array.  For example, a more detailed string corresponding to the one above might look like this:
    ```
    Cloudless and generally warm, with a high of 75F and a low of 57F.  Some high clouds late in the day.
    ```

  * Modify your main activity and adapter class so that, when the user clicks on one of the weather forecast elements in your list, a `Toast` containing the corresponding detailed forecast is displayed.  Make sure to implement this so that you cancel any existing `Toast` before displaying a new one each time the user clicks.

## Submission

We'll be using GitHub Classroom for this assignment, and you will submit your assignment via GitHub.  Make sure your completed files are committed and pushed by the assignment's deadline to the master branch of the GitHub repo that was created for you by GitHub Classroom.  A good way to check whether your files are safely submitted is to look at the master branch your assignment repo on the github.com website (i.e. github.com/OSU-CS496-Sp2017/assignment-1-YourGitHubUsername/). If your changes show up there, you can consider your files submitted.

## Grading criteria

The assignment is worth 100 total points, broken down as follows:

  * 30 points: Signed up for Piazza

  * 70 points: Implemented the basic weather app
    * 20 points: displays scrollable dummy weather forecast data on screen
    * 50 points: uses `RecyclerView` to display dummy forecast data

  * Extra credit: 20 points for successfully displaying detailed weather forecast in a `Toast` in response to user clicks.

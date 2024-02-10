# Khabar - News Application
![image](https://github.com/criticalAY/Khabar/assets/48384865/07e36494-32b6-49e1-a7ba-21806b536a9a)


## Description
This is a News Application built using Jetpack Compose, Retrofit, Coil, and Timber libraries. The application fetches data from an API to display news articles in various categories such as technology, entertainment, and top news. Images associated with the articles are rendered using the Coil library, and Timber is used for logging purposes.

## Features
- Displays news articles in different categories: technology, entertainment, and top news.
- Fetches data from an API to ensure up-to-date information.
- Share news
- Open the source of the news
- Renders images associated with articles using the Coil library.
- Utilizes Timber for logging to enhance debugging and monitoring.

## Technologies Used
- **Jetpack Compose**: Modern UI toolkit for building native Android UI.
- **Retrofit**: HTTP client for making API requests and handling responses.
- **Coil**: Image loading library for Android.
- **Timber**: Logging library for better debugging and monitoring.

## Installation
1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the application on an Android device or emulator.
4. Place your NEWS_KEY(api key from - [NewsApi](https://newsapi.org/)) into apikeys.properties(create this file in root dir.)

## Configuration
- Ensure internet connectivity for fetching news data from the API.

## Usage
- Upon launching the application, select a category from the navigation drawer to view the corresponding news articles.
- Tap on an article to view its details.

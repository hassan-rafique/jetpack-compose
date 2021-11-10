# Android Sample Project (JetPack Compose)
This repository contains a sample Android App that shows Plants data from a Mock API in Home Screen and plants from loacal db in Local Screen. This is a sample app that shows how different jetpack libraries interact with each other. The app code follows SOLID principles by implementing Clean Architecture. The basic purpose of this project is to show how Android apps are structured and developed at [DevCrew.IO](https://devcrew.io/).

## Clean Architecture Implementation
The project has the following three packages.
- **Data**
Layer that contains repositories, API (Network), Persistence DB.
- **Domain**
Layer that  contains Entities, Use Cases, and Repository interfaces.
- **Presentation**
Layer that contains UI related stuff like Views and ViewModel etc

## Screenshorts

Home                       |  Local                    |  Drawer                   |  Detail
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------
![Screenshot_1632739577](/uploads/2565532f3fef78ee180060e1fd6cda89/Screenshot_1632739577.png) | ![Screenshot_1632739639](/uploads/2124cfe1c53775c81ae9715dd7fdba55/Screenshot_1632739639.png) | ![Screenshot_1632739582](/uploads/e2409d8e216fa78f96c3faa9ad9f0691/Screenshot_1632739582.png) | ![Screenshot_1632739649](/uploads/f65783ba3b67f5427035af0f99614ae5/Screenshot_1632739649.png)

## Build With
This project follow MVVM base Clean Architecture. The following tools and technologies have been used to develop:

### Tools and Technology

|**Tool**|**Version**|
| :- | :- |
|Android Studio|Android Studio Arctic Fox or above|
|Kotlin|1.5.21|
|JetPack Compose|1.0.2|
|Gradle|7.0.2|
|JDK|11|

### JetPack Libraries
The following libraries have used in this project:
- JetPack Compose
- Hilt DI
- Navigation Component
- Room
- ViewModel
- LiveData
- Retrofit
- Kotlin Coroutines
- Lifecycle aware 

## Getting Starting

### Prerequisite

Before you set up the project please make sure you have installed required min versions of tools installed mentioned in the above ** Development Tools table**. Otherwise you may come to build errors.
### Installation
Here are simple steps to setup project:

- Clone the repo

|https://gitlab.com/devcrew.io/jetpack-compose.git|
| - |
- Make sure you have checked out master branch
- Open project in your preferred IDE (Android Studio)

### Usage
You can run and test the app on Android devices. To build and & run the app simply press the RUN button from Android Studio.

## Author
Ali Rehan (Software Engineer at [DevCrew.IO](https://devcrew.io/)).

## Contributing
Contributions, issues, and feature requests are welcome!

## Show your Support
Give a start if this project helped you.

## License
Copyright © 2021, [DevCrew.IO](https://devcrew.io/)


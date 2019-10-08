# Hangman Game Android Mobile Application
> This is an Application built in Android Studio for a mobile platform. This is a simple implementation of a well-known Hangman Game. The player has a certain number of tries to guess the encoded word.

## Table of contents
* [General info](#general-info)
* [Technologies and APIs](#technologies-and-apis)
* [Features](#features)
* [Status](#status)
* [Contact](#contact)

## General info
The game starts when the "New Game" button is clicked. After choosing a letter, the user will be notified whether the letter was correct or not. If correct the letter will be displayed in the proper area, if incorrect, another body part will hang. The game ends when the user successfully identifies the word or is completely hung. 

## Technologies and APIs
* Android Studio
* Version: Andriod Lollipop 5.1.1

## Features
Apart from the basic functionality, the game includes a "Hint" button. The first time it is clicked it displays a hint message BUT it costs the user a turn. The second time it is clicked it disables half of the remaining letters (that are not part of the word) BUT it costs the user a turn. After the second click the "Hint" button is disabled.
The state of the game is preserved on device rotation.

## Status
Project is: _finished_

## Contact
Created by Timothy Mirzoian - contact me at mirzoiantim@gmail.com

# skeleton-android
Simple skeleton Android app with modern dependencies set up.
- Kotlin
- Dagger 2 for Android
- MVVM from arch components
- RxJava2
- RxRetrofit

Basic private messanger app implemented on top of the skeleton.

It works as follows:
- Bob sends a message. Message is saved to Bob's database and sent over to a server.
- Alice receives the message from server, saves it hers database.
- After retrieved the message is deleted from server.
- Bob and Alice has the only copies of the message until they delete it on their devices.

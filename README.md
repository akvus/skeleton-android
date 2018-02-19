# skeleton-android
A simple app set up with all the necessary tools to start a new modern Android project.

With a simple implementation of a private messenger between two parties. Bob saves all messages in the local database and sends them to the server. Once Alice retrieve Bob's messages from the server they are deleted on the server. Alice saves Bob's messages in hers database.
Messages are available to download from the server only once, after what they are destroyed and the only copies are left on the two devices of Alice and Bob (until they delete them).
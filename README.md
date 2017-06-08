# UnRootBeer
## About
UnRootBeer is an [Xposed Framework](http://repo.xposed.info/) module that will disable the root detection methods performed by the useful [RootBeer](https://github.com/scottyab/rootbeer) library. I created this utility for security testing of applications using the RootBeer library without needing to rely on frameworks such as [RootCloak](http://repo.xposed.info/module/com.devadvance.rootcloak2).

## Usage
You will need to root your test device and install the Xposed Framework. Next, you can 

    $ git clone https://github.com/jakev/unrootbeer
    $ cd unrootbeer
    $ ./gradlew installDebug

Optionally, you can install the pre-built copy to avoid using Gradle:

    $ git clone https://github.com/jakev/unrootbeer
    $ cd unrootbeer
    $ adb install ./out/jakev.unrootbeer-debug.apk

## License
UnRootBeer is released under the Apache Software License 2.0.


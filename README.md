Java Twitch Plays
=========

JTP is a Java Application for parsing twitch chat commands into input.

---




> JTP is designed to allow setting up a <b> twitchplayspokemon </b> like stream up easily and with little to no difficulty.
> it is distributed under a MIT License to allow modification and redistribution to contribute to the community.

Version
----

1.0

Acknowledgements
-----------

JTP is developed using the following technolegy

* [EclipseIDE] - A Java IDE.
* [PircBot] - a super fast port of Markdown to JavaScript

Installation
--------------
<b> DOWNLOAD SOURCE </b>
```
    > Download .ZIP or Clone from GitHub Respitory
    > Install to your eclipse IDE
    > Edit Source & Recompile
```
---
<b> DOWNLOAD JAR </b>
```
    > Download .RAR package
    > Extract & Configure jtp.ini & cmd.ini
    > Run 
```

Configuration
-------------
<b> jtp.ini </b>

```
    acc_name = exampleaccounthere
    acc_auth = oauth:abcdefghijkl1234567890
    listen_channel = examplechannelhere
    num_of_commands = (number of commands in cmd.ini)
```
---
<b> cmd.ini </b>

``` 
    acel,38,1000     - Channel command (twitch ommand, keycode, hold time)
    
    Channel Command  - Message that triggers the key
    Key              - KeyCode of the key to trigger
    Hold Time        - How long to hold the key down in millis
```

License
----

MIT
Copyright (C) 2014 Matthew Allen

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


[EclipseIDE]:https://www.eclipse.org/
[PircBot]:http://www.jibble.org/pircbot.php

    

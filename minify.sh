#!/bin/bash
#84mb -> 73mb
# "name" -> "n"
# "address -> "a"
# "mol" -> "m"
# "eik" -> "e"


cat brra.json | sed 's/"name"/"n"/g'|sed 's/"address"/"a"/g'|sed 's/"mol"/"m"/g'|sed 's/"eik"/"e"/g' >>brra.minified.json

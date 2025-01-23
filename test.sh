#!/bin/bash

WATCH_DIR=$(realpath $(dirname $0))
WATCH_FILE=$WATCH_DIR/src/main/java/PalindromeChecker.java

gradle build > /dev/null 2>&1

if [ ! -f $WATCH_DIR/code.java ]; then 
    ln -s $WATCH_FILE $WATCH_DIR/code.java;
    echo "Created symlinked code.java."
fi

echo "Creating HTTP server... (check the ports tab)"
pkill -9 -f "http.server 8080"
python3 -m http.server 8080 --directory $WATCH_DIR/build/reports/tests/test > /dev/null 2>&1 &
SERVER_PID=$!
echo "Done. Please make changes to your code in the file 'code.java'."

while true; do
    inotifywait -e modify $WATCH_FILE > /dev/null 2>&1

    echo "Change detected in .java files. Running 'gradle build'..."
    gradle build > /dev/null 2>&1
    echo "Done. Refresh the page to retrieve your test results."
done

kill -9 $SERVER_PID > /dev/null 
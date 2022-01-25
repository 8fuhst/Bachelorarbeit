'use strict';

// TODO: Zugangskontrolle und Fragebogen

var current = "";

function requestWord() {
    const url = "localhost:8080/word"; // TODO: Backend URL!
    const request = new XMLHttpRequest();
    request.addEventListener('readystatechange', () => {
       if(request.readyState === 4) {
           current = request.responseText;
           document.getElementById("word").innerHTML = request.responseText;
       }
    });
    request.open('GET', 'http://localhost:8080/word')
    request.send()
}

var subtract = 0;
var typingData = {};

document.getElementById("typed").addEventListener("keydown", function (event) {
    var key_name = event.key.toLowerCase();
    var down_time = event.timeStamp;
    var str = `${key_name}_down`;
    var relative_time = 0;

    if(str.concat("_1") in typingData) {
        str += "_2";
    }
    else {
        str += "_1";
    }
    if(Object.keys(typingData).length === 0) {
        subtract = down_time;
    }
    relative_time = down_time - subtract;
    typingData[str] = relative_time;
    // TODO: Implement
});

document.getElementById("typed").addEventListener("keyup", function (event) {
    var key_name = event.key.toLowerCase();
    var up_time = event.timeStamp;
    var str = `${key_name}_up`;
    var hold_str = `${key_name}_hold`;
    var relative_time = 0;
    var hold_time = 0;
    if(str.concat("_1") in typingData) {
        str += "_2";
        hold_str += "_2";
    }
    else {
        str += "_1";
        hold_str += "_1";
    }
    relative_time = up_time - subtract;
    hold_time = relative_time - typingData[str.replace("_up", "_down")];
    typingData[str] = relative_time;
    typingData[hold_str] = hold_time;
    console.log(typingData);

    // TODO: Implement

    if(document.getElementById("typed").value === current) {
        if(Object.keys(typingData).length == current.length*3) { //Check for clear typing (no typos etc.)
            // TODO: Send Data to Backend for Database
            // TODO: After implementing: Check if fast typing still pushes past hold and up times into next Object!
        }
        document.getElementById("typed").value = '';
        typingData = {};
        requestWord();
    }
});
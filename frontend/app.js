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

var typingData = {

};

document.getElementById("typed").addEventListener("keydown", function (event) {
    // TODO: Implement
});

document.getElementById("typed").addEventListener("keyup", function (event) {
    // TODO: Implement
    if(document.getElementById("typed").value === current) {
        // TODO: Send Data to Backend for Database
        document.getElementById("typed").value = '';
        requestWord();
    }
});
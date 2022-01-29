var id_assigned = false;
var id;

function requestID() {
    const url = "http://localhost:8080/rest/ID";
    const request = new XMLHttpRequest();
    request.addEventListener('readystatechange', () => {
        console.log(request.readyState)
        if(request.readyState === 4) {
            id = request.responseText
        }
    });
    request.open('GET', url, false)
    request.send()

}

function swapIDText() {
    if(document.getElementById("no_id").checked) {
        if(!id_assigned) {
            requestID();
            id_assigned = true;
        }
        document.getElementById("id_entry").innerHTML = "Please remember this ID if you want to return later and enter more data: " + id;
    }
    else if(document.getElementById("yes_id").checked) {
        document.getElementById("id_entry").innerHTML = 'Please enter your ID: ' + '<input id="id_input" type="number" min="1">';
        document.getElementById("id_input").addEventListener("change", function (event) {
            id = document.getElementById("id_input").value;
            id_assigned = true;
        });
    }
    if(id_assigned) {
        document.getElementById("start_button").disabled = false;
    }
}

document.getElementById("no_id").addEventListener("change", function (event) {
    swapIDText();
});

document.getElementById("yes_id").addEventListener("change", function (event) {
    swapIDText();
});
var id_assigned = false;
var id;
var age;
var keyboard_layout = "qwertz";
var keyboard = "laptop";
var proficiency = "1";
var comp_sci_student = "Yes";

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
        document.getElementById("id_input").disabled = true;
        if(!id_assigned) {
            requestID();
            id_assigned = true;
            document.getElementById("id_input").value = id;
        }
    }
    else if(document.getElementById("yes_id").checked) {
        document.getElementById("id_input").disabled = false;
        document.getElementById("id_input").addEventListener("keyup", function (event) {
            id = document.getElementById("id_input").value;
            if(id !== "") {
                id_assigned = true;
                document.getElementById("start_button").disabled = false;
            }
            else {
                id_assigned = false;
                document.getElementById("start_button").disabled = true;
            }
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

document.getElementById("start_button").onclick = function () {
    proceed();
    location.href = "http://localhost:63343/frontend/collectionSite.html";
};

function proceed() {
    keyboard_layout = document.getElementById("layout").value
    age = document.getElementById("age").value
    if(proficiency > 3) {
        proficiency = 3;
    } else if(proficiency < 0) {
        proficiency = 0;
    } else {
        proficiency = document.getElementById("proficiency").value;
    }
    if(document.getElementById("yes_study").checked) {
        comp_sci_student = "True";
    }
    else {
        comp_sci_student = "False";
    }
    if(document.getElementById("desktop_keyboard").checked) {
        keyboard = "desktop";
    }
    else {
        keyboard = "laptop";
    }
    sessionStorage.setItem("layout", keyboard_layout);
    sessionStorage.setItem("age", age);
    sessionStorage.setItem("keyboard", keyboard);
    sessionStorage.setItem("id", id);
    sessionStorage.setItem("proficiency", proficiency);
    sessionStorage.setItem("student", comp_sci_student);
}
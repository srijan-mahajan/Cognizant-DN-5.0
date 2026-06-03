console.log("Welcome to the Community Portal");

window.onload = () => {
    alert("Page Loaded");
};

class Event {

    constructor(name, category, seats) {
        this.name = name;
        this.category = category;
        this.seats = seats;
    }
}

Event.prototype.checkAvailability = function() {
    return this.seats > 0;
};

const events = [

    new Event("Music Fest", "Music", 20),
    new Event("Dance Workshop", "Workshop", 10),
    new Event("Cricket Tournament", "Sports", 15)

];

function displayEvents(list) {

    const container =
        document.querySelector("#eventContainer");

    container.innerHTML = "";

    list.forEach(event => {

        const card =
            document.createElement("div");

        card.className = "eventCard";

        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>${event.category}</p>
            <p>Seats : ${event.seats}</p>
            <button onclick="registerUser('${event.name}')">
            Register
            </button>
        `;

        container.appendChild(card);
    });
}

displayEvents(events);

function registerUser(eventName){

    try{
        alert(`Registered for ${eventName}`);
    }
    catch(error){
        console.log(error);
    }
}

document
.getElementById("categoryFilter")
.onchange = function(){

    const value = this.value;

    if(value === "all"){
        displayEvents(events);
    }
    else{
        displayEvents(
            events.filter(
                e => e.category === value
            )
        );
    }
};

document
.getElementById("feedback")
.addEventListener("keyup", ()=>{

    document.getElementById("count")
    .innerText =
    document.getElementById("feedback")
    .value.length;
});

document
.getElementById("phone")
.onblur = function(){

    if(this.value.length < 10){
        alert("Invalid Phone Number");
    }
};

document
.getElementById("promoVideo")
.oncanplay = ()=>{

    document.getElementById("videoMsg")
    .innerText =
    "Video Ready To Play";
};

document
.getElementById("eventType")
.onchange = function(){

    localStorage.setItem(
        "eventType",
        this.value
    );
};

window.addEventListener(
    "load",
    ()=>{

        const saved =
        localStorage.getItem(
            "eventType"
        );

        if(saved){
            document.getElementById(
                "eventType"
            ).value = saved;
        }
    }
);

document
.getElementById("eventForm")
.addEventListener(
"submit",
async function(e){

    e.preventDefault();

    document.getElementById(
        "message"
    ).value =
    "Registration Successful";

    const data = {
        name:this.elements.name.value,
        email:this.elements.email.value
    };

    try{

        await fetch(
        "https://jsonplaceholder.typicode.com/posts",
        {
            method:"POST",
            body:JSON.stringify(data),
            headers:{
                "Content-Type":
                "application/json"
            }
        });

    }
    catch(error){
        console.log(error);
    }
});
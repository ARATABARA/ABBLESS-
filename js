// ==========================
// ABBLESS V2 ORIGINAL JS
// BASIC SYSTEM
// ==========================


// Show one page and hide others

function showPage(pageId){

    document
    .querySelectorAll(".page")
    .forEach(page=>{

        page.classList.remove("active");

    });


    document
    .getElementById(pageId)
    .classList.add("active");

}




// ==========================
// SPLASH TO PRESENTATION
// ==========================


setTimeout(()=>{

    showPage("presentation");

},2000);





// ==========================
// REGISTER SYSTEM
// ==========================


function registerUser(){


    let name =
    document.getElementById("username").value;



    let email =
    document.getElementById("email").value;



    let password =
    document.getElementById("password").value;



    if(name==="" || email==="" || password===""){

        alert("Please complete all fields");

        return;

    }



    localStorage.setItem(
        "ABBLESS_User",
        name
    );


    localStorage.setItem(
        "ABBLESS_Email",
        email
    );



    alert(
        "Welcome to ABBLESS "+name
    );



    showPage("home");


}
// ==========================
// HOME FEATURES NAVIGATION
// ==========================


function openFeature(featureId){

    showPage(featureId);

}





// ==========================
// TOP MENU BUTTONS
// ==========================


function openSettings(){

    showPage("settings");

}



function openMenu(){

    showPage("menu");

}





// ==========================
// ADMIN SYSTEM
// ==========================


let adminMode = false;



function activateAdmin(){


    adminMode = true;



    document
    .getElementById("adminButton")
    .style.display="block";



    alert(
        "Admin access activated"
    );


}





function openAdmin(){


    if(adminMode){

        showPage("adminPanel");

    }

    else{

        alert(
            "Admin access only"
        );

    }


}





// ==========================
// SEARCH SYSTEM
// ==========================


function searchABBLESS(){


    let search =
    prompt(
        "Search ABBLESS"
    );



    if(search){

        alert(
            "Searching for: "+search
        );

    }


}





// ==========================
// LOGOUT
// ==========================


function logout(){


    localStorage.removeItem(
        "ABBLESS_User"
    );


    alert(
        "Logged out"
    );


    showPage(
        "presentation"
    );


}





// ==========================
// CHECK USER
// ==========================


window.onload=function(){


let user =
localStorage.getItem(
"ABBLESS_User"
);



if(user){

console.log(
"Welcome back "+user
);

}


};
// ==========================
// ABBLESS AI DEMO
// ==========================


function askAI(){


let question =
document.querySelector("#ai input").value;



if(question===""){

alert(
"Ask ABBLESS AI something"
);

return;

}



alert(
"ABBLESS AI: I will help you learn about "+question
);


}




// ==========================
// QUIZ SYSTEM
// ==========================


function checkAnswer(answer){


if(answer==="HTML"){

alert(
"Correct answer ✅"
);

}

else{

alert(
"Try again ❌"
);

}


}





// ==========================
// ADMIN ACTIONS
// ==========================


function addLesson(){


alert(
"New lesson added"
);


}



function editLesson(){


alert(
"Lesson updated"
);


}



function deleteLesson(){


alert(
"Lesson removed"
);


}



function sendAnnouncement(){


alert(
"Announcement sent to users"
);


}



function manageUsers(){


alert(
"User management opened"
);


}



function changePrice(){


let price =
prompt(
"Enter new subscription price"
);



if(price){

alert(
"Subscription price changed to "+price
);

}


}





// ==========================
// PAYMENT DEMO
// ==========================


function payNow(){


alert(
"Choose payment method: Lumicash, EcoCash, Airtime"
);


}




// ==========================
// APP READY
// ==========================


console.log(
"ABBLESS V2 Original is running successfully"
);
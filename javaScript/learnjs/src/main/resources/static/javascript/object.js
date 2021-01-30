
let info = {
    firstName : "mohamed",
    lastName : "ahmed",
    age : 27,
};

function promptToObject() {
    //apple assigned to buy
let buy = prompt("which one do u want to buy?", "apple");

let choosen = {
    // buy has the varuable name of apple 
    [buy] : 50,
};

// print apple that assigned to buy
document.write(choosen.apple);
}

function userInfo(name, age) {
    return {
        name : name,
        age : age,
    };
}

function iterateInfo() {
    for(let index in info) {
        document.write(info[index] + "<br>");
    }
}



// copy by refrence 
let someInfo = info;

// Clone or copy the Object 
function cloneObject() {

    let clone = {};
    for(let x in info ) {
        clone[x] = info[x];
    }

    return clone;
}


let active = { isActive : true };
let loggedIn = { isLogged : true };

// assign values to clone object 
Object.assign(cloneObject, active, loggedIn);

// nested object an object inside anoter object 
let nestedObject = {
     someObject : {
        name : "mo"
    }
};

// copy all properties of cloneObject to clone 
let clone  = Object.assign({}, cloneObject());

// reassign active inside clone into false
Object.assign(clone, { active : false});
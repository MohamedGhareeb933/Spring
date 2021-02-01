
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

function anyUser() {

    let user = {};

    user = {
        name : "mohamed",
        age : 27,
        sayHi() {
            document.write(this.name);
            }
        }

    return user;
}

// when allocate new aUser 
function aUser(name, state) {

    //this = {}; 
    this.name = name;
    this.state = state;

    // return this

    /**
     * or similar to 
     *  let user = {name: name , state : state}
     */

     this.sayHi = function() {
         document.write(`hi ${this.name}`);
     }
}

// creating a constructor
function docwrite() {

    document.write(new aUser("ahmed", flase));

    let user = new aUser("mohamed", true);
}


// optional chainning 

function optionalChainning() {

    //return undefined
    aUser?.name?.address;
    // works similar to 
    if(aUser != null && aUser.name != null && aUser.name.address !=null) {
    }

    // best practice 
    // auser and name is defined but address is optional 
    aUser.name?.address;

}

function symboll() {

    // special type symbol dosnt auto convert to a string 

        let id1 = Symbol("id");
        let id2 = Symbol("id");

        alert(id1 == id2) // false
        //alert (id1) // typeError cant convert symbol to string 

        // convert symbol to string 
        alert(id1.toString());
}
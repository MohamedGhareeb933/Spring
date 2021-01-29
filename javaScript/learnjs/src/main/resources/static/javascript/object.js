
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
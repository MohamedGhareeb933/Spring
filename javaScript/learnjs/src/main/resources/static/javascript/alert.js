
function popAlert() {
    // message is const variable which mean it's unchangeable
    const messsage = "hello js";
    alert(messsage);
}

function writedocument() {
    // let is like var with one excpetion 
    // let is a block scope which mean we can't use it before define 
    // var is function scope which me can use it before creating it but will return undefined
    let message = "hello js";
    document.write(message);
}

function promptWindow() {
    // prompt is asking to insert a value into modal window
    // second param is default value that is filled in insert as suggestion or default
    let x = prompt("are you sure you wants to print ", 100);
    alert(`${x} is printed`);
}

function confirmModal() {
    let ask = confirm("this is a confirm message");
}

function bigInt() {
    // A Big int Value is created by appending n to the end of integer
    let x = 12345678912345678912345678n;
}

function embed() {
    // embed variable
    let name = "mohamed";
    alert(`hello, ${name}`);

    document.write(`the result of  1 + 2 is ${1 + 2}`);
}

function type() {
    // will return the Type of Math which is object 
    return typeof Math;
}

function conversion() {
    let value = true;
    document.write("value type before conversion: " + typeof value + "<br>");
    value = String(value);
    document.write("value type after conversion: " + typeof value + "<br>");

    // converts non number into number
    let value = +true;

}

function concatination() {
    // if one operant is a string other operaned turned into string
    let x = 2 * 10 + "50"; // output : 2050
}


//function expression
let name = function() {
    return "mohamed";
}


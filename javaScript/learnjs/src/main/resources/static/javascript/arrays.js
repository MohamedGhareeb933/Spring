
function arrayFunc() {

let stats = ["points", "assist", "block", "cross"];

for(let index of stats) {
    document.write(`${index} `);
    }

}

function removeAndReplace() {
    let arr = ["I", "study", "JavaScript", "right", "now"];

    // from element 2 remove 1 element and replace "strings" after element 2 
    arr.splice(2, 1, "front", "end");

    document.write(`<br> ${arr}`);
}


function removeAndReplace1() {
    let arr = ["I", "study", "JavaScript", "right", "now"];

    // from element 2 remove 3 elements and replace "strings" after element 0
    arr.splice(0, 3, "we", "eat");

    document.write(`<br> ${arr}`);
}


function negativeRemoveAndReplace() {
    let arr = ["I", "study", "JavaScript", "later"];

    // -1 specifiy the Element Before which is size - 1
    arr.splice(-1, 0, "for");

    document.write(`<br> ${arr}`);
}


function slice() {
    let arr = ["I", "study", "JavaScript", "later"];

    // copy element  0 > 3
    document.write(`<br> ${arr.slice(0 , 3)}`);

    // copy element size
    document.write(`<br> ${arr.slice(-1)}`);

    // copy element size -1 >= size
    document.write(`<br> ${arr.slice(-2)}`);
}

function concat() {

    let arr = [1, 2];

    let array = {
        "three" : 3,
        "four" : 4
    };

    document.write(`<br> ${arr.concat(array)}`);

}


function forEach() {

   let arr = ["one", "two", "three"]
   arr.forEach(element => {
    document.write(`<br> ${element}`);
   });
}


function forEachTwoParam() {

    let arr = ["one", "two", "three"]
    arr.forEach((element, index) => {
     document.write(`<br> ${element} at ${index}`);
    });
 
 }


 function find() {
    let users = [
        {id : 0, name :"mohamed"},
        {id : 1, name :"ghareeb"}
    ];

    let finduser = users.find(index => index.id == 0);

    document.write(`<br> ${finduser.name}`)

 }

 // map or transoform 

 function map() {
     let randomString = ["one", "aplle", "cat"]
        
     let trans = randomString.map(index => index.length);

     document.write(`<br> ${trans}`)

}
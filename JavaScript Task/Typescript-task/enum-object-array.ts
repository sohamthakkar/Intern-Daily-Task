// Button event
var btn = document.querySelector("button") ! as HTMLButtonElement; // dom-element declaration
var num1 = document.getElementById("num1")! as HTMLInputElement;// dom-element declaration
var num2 = document.getElementById("num2") ! as HTMLInputElement;// dom-element declaration

function addition(num1: number, num2: number) {
    return num1 + num2;
}
btn.addEventListener("click", function () {
    console.log("btn clicked")

    console.log(addition(+num1.value, +num2.value));
});
//button event completed

//Enum
enum Role {ADMIN, READ_ONLY, AUTHOR};


//object
const person= {
    name: "Jay",
    age: 23,
    hobbies: ["Sports", "Cooking"], //array
    address:[1,"abcd", "pune", "maharashtra", "india", 400001],//tuple
    role: Role.ADMIN
}
console.log(person.hobbies[0]);
console.log(person.hobbies);

for(let hobby of person.address){
    console.log(hobby);
}

//used enums in object
if(person.role === Role.AUTHOR){
    console.log("isAuthor");
}
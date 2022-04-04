validation = () => {
    let fname = document.forms["myForm"]["fname"].value;
    let lname = document.forms["myForm"]["lname"].value;
    let email = document.forms["myForm"]["email"].value;
    let mobile = document.forms["myForm"]["mobile"].value;
    let address = document.forms["myForm"]["address"].value;
    let condition = document.forms["myForm"]["condition"].value;
    if(fname == ""){
        document.getElementById("fname").style.borderColor = "red";
        document.getElementById("fnameError").innerHTML = "Please Enter Your First Name";
        document.getElementById("fnameError").style.color = "red";
        return false;
    }else
    if(lname == ""){
        document.getElementById("lname").style.borderColor = "red";
        document.getElementById("lnameError").innerHTML = "Please Enter Your Last Name";
        document.getElementById("fnameError").style.color = "red";
        return false;
    }else
    if(email == ""){
        document.getElementById("email").style.borderColor = "red";
        document.getElementById("emailError").innerHTML = "Please Enter Your Email Name";
        document.getElementById("fnameError").style.color = "red"
        return false;
    }else
    if(mobile == ""){
        document.getElementById("mobile").style.borderColor = "red";
        document.getElementById("numberError").innerHTML = "Please Enter Your Mobile Number";
        document.getElementById("fnameError").style.color = "red"
        return false;
    }else
    if(address == ""){
        document.getElementById("address").style.borderColor = "red";
        document.getElementById("addError").innerHTML = "Please Enter Your Address";
        document.getElementById("fnameError").style.color = "red"
        return false;
    }
    // if(condition == ""){
    //     document.getElementById("fname").style.borderColor = "red";
    //     document.getElementById("fnameError").innerHTML = "Please Enter Your First Name";
    //     return false;
    // }

}

